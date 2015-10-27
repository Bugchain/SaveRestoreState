package com.bugchain.saverstorestate.model;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by POSEIDON on 27/10/2558.
 */
public class News implements Serializable{

    private static final String TAG = News.class.getSimpleName();
    private String title;
    private String imageUrl;

    private void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return  title;
    }

    private void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }
    public String getImageUrl(){
        return imageUrl;
    }

    private News set(String title,String imageUrl){
        News news = new News();
        news.setTitle(title);
        news.setImageUrl(imageUrl);
        return news;
    }

    public List<News> setup(String jsonString){
        List<News> list = new ArrayList<>();
        try{
            JSONObject object = new JSONObject(jsonString);
            JSONArray array = object.getJSONArray("Items");
            if(array != null){
                int size = array.length();
                JSONObject info;
                for (int i=0;i<size;i++){
                    info = array.getJSONObject(i);
                    list.add(set(
                            info.getString("title"),
                            info.getString("thumbnail")
                    ));
                }
            }
        }catch (JSONException e){
            Log.e(TAG,"Get news json string error.");
            e.printStackTrace();
        }

        return list;
    }

}
