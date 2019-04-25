package com.genius.wasylews.readme.presentation.main;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Lifecycle;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.genius.wasylews.readme.R;
import com.genius.wasylews.readme.presentation.base.BaseActivity;
import com.genius.wasylews.readme.presentation.main.adapter.BookAdapter;
import com.genius.wasylews.readme.presentation.main.custom.ClickableViewPager;
import com.jakewharton.rxbinding3.view.MenuItemActionViewCollapseEvent;
import com.jakewharton.rxbinding3.view.MenuItemActionViewExpandEvent;
import com.jakewharton.rxbinding3.view.RxMenuItem;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

import javax.inject.Inject;

import butterknife.BindView;

import static com.uber.autodispose.AutoDispose.autoDisposable;

public class MainActivity extends BaseActivity implements MainView {

    @InjectPresenter
    @Inject
    MainPresenter presenter;

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.drawer_layout) DrawerLayout drawerLayout;
    @BindView(R.id.book_pager) ClickableViewPager bookPager;
    private BookAdapter bookAdapter;

    @ProvidePresenter
    MainPresenter providePresenter() {
        return presenter;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);

        bookPager.setOnItemClickListener(position -> presenter.bookRenderClicked());

        bookAdapter = new BookAdapter(getSupportFragmentManager(), 3);
        bookPager.setAdapter(bookAdapter);
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
        updateDayNightModeItem(menu.findItem(R.id.item_daynight));
        handleSearchItemActionViewEvents(menu);
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

    private void handleSearchItemActionViewEvents(Menu menu) {
        RxMenuItem.actionViewEvents(menu.findItem(R.id.item_search))
                .as(autoDisposable(AndroidLifecycleScopeProvider.from(this, Lifecycle.Event.ON_DESTROY)))
                .subscribe(menuItemActionViewEvent -> {
                    if (menuItemActionViewEvent instanceof MenuItemActionViewExpandEvent) {
                        menu.findItem(R.id.item_daynight).setVisible(false);
                    } else if (menuItemActionViewEvent instanceof MenuItemActionViewCollapseEvent) {
                        menu.findItem(R.id.item_daynight).setVisible(true);
                        invalidateOptionsMenu();
                    }
                });
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

    @Override
    public void hideSystemUi() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
        getSupportActionBar().hide();
    }

    @Override
    public void showSystemUi() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        getSupportActionBar().show();
    }
}
