package com.bugchain.saverstorestate.tools;

import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Created by POSEIDON on 27/10/2558.
 */
public class Connect {

    private static final String TAG = Connect.class.getSimpleName();

    private OkHttpClient okHttpClient;
    private Request.Builder builder;
    private Request request;
    private Response response;

    public Connect(){
        okHttpClient = new OkHttpClient();
        builder = new Request.Builder();
    }

    public String getNewsFeed(){
        final String feedUrl = "http://wi.th/thaipbs_backend_cron/json/MTopNews.json";
        try{
            request = builder.url(feedUrl).build();
            response = okHttpClient.newCall(request).execute();
            if(response.isSuccessful()){
                String result = response.body().string();
                Log.d(TAG,"Response : " + result);
                return result;
            }
        }catch (Exception e){
            Log.d(TAG,"Get news feed error.");
            e.printStackTrace();
        }
        return null;
    }

}
