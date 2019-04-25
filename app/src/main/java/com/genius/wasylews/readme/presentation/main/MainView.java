package com.genius.wasylews.readme.presentation.main;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

interface MainView extends MvpView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void setNightMode(boolean isNight);

    void showSystemUi();

    void hideSystemUi();
}
