package com.example.imageconverter.mvp.model.uriConverter

import java.net.URI

interface IUriConverter {
    fun uriToString(uri: URI): String
    fun stringToUri(string: String): URI
}