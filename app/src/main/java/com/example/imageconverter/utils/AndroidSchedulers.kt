package com.example.imageconverter.utils

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler

class AndroidSchedulers: IAndroidSchedulers {
    override fun getMainThread(): Scheduler? {
        return AndroidSchedulers.mainThread()
    }
}