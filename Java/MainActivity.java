package com.example.nitishkumar.currencyconverter;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements LoaderCallbacks<List<Country>> {
    private static final String FIXER_URL = "http://api.fixer.io/latest?base=USD";
    private static final int COUNTRY_LOADER_ID = 1;
    public static Context applicationContext;
    public static HashMap<String, String> countryCodes;
    private CurrencyAdapter mAdapter;
    private static final String LOG_TAG = "Hello";
    private Double currency1;
    private Double currency2;
    private List<Country> countries;
    EditText editText2;
    EditText editText1;
    public static int[] flag;
    private boolean isConnected;
    private String primaryCountry;
    private String secondaryCountry;
    private static final String message1 = "1";
    private static final String message2 = "equals";
    TextView rateUpdate;
    TextView rateUpdate2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        applicationContext = getApplicationContext();
        countryCodes = applyCodes();
        isConnected = false;
        rateUpdate = (TextView) findViewById(R.id.rate_update);
        rateUpdate2 = (TextView) findViewById(R.id.rate_update2);
        Typeface robot1 = Typeface.createFromAsset(this.getAssets(), "font/RobotoCondensed-Light.ttf");
        Typeface robot2 = Typeface.createFromAsset(this.getAssets(), "font/RobotoCondensed-Regular.ttf");
        rateUpdate.setTypeface(robot1);
        rateUpdate2.setTypeface(robot2);

        Spinner spinnerView1 = (Spinner) findViewById(R.id.spinner1);

        Spinner spinnerView2 = (Spinner) findViewById(R.id.spinner2);


        mAdapter = new CurrencyAdapter(this, new ArrayList<Country>());
        mAdapter.setDropDownViewResource(R.layout.spinneriteam);
        spinnerView1.setAdapter(mAdapter);
        spinnerView2.setAdapter(mAdapter);

        countries = new ArrayList<Country>();

        ConnectivityManager chkMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInf = chkMgr.getActiveNetworkInfo();

        Context applicationContext = MainActivity.getContextofApp();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        if (!preferences.contains("INR") && (networkInf == null || !networkInf.isConnected())) {
            Intent empty = new Intent(this, emptyState.class);
            startActivity(empty);
        } else {

            if (networkInf != null && networkInf.isConnected()) {
                isConnected = true;
            }

            getLoaderManager().initLoader(COUNTRY_LOADER_ID, null, this);

            spinnerView1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                    Country c = countries.get(position);
                    currency1 = c.getmExchangeRate();
                    primaryCountry = c.getmCurrencyName();
                    updateText();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

            spinnerView2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                    Country c = countries.get(position);
                    currency2 = c.getmExchangeRate();
                    secondaryCountry = c.getmCurrencyName();
                    updateText();

                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });


            Button convertButton = (Button) findViewById(R.id.convert_button);

            editText1 = (EditText) findViewById(R.id.edit1);
            editText2 = (EditText) findViewById(R.id.edit2);


            convertButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Double result = calculate();
                    DecimalFormat ans = new DecimalFormat("0.000");
                    if (result != null)
                        editText2.setText(ans.format(result));
                }
            });

        }
    }

    private void updateText() {
        String message = message1 + " " + primaryCountry + " " + message2;
        String messageNext = updatedRate() + " " + secondaryCountry;
        rateUpdate.setText(message);
        rateUpdate2.setText(messageNext);

    }

    private String updatedRate() {
        DecimalFormat pres = new DecimalFormat("0.000");
        Double result = currency2 / currency1;
        return pres.format(result);
    }


    private Double calculate() {
        Double amount;
        Double result = null;
        String ck = editText1.getText().toString().trim();
        if (!ck.isEmpty() && ck.length() != 0 && !ck.equals("")) {
            amount = Double.parseDouble(editText1.getText().toString());
            result = amount * (Double) (currency2 / currency1);
        }
        return result;
    }

    private HashMap<String, String> applyCodes() {
        String[] countryAbrevations = getResources().getStringArray(R.array.country_abbriviated);
        String[] countryName = getResources().getStringArray(R.array.country_name);
        HashMap<String, String> newMap = new HashMap<>();
        for (int i = 0; i < countryAbrevations.length; i++) {
            Log.e(LOG_TAG, countryAbrevations[i] + ":" + countryName[i]);
            newMap.put(countryAbrevations[i], countryName[i]);
        }
        return newMap;
    }


    public static Context getContextofApp() {
        return applicationContext;
    }


    @Override
    public Loader<List<Country>> onCreateLoader(int i, Bundle bundle) {
        return new CurrencyLoader(this, FIXER_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<Country>> loader, List<Country> countries) {


        if (!isConnected)
            Toast.makeText(this, R.string.not_connected, Toast.LENGTH_LONG).show();

        mAdapter.clear();

        if (countries != null && !countries.isEmpty()) {
            mAdapter.addAll(countries);
            currency1 = countries.get(0).getmExchangeRate();
            currency2 = countries.get(0).getmExchangeRate();
            this.countries = countries;
            Log.e(LOG_TAG, countries.get(2).getmExchangeRate().toString());
        }
    }


    @Override
    public void onLoaderReset(Loader<List<Country>> loader) {
        mAdapter.clear();
    }


}
