package com.genius.wasylews.readme.di.module

import com.genius.wasylews.readme.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule {

    @ContributesAndroidInjector
    fun mainActivity(): MainActivity
}