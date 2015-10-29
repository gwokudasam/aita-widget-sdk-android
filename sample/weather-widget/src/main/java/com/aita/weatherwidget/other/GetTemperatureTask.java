package com.aita.weatherwidget.other;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetTemperatureTask extends AsyncTask<LatLng, Void, List<Integer>> {

    private OkHttpClient mClient;
    private TemperatureListener mListener;

    public GetTemperatureTask(final TemperatureListener listener) {
        mClient = new OkHttpClient();
        mListener = listener;
    }

    @NonNull
    @Override
    protected List<Integer> doInBackground(LatLng... latLngs) {
        final ArrayList<Integer> temps = new ArrayList<>();

        for (LatLng latLng : latLngs) {
            try {
                final Request request = new Request.Builder()
                        .url("http://api.openweathermap.org/data/2.5/weather?" +
                                "units=Metric" +
                                "&lat=" + latLng.lat +
                                "&lon=" + latLng.lon +
                                "&APPID=ce124895da91ab40c27011636b8997d0")
                        .build();

                final Response response = mClient.newCall(request).execute();
                Log.d("TAG", response.toString());
                final JSONObject jsonObject = new JSONObject(response.body().string());
                temps.add((int) Math.round(jsonObject
                        .getJSONObject("main")
                        .getDouble("temp")));
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
        }

        return temps;
    }

    @Override
    protected void onPostExecute(@NonNull List<Integer> result) {
        super.onPostExecute(result);
        if (mListener != null)
            mListener.onTemperatureLoaded(result);
    }

    public interface TemperatureListener {
        void onTemperatureLoaded(@NonNull List<Integer> result);
    }
}
