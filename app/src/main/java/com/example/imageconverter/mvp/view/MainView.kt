package com.example.imageconverter.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface MainView : MvpView {
    fun processingConvert(percent: Int)
    fun convertComplete()
}