package com.example.pharam.support;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

public class NetworkFunction {

    Context context;
    OnNetworkListener listener;

    public NetworkFunction(Context context, OnNetworkListener listener) {
        this.context = context;
        this.listener = listener;
    }

    public void getJSONFromURL(String source, JSONObject jsonBody, String method) {
        String url = Base.API_URL + source;
        if(method.equals(Base.GET)) {
            url += convertToString(jsonBody);
            jsonBody = null;
        }

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        JsonObjectRequest request = new JsonObjectRequest((method.equals(Base.GET) ? Request.Method.GET : Request.Method.POST), url, jsonBody, response -> {
            listener.onSuccessReceived(response);
        }, error -> {
            listener.onErrorReceived(error.getMessage());
        });
        requestQueue.add(request);
    }

    private String convertToString(JSONObject jsonObject){
        String ret="";
        Iterator<String> iter = jsonObject.keys();
        while (iter.hasNext()) {
            String key = iter.next();
            try {
                ret+=key + "=" + jsonObject.get(key).toString() + "&";
//                Object value = jsonObject.get(key).toString();
            } catch (JSONException e) {
                // Something went wrong!
            }
        }
        ret="?"+ret;
        return ret;
    }
}
