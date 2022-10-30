package com.example.apptoanhoc.caculation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.apptoanhoc.R;

import java.util.Random;

public class TruActivity extends AppCompatActivity {

    TextView tvPoint, tvTime, tvCaculation, tvDialogResult;
    Button btnReset, btnCorrect, btnWrong, btnDialogContinue, btnDialogClose;
    int number1, number2, result, ifResultFalse;
    int point = 100;
    int time = 5;
    boolean isTrue;
    boolean isPointChecked = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caculation);

        tvPoint = findViewById(R.id.text_view_point);
        tvTime = findViewById(R.id.text_view_time);
        tvCaculation = findViewById(R.id.text_view_caculation);
        btnReset = findViewById(R.id.button_reset);
        btnCorrect = findViewById(R.id.button_correct);
        btnWrong = findViewById(R.id.button_wrong);

        Random();
        Time();

        btnReset.setEnabled(false);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                btnReset.setEnabled(true);
            }
        }, 6000);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random();
                btnReset.setEnabled(false);
                btnCorrect.setEnabled(true);
                btnWrong.setEnabled(true);
                time = 5;
                tvTime.setText(time + "");
                Time();
                isPointChecked = true;
            }
        });

        btnCorrect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog();

                if (isTrue) {
                    tvDialogResult.setText("✅\nBạn chọn chính xác\nĐáp án là A. Đúng");
                    if (isPointChecked) {
                        point = point + 10;
                    }
                } else {
                    tvDialogResult.setText("❌\nBạn chọn A. Đúng\nĐáp án là B. Sai");
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
                    tvDialogResult.setText("✅\nBạn chọn chính xác\nĐáp án là B. Sai");
                    if (isPointChecked) {
                        point = point + 10;
                    }
                } else {
                    tvDialogResult.setText("❌\nBạn chọn B. Sai\nĐáp án là A. Đúng");
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
        result = number1 - number2;
        isTrue = random.nextBoolean();
        ifResultFalse = random.nextInt(3 - 1) + 1;
        if (isTrue) {
            tvCaculation.setText(number1 + " - " + number2 + " = " + result);
        } else {
            tvCaculation.setText(number1 + " - " + number2 + " = " + (result + ifResultFalse));
        }
    }

    public void Dialog() {
        Dialog dialog = new Dialog(TruActivity.this);
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
                btnReset.setEnabled(false);
                btnCorrect.setEnabled(true);
                btnWrong.setEnabled(true);
                time = 5;
                tvTime.setText(time + "");
                Time();
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

    public void Time() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!isPointChecked) {
                    handler.removeCallbacks(this);
                    btnReset.setEnabled(true);
                } else if (time == 0) {
                    handler.removeCallbacks(this);
                    point = point - 10;
                    tvPoint.setText(point + "");

                    if (isTrue) {
                        tvTime.setText("Đáp án là A. Đúng");
                    } else {
                        tvTime.setText("Đáp án là B. Sai");
                    }

                    btnReset.setEnabled(true);
                    btnCorrect.setEnabled(false);
                    btnWrong.setEnabled(false);
                } else {
                    time = time - 1;
                    tvTime.setText(time + "");
                    handler.postDelayed(this, 1000);
                }
            }
        }, 1000);
    }
}