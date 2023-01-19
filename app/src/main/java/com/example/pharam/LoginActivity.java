package com.example.pharam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.example.pharam.support.Base;
import com.example.pharam.support.NetworkFunction;
import com.example.pharam.support.OnNetworkListener;
import com.example.pharam.support.Utils;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    MaterialButton btn_login, btn_register;
    TextInputEditText tv_email, tv_password;
    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);
        tv_email = findViewById(R.id.tv_email);
        tv_password = findViewById(R.id.tv_password);

        dialog = Utils.showLoading(this, "please wait");


        handleClickEvents();
    }

    private void handleClickEvents() {
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
//                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            }
        });
    }

    private void login() {
        String email = tv_email.getText().toString();
        String password = tv_password.getText().toString();

        if(!validateEmail(email)) { return; }
        if(!validatePassword(password)) { return; }

        dialog.show();
        NetworkFunction nf = new NetworkFunction(LoginActivity.this, new OnNetworkListener() {
            @Override
            public void onSuccessReceived(JSONObject jsonObject) {
                dialog.dismiss();
                //get success and save to shared preference
                //redirect to home
            }

            @Override
            public void onErrorReceived(String message) {
                dialog.dismiss();
                Log.d("TAG", "onErrorReceived: " + message);
                Toast.makeText(LoginActivity.this, getString(R.string.error_message), Toast.LENGTH_SHORT).show();
            }
        });
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("email", email);
            jsonObject.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        nf.getJSONFromURL(Base.LOGIN, jsonObject, Base.GET);
    }

    private boolean validateEmail(String email) {
        if(Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return true;
        }
        tv_email.setError("Invalid email");
        return false;
    }

    private boolean validatePassword(String password) {
        if(password.length() < 4) {
            tv_password.setError("Password length too short");
            return false;
        }
        return true;
    }
}