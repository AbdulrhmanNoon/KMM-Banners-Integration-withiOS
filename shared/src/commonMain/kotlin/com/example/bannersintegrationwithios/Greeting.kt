package com.example.bannersintegrationwithios

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}