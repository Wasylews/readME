package com.genius.wasylews.readme.presentation.main;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.genius.wasylews.readme.R;
import com.genius.wasylews.readme.presentation.base.BaseActivity;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainView {

    @InjectPresenter
    @Inject
    MainPresenter presenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @Override
    protected void onSetupView(Bundle savedInstanceState) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.item_daynight:
                presenter.onDayNightChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem dayNightModeItem = menu.findItem(R.id.item_daynight);
        updateDayNightModeItem(dayNightModeItem);
        return true;
    }

    private void updateDayNightModeItem(MenuItem menuItem) {
        if (presenter.isNightMode()) {
            menuItem.setIcon(R.drawable.ic_day);
            menuItem.setTitle(R.string.day);
        } else {
            menuItem.setIcon(R.drawable.ic_night);
            menuItem.setTitle(R.string.night);
        }
    }

    @Override
    public void setNightMode(boolean isNight) {
        if (isNight) {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        invalidateOptionsMenu();
    }
}
