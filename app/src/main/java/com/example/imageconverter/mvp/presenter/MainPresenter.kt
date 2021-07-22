package com.example.imageconverter.mvp.presenter

import com.example.imageconverter.mvp.model.imageConverter.IImageConverter
import com.example.imageconverter.mvp.view.MainView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter

class MainPresenter(val converter: IImageConverter) : MvpPresenter<MainView>() {
    private var disposable: Disposable? = null

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        println("$viewState")
    }

    fun startConverting(uri: String) {
        disposable =
            converter.convertImage(uri).observeOn(AndroidSchedulers.mainThread()).subscribe({       //мокнуть планировщик
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