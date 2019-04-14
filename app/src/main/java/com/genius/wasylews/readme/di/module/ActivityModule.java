package com.genius.wasylews.readme.di.module;

import com.genius.wasylews.readme.presentation.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface ActivityModule {

    @ContributesAndroidInjector
    MainActivity mainActivity();
}
