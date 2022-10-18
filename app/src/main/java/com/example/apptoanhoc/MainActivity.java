package com.example.apptoanhoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnCong, btnTru, btnNhan, btnChia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCong = findViewById(R.id.button_cong);
        btnTru = findViewById(R.id.button_tru);
        btnNhan = findViewById(R.id.button_nhan);
        btnChia = findViewById(R.id.button_chia);

        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CongActivity2.class);
                startActivity(intent);
            }
        });

        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TruActivity2.class);
                startActivity(intent);
            }
        });

        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, NhanActivity2.class);
                startActivity(intent);
            }
        });

        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, ChiaActivity2.class);
                startActivity(intent);
            }
        });
    }
}