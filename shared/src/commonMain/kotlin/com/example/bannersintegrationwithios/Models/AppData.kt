package com.example.bannersintegrationwithios.Models
import com.linecorp.abc.sharedstorage.SharedStorage

//interface AppData {
//    var someBoolean: Boolean
//    var someInt: Int
//    var someFloat: Float
//    var someLong: Long
//    var someString: String
//}

interface AppData {
    var someBoolean: Boolean
    var someInt: Int
    var someFloat: Float
    var someLong: Long
    var someString: String

    val someSecureString: String
}