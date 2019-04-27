package com.genius.wasylews.readme.domain.usecase;

import com.genius.wasylews.readme.domain.base.single.SingleAsyncUseCase;
import com.genius.wasylews.readme.domain.model.Book;

import io.reactivex.Single;

public class OpenBookUseCase extends SingleAsyncUseCase<Book> {

    @Override
    protected Single<Book> buildTask() {
        return null;
    }
}
