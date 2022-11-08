package com.example.apptoanhoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.apptoanhoc.caculation.ChiaActivity;
import com.example.apptoanhoc.caculation.CongActivity;
import com.example.apptoanhoc.caculation.NhanActivity;
import com.example.apptoanhoc.caculation.TruActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCong, btnTru, btnNhan, btnChia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCong = findViewById(R.id.button_cong);
        btnTru = findViewById(R.id.button_tru);
        btnNhan = findViewById(R.id.button_nhan);
        btnChia = findViewById(R.id.button_chia);

        btnCong.setOnClickListener(this);
        btnTru.setOnClickListener(this);
        btnNhan.setOnClickListener(this);
        btnChia.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_cong:
                Intent intent = new Intent(MainActivity.this, CongActivity.class);
                startActivity(intent);
                break;
            case R.id.button_tru:
                Intent intent1 = new Intent(MainActivity.this, TruActivity.class);
                startActivity(intent1);
                break;
            case R.id.button_nhan:
                Intent intent2 = new Intent(MainActivity.this, TruActivity.class);
                startActivity(intent2);
                break;
            case R.id.button_chia:
                Intent intent3 = new Intent(MainActivity.this, TruActivity.class);
                startActivity(intent3);
                break;
        }
    }
}