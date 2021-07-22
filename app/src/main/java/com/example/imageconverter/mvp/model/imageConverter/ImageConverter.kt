package com.example.imageconverter.mvp.model.imageConverter

import android.util.Log
import com.example.imageconverter.mvp.model.uriConverter.IUriConverter
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.net.URI

class ImageConverter(val uriConverter: IUriConverter) : IImageConverter {
    override fun convertImage(uri: String): Observable<Int> {
        return Observable.create<Int> { emmiter ->
            repeat(5) {
                Thread.sleep(800)
                emmiter.onNext(it * 20)
                Thread.sleep(200)
            }
            convertProcess(uriConverter.stringToUri(uri))
            emmiter.onComplete()
        }.subscribeOn(Schedulers.io())
    }

    private fun convertProcess(uri: URI) {
        Log.d("deb", "convertingProcess")
        Thread.sleep(2000)
    }
}