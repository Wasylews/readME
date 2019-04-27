package com.genius.wasylews.readme.data.service;

import com.francescocervone.rxdrive.RxDrive;
import com.genius.wasylews.readme.domain.model.Book;

import javax.inject.Inject;

import io.reactivex.Single;

public class GoogleDriveService {

    private RxDrive drive;

    @Inject
    public GoogleDriveService(RxDrive drive) {
        this.drive = drive;
    }

    public Single<Book> openBook(String path) {
        return null;
    }
}
