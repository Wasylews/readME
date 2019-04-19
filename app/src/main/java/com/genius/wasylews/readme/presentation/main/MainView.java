package com.genius.wasylews.readme.presentation.main;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

interface MainView extends MvpView {

    @StateStrategyType(SkipStrategy.class)
    void setNightMode(boolean isNight);

    void showSystemUi();

    void hideSystemUi();
}
