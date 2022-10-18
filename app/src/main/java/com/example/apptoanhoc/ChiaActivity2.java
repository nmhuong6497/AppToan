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

public class ChiaActivity2 extends AppCompatActivity {

    TextView tvCaculation, tvDialogResult;
    Button btnReset, btnCorrect, btnWrong, btnDialogContinue, btnDialogClose;
    int number1, number2, result, ifResultFalse;
    boolean isTrue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chia2);

        tvCaculation = findViewById(R.id.text_view_caculation);
        btnReset = findViewById(R.id.button_reset);
        btnCorrect = findViewById(R.id.button_correct);
        btnWrong = findViewById(R.id.button_wrong);

        Random();

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random();
            }
        });

        btnCorrect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog();

                if (isTrue) {
                    tvDialogResult.setText("Bạn chọn chính xác\nKết quả là A. Đúng");
                } else {
                    tvDialogResult.setText("Bạn chọn A. Đúng\nKết quả là B. Sai");
                }
            }
        });

        btnWrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog();

                if (!isTrue) {
                    tvDialogResult.setText("Bạn chọn chính xác\nKết quả là B. Sai");
                } else {
                    tvDialogResult.setText("Bạn chọn B. Sai\nKết quả là A. Đúng");
                }
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

        // Phép chia
        if (isTrue) {
            tvCaculation.setText(result + " : " + number2 + " = " + number1);
        } else {
            tvCaculation.setText(result + " : " + number2 + " = " + (number1 + ifResultFalse));
        }
    }

    public void Dialog() {
        Dialog dialog = new Dialog(ChiaActivity2.this);
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