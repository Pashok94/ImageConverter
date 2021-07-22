package com.example.imageconverter.mvp.presenter

import android.util.Log
import com.example.imageconverter.mvp.model.imageConverter.IImageConverter
import com.example.imageconverter.mvp.view.MainView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter

class MainPresenter(val converter: IImageConverter) : MvpPresenter<MainView>() {
    private var disposable: Disposable? = null

    fun startConverting(uri: String) {
        disposable =
            converter.convertImage(uri).observeOn(AndroidSchedulers.mainThread()).subscribe({       //мокнуть планировщик
                Log.d("deb", "$viewState")
                viewState.processingConvert(it)
            }, {
                it.printStackTrace()
            },{
                viewState.convertComplete()
            })
    }

    fun abortConverting(){
        disposable?.dispose()
    }
}