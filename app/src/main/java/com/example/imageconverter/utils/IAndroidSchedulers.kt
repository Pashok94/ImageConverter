package com.example.imageconverter.utils

import io.reactivex.rxjava3.core.Scheduler

interface IAndroidSchedulers {
    fun getMainThread(): Scheduler?
}