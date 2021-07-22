package com.example.imageconverter.mvp.model.imageConverter

import io.reactivex.rxjava3.core.Observable

interface IImageConverter {
    fun convertImage(uri: String): Observable<Int>
}