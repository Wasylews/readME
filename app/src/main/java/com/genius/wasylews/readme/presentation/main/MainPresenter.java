package com.genius.wasylews.readme.presentation.main;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private boolean isNightMode;
    private boolean isFullScreen;

    @Inject
    public MainPresenter() {
        super();
    }

    void onDayNightChanged() {
        isNightMode = !isNightMode;
        getViewState().setNightMode(isNightMode);
    }

    boolean isNightMode() {
        return isNightMode;
    }

    void bookRenderClicked() {
        if (isFullScreen) {
            getViewState().showSystemUi();
        } else {
            getViewState().hideSystemUi();
        }
        isFullScreen = !isFullScreen;
    }
}
