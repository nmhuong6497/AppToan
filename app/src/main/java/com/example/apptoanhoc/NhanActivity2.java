package com.example.apptoanhoc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class NhanActivity2 extends AppCompatActivity {

    TextView tvPoint, tvCaculation, tvDialogResult;
    Button btnReset, btnCorrect, btnWrong, btnDialogContinue, btnDialogClose;
    int number1, number2, result, ifResultFalse;
    int point = 100;
    boolean isTrue;
    boolean isPointChecked = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan2);

        tvPoint = findViewById(R.id.text_view_point);
        tvCaculation = findViewById(R.id.text_view_caculation);
        btnReset = findViewById(R.id.button_reset);
        btnCorrect = findViewById(R.id.button_correct);
        btnWrong = findViewById(R.id.button_wrong);

        Random();

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random();
                isPointChecked = true;
            }
        });

        btnCorrect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog();

                if (isTrue) {
                    tvDialogResult.setText("Bạn chọn chính xác\nKết quả là A. Đúng");
                    if (isPointChecked) {
                        point = point + 10;
                    }
                } else {
                    tvDialogResult.setText("Bạn chọn A. Đúng\nKết quả là B. Sai");
                    if (isPointChecked) {
                        point = point - 10;
                    }
                }
                isPointChecked = false;
                tvPoint.setText(point + "");
            }
        });

        btnWrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog();

                if (!isTrue) {
                    tvDialogResult.setText("Bạn chọn chính xác\nKết quả là B. Sai");
                    if (isPointChecked) {
                        point = point + 10;
                    }
                } else {
                    tvDialogResult.setText("Bạn chọn B. Sai\nKết quả là A. Đúng");
                    if (isPointChecked) {
                        point = point - 10;
                    }
                }
                isPointChecked = false;
                tvPoint.setText(point + "");
            }
        });
    }

    public void Random() {
        Random random = new Random();
        number1 = random.nextInt(9) + 1;
        number2 = random.nextInt(9) + 1;
        result = number1 * number2;
        isTrue = random.nextBoolean();
        ifResultFalse = random.nextInt(3 - 1) + 1;
        if (isTrue) {
            tvCaculation.setText(number1 + " x " + number2 + " = " + result);
        } else {
            tvCaculation.setText(number1 + " x " + number2 + " = " + (result + ifResultFalse));
        }
    }

    public void Dialog() {
        Dialog dialog = new Dialog(NhanActivity2.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_result);
        dialog.setCancelable(false);

        Window window = dialog.getWindow();

        if (window != null) {
            window.setGravity(Gravity.CENTER);
            window.setLayout(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        }

        tvDialogResult = dialog.findViewById(R.id.text_view_result);
        btnDialogContinue = dialog.findViewById(R.id.button_continue );
        btnDialogClose = dialog.findViewById(R.id.button_close);

        btnDialogContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random();
                dialog.dismiss();
                isPointChecked = true;
            }
        });

        btnDialogClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}