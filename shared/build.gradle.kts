plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization") version "1.4.10"
    id("com.chromaticnoise.multiplatform-swiftpackage") version "2.0.3"
}




kotlin {
    android()
    
    listOf(
        iosX64(),
        iosArm64(),
        //iosSimulatorArm64() sure all ios dependencies support this target
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val coroutinesVersion = "1.5.2-native-mt"
        val serializationVersion = "1.3.1"
        val ktorVersion = "1.6.1"
        val sharedStorage = "com.linecorp.abc:kmm-shared-storage:1.0.2"

        val commonMain by getting {
            dependencies {

                // COROUTINES
                implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")

                // KTOR
                implementation ("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-json:$ktorVersion")
                implementation("io.ktor:ktor-client-logging:$ktorVersion")
                implementation("io.ktor:ktor-client-serialization:$ktorVersion")
                implementation("io.github.aakira:napier:2.2.0")
              //  implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationVersion")
                //Storage
                implementation(sharedStorage)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {

                // KTOR
                implementation ("io.ktor:ktor-client-android:$ktorVersion")

                // Storage
                implementation(sharedStorage)
                api(sharedStorage)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.2")
            }
        }
        val iosX64Main by getting {
            dependencies {
                // KTOR
                implementation ("io.ktor:ktor-client-ios:$ktorVersion")

                // Storage
                implementation(sharedStorage)
                api(sharedStorage)
            }
        }
        val iosArm64Main by getting {
            dependencies {
                // KTOR
                implementation ("io.ktor:ktor-client-ios:$ktorVersion")

                // Storage
                implementation(sharedStorage)
                api(sharedStorage)
            }
        }
        //val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            //iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        //val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            //iosSimulatorArm64Test.dependsOn(this)
        }
    }

    multiplatformSwiftPackage {
        packageName("shared")
        swiftToolsVersion("5.3")
        targetPlatforms {
            iOS { v("11") }
        }
        outputDirectory(File(rootDir, "/"))
    }
}

android {
    compileSdk = 31
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 21
        targetSdk = 31
    }
}
dependencies {
    implementation("androidx.annotation:annotation:1.2.0")
}
