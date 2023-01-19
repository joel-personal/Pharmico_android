package com.example.pharam.support;

import org.json.JSONObject;

public interface OnNetworkListener {
    public void onSuccessReceived(JSONObject jsonObject);
    public void onErrorReceived(String message);
}
