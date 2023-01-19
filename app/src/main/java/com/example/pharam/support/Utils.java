package com.example.pharam.support;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AlertDialog;

import com.example.pharam.R;

public class Utils {

    public static AlertDialog showLoading(Context context, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.loading_layout, null);
        builder.setView(view);
        return builder.create();
    }
}
