package com.example.nitishkumar.currencyconverter;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


class Utility {


    public static SharedPreferences sharedPref;
    private static final String LOG_TAG = "Hello";

    private Utility() {

    }

    static List<Country> getCountries(String requestUrl) {
        URL url = createUrl(requestUrl);
        String jsonResponse = "";
        try {
            jsonResponse = httpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making http request");
        }

        SharedPreferences exchangeRates = new Utility().updateSharedPrefrence(jsonResponse);
        ArrayList<Country> countries = fetchCountriesFromPref(exchangeRates);
        return countries;
    }

    private static ArrayList<Country> fetchCountriesFromPref(SharedPreferences exchangeRates) {
        Map<String, String> rateKeys = (Map<String, String>) exchangeRates.getAll();
        ArrayList<Country> countries = new ArrayList<>();
        for (Map.Entry<String, String> entry : rateKeys.entrySet()) {
//            Log.e(LOG_TAG,entry.getKey()+":"+Double.parseDouble(entry.getValue())+"");
            countries.add(new Country(MainActivity.countryCodes.get(entry.getKey()), Double.parseDouble(entry.getValue())));
        }
        setFlags(countries);
        return countries;
    }

    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Malformed URL", e);
        }
        return url;
    }

    private static String httpRequest(URL url) throws IOException {
        String jsonResult = "";
        if (url == null)
            return jsonResult;
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                inputStream = urlConnection.getInputStream();
                jsonResult = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code:" + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "error fetching result", e);
        } finally {
            if (urlConnection != null)
                urlConnection.disconnect();
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResult;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader reader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader buffreader = new BufferedReader(reader);
            String line = buffreader.readLine();
            while (line != null) {
                output.append(line);
                line = buffreader.readLine();
            }
        }
        return output.toString();
    }

    private static void setFlags(ArrayList<Country> flags) {
        Country c = flags.get(0);
        c.setmImageResId(R.drawable._croatia);
        c = flags.get(1);
        c.setmImageResId(R.drawable._poland);
        c = flags.get(2);
        c.setmImageResId(R.drawable._australia);
        c = flags.get(3);
        c.setmImageResId(R.drawable._india);
        c = flags.get(4);
        c.setmImageResId(R.drawable._japan);
        c = flags.get(5);
        c.setmImageResId(R.drawable._indonesia);
        c = flags.get(6);
        c.setmImageResId(R.drawable.euro);
        c = flags.get(7);
        c.setmImageResId(R.drawable._bulgaria);
        c = flags.get(8);
        c.setmImageResId(R.drawable._thisreal);
        c = flags.get(9);
        c.setmImageResId(R.drawable._unitedkingdom);
        c = flags.get(10);
        c.setmImageResId(R.drawable._singapore);
        c = flags.get(11);
        c.setmImageResId(R.drawable._philippines);
        c = flags.get(12);
        c.setmImageResId(R.drawable._newzealand);
        c = flags.get(13);
        c.setmImageResId(R.drawable._denmark);
        c = flags.get(14);
        c.setmImageResId(R.drawable._czechrepublic);
        c = flags.get(15);
        c.setmImageResId(R.drawable._china);
        c = flags.get(16);
        c.setmImageResId(R.drawable._hungary);
        c = flags.get(17);
        c.setmImageResId(R.drawable._this);
        c = flags.get(18);
        c.setmImageResId(R.drawable._turkey);
        c = flags.get(19);
        c.setmImageResId(R.drawable._russia);
        c = flags.get(20);
        c.setmImageResId(R.drawable._koreouth);
        c = flags.get(21);
        c.setmImageResId(R.drawable._norway);
        c = flags.get(22);
        c.setmImageResId(R.drawable._switzerland);
        c = flags.get(23);
        c.setmImageResId(R.drawable._brazil);
        c = flags.get(24);
        c.setmImageResId(R.drawable._mexico);
        c = flags.get(25);
        c.setmImageResId(R.drawable._hongkong);
        c = flags.get(26);
        c.setmImageResId(R.drawable._romania);
        c = flags.get(27);
        c.setmImageResId(R.drawable._canada);
        c = flags.get(28);
        c.setmImageResId(R.drawable._sweden);
        c = flags.get(29);
        c.setmImageResId(R.drawable._thisasia);
        c = flags.get(30);
        c.setmImageResId(R.drawable._thailand);
        Country c1 = new Country("U.S Dollar", 1.0000);
        c1.setmImageResId(R.drawable._unitedstatesofamerica);
        flags.add(c1);
    }

    private SharedPreferences updateSharedPrefrence(String jsonResult) {
        Context applicationContext = MainActivity.getContextofApp();
        SharedPreferences exchangeRates = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        if (jsonResult == null) {
            return exchangeRates;
        }
        SharedPreferences.Editor editor = exchangeRates.edit();
        try {
            JSONObject baseJson = new JSONObject(jsonResult);
            JSONObject rates = baseJson.getJSONObject("rates");
            Iterator<String> iterator = rates.keys();
            while (iterator.hasNext()) {
                String key = iterator.next();
                Double keyRate = rates.getDouble(key);
//                Log.e(LOG_TAG,keyRate.toString());
                editor.putString(key, keyRate.toString());
            }

            editor.apply();
        } catch (JSONException e) {
            Log.e(LOG_TAG, "Problem parsing the json object", e);
        }
        return exchangeRates;
    }


}
