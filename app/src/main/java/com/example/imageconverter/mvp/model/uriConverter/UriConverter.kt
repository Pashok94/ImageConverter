package com.example.imageconverter.mvp.model.uriConverter

import java.net.URI

class UriConverter: IUriConverter {
    override fun uriToString(uri: URI): String {
        return ""
    }

    override fun stringToUri(string: String): URI {
        return URI(string)
    }
}