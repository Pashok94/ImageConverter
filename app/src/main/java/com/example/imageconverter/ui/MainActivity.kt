package com.example.imageconverter.ui

import android.os.Bundle
import com.example.imageconverter.databinding.ActivityMainBinding
import com.example.imageconverter.mvp.model.imageConverter.ImageConverter
import com.example.imageconverter.mvp.model.uriConverter.UriConverter
import com.example.imageconverter.mvp.presenter.MainPresenter
import com.example.imageconverter.mvp.view.MainView
import com.example.imageconverter.utils.AndroidSchedulers
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {
    private var vb: ActivityMainBinding? = null
    val presenter by moxyPresenter {
        MainPresenter(AndroidSchedulers(), ImageConverter(UriConverter()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        initStartBtn()
        setContentView(vb?.root)
    }

    override fun processingConvert(percent: Int) {
        vb?.informTv?.text = "Преобразование завершено на $percent%"
    }

    override fun convertComplete() {
        vb?.informTv?.text = "Преобразование завершено"
    }

    private fun initStartBtn() {
        vb?.btnStart?.setOnClickListener {
            presenter.startConverting("path")
        }
    }
}