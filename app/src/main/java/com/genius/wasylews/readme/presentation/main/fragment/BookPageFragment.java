package com.genius.wasylews.readme.presentation.main.fragment;

import android.os.Bundle;
import android.widget.TextView;

import com.genius.wasylews.readme.R;
import com.genius.wasylews.readme.presentation.base.BaseFragment;

import butterknife.BindView;

public class BookPageFragment extends BaseFragment {

    @BindView(R.id.page_render) TextView pageRender;

    public static final String KEY_PAGE = "page_number";

    public static BookPageFragment newInstance(int page) {
        BookPageFragment fragment = new BookPageFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_PAGE, page);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected void onViewReady(Bundle savedInstanceState) {
        int pageNumber = getArguments().getInt(KEY_PAGE);
        pageRender.setText("page " + pageNumber);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_book_page;
    }
}
