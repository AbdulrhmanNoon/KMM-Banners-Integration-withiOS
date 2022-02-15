Pod::Spec.new do |spec|
  spec.name = 'KMMBannersIntegrationExample'
  spec.version = '1.0.0'
  spec.homepage = 'https://www.cocoapods.org'
  spec.source = { :git => "git@github.com:AbdulrhmanNoon/KMM-Banners-Integration-withiOS.git", :tag => "#{spec.version}" }
  spec.authors = 'Abdulrhman noon'
  spec.license = { :type => "MIT", :file => "LICENSE" }
  spec.summary = 'KMM shared code pod'
  spec.static_framework = true
  spec.vendored_frameworks = "shared.xcframework"
  spec.libraries = "c++"
  spec.module_name = "#{spec.name}_umbrella"
  spec.ios.deployment_target = '9.0'
end