package com.example.nitishkumar.currencyconverter;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.List;


class CurrencyLoader extends AsyncTaskLoader<List<Country>> {
    private String mUrl;

    CurrencyLoader(Context context, String url) {
        super(context);
        this.mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Country> loadInBackground() {

        if (mUrl == null)
            return null;
        List<Country> countries = Utility.getCountries(mUrl);
        return countries;
    }
}
