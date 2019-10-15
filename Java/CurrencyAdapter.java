package com.example.nitishkumar.currencyconverter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Nitish Kumar on 12-07-2017.
 */

public class CurrencyAdapter extends ArrayAdapter<Country> {
    public CurrencyAdapter(@NonNull Context context, @NonNull List<Country> country) {
        super(context, 0, country);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View dropDownIteam = convertView;
        if (dropDownIteam == null) {
            dropDownIteam = LayoutInflater.from(getContext()).inflate(R.layout.spinneriteam, parent, false);
        }
        Country currentCountry = getItem(position);
        TextView countryName = dropDownIteam.findViewById(R.id.text_country);
        countryName.setText(currentCountry.getmCurrencyName());

        ImageView flag = dropDownIteam.findViewById(R.id.flag_image);
        flag.setImageResource(currentCountry.getmImageResId());
        return dropDownIteam;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View dropDownIteam = convertView;
        if (dropDownIteam == null) {
            dropDownIteam = LayoutInflater.from(getContext()).inflate(R.layout.spinneriteam, parent, false);
        }
        Country currentCountry = getItem(position);
        TextView countryName = dropDownIteam.findViewById(R.id.text_country);
        countryName.setText(currentCountry.getmCurrencyName());
        ImageView flag = dropDownIteam.findViewById(R.id.flag_image);
        flag.setImageResource(currentCountry.getmImageResId());
        return dropDownIteam;
    }
}
