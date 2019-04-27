package com.genius.wasylews.readme.presentation.main.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.genius.wasylews.readme.domain.model.Book;
import com.genius.wasylews.readme.presentation.main.fragment.BookPageFragment;

public class BookAdapter extends FragmentStatePagerAdapter {

    private final Book book;

    public BookAdapter(@NonNull FragmentManager fm, Book book) {
        super(fm);
        this.book = book;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return BookPageFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return book.getPageCount();
    }
}
