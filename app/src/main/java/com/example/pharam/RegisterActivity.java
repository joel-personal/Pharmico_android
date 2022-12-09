package com.example.pharam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {

    MaterialButton btn_register2;
    TextInputEditText tv_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn_register2 = findViewById(R.id.btn_register2);
        tv_image = findViewById(R.id.tv_image);

        handleClickEvents();
    }

    private void handleClickEvents() {
        btn_register2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
            }
        });
        tv_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(RegisterActivity.this, "hoo", Toast.LENGTH_SHORT).show();
            }
        });
    }
}