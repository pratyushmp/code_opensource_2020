package com.example.nitishkumar.currencyconverter;


class Country {

    private int mImageResId;
    private String mCurrencyName;
    private Double mExchangeRate;

    Country(String name, Double value) {
        this.mCurrencyName = name;
        this.mExchangeRate = value;
    }

    void setmImageResId(int mImageResId) {
        this.mImageResId = mImageResId;
    }

    int getmImageResId() {
        return mImageResId;
    }

    Double getmExchangeRate() {
        return mExchangeRate;
    }

    String getmCurrencyName() {
        return mCurrencyName;
    }
}
