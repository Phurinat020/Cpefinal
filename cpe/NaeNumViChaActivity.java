package com.example.cpe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NaeNumViChaActivity extends AppCompatActivity {

    Button backToFuture;
    ProgressBar ProgressBar;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nae_num_vi_cha);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        backToFuture = findViewById(R.id.button2);
        backToFuture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressBar.setVisibility(View.VISIBLE); // 1. แสดง ProgressBar

                // สร้าง Thread เพื่อจำลองการโหลดและหน่วงเวลา
                new Thread(() -> {
                    try {
                        Thread.sleep(2000); // หน่วงเวลา 1 วินาที
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // กลับไปที่ Main Thread เพื่อเปิด Activity ใหม่
                    runOnUiThread(() -> {
                        Intent futureActivity = new Intent(getApplicationContext(), FutureActivity.class);
                        startActivity(futureActivity);
                        ProgressBar.setVisibility(View.GONE); // 2. ซ่อน ProgressBar หลังเปิดหน้าใหม่
                    });
                }).start();
            }
        });
        ProgressBar = findViewById(R.id.progressBar5);
        ProgressBar.setVisibility(View.GONE);

        // ใน FutureActivity.java
        LinearLayout branchSelector9 = findViewById(R.id.branch_ViChaChemi_button9);
        branchSelector9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressBar.setVisibility(View.VISIBLE); // 1. แสดง ProgressBar

                // สร้าง Thread เพื่อจำลองการโหลดและหน่วงเวลา
                new Thread(() -> {
                    try {
                        Thread.sleep(2000); // หน่วงเวลา 1 วินาที
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // กลับไปที่ Main Thread เพื่อเปิด Activity ใหม่
                    runOnUiThread(() -> {
                        Intent ViChaChemiActivity = new Intent(getApplicationContext(), ViChaChemicalActivity.class);
                        startActivity(ViChaChemiActivity);
                        ProgressBar.setVisibility(View.GONE); // 2. ซ่อน ProgressBar หลังเปิดหน้าใหม่
                    });
                }).start();
            }
        });

    }
}