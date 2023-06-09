package com.example.lab5;

import android.content.Context;

import androidx.annotation.Nullable;

public class BookLoader extends AsyncTaskLoader<String> {

    private String mQueryString;

    BookLoader(Context context, String queryString) {
        super(context);
        mQueryString = queryString;
    }

    @Override
    protected void onStartLoading() {

        forceLoad();
    }

    private void forceLoad() {
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return NetworkUtils.getBookInfo(mQueryString);
    }
}