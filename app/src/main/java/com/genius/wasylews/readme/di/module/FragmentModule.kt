package com.genius.wasylews.readme.di.module

import com.genius.wasylews.readme.presentation.book.BookFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentModule {

    @ContributesAndroidInjector
    fun bookFragment(): BookFragment
}