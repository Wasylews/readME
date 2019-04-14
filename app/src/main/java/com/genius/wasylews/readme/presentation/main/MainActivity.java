package com.genius.wasylews.readme.presentation.main;

import com.genius.wasylews.readme.R;
import com.genius.wasylews.readme.presentation.base.BaseActivity;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }
}
