package com.genius.wasylews.readme.di.module;

import com.genius.wasylews.readme.presentation.main.fragment.BookPageFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface FragmentModule {

    @ContributesAndroidInjector
    BookPageFragment bookPageFragment();
}
