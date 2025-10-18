package com.example.cpe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FutureActivity extends AppCompatActivity {

    ProgressBar loadFuture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_future);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        LinearLayout branchSelector = findViewById(R.id.branch_computer_button);
        LinearLayout branchSelector2 = findViewById(R.id.branch_naenumvicha_button2);
        LinearLayout branchSelector3 = findViewById(R.id.branch_Project_button3);
        LinearLayout branchSelector4 = findViewById(R.id.branch_yurm_button4);

        loadFuture = findViewById(R.id.progressBar2);
        loadFuture.setVisibility(View.GONE);

        branchSelector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFuture.setVisibility(View.VISIBLE); // 1. แสดง ProgressBar

                // สร้าง Thread เพื่อจำลองการโหลดและหน่วงเวลา
                new Thread(() -> {
                    try {
                        Thread.sleep(2000); // หน่วงเวลา 1 วินาที
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // กลับไปที่ Main Thread เพื่อเปิด Activity ใหม่
                    runOnUiThread(() -> {
                        String pdfUrl = "https://drive.google.com/file/d/1xZq7tAFIZWCugRFMQMLNo5R3noTIBavz/view?usp=drive_link";
                        Intent intent = new Intent(FutureActivity.this, SaCapdfActivity.class);
                        intent.putExtra("pdf_url", pdfUrl);
                        startActivity(intent);
                        loadFuture.setVisibility(View.GONE); // 2. ซ่อน ProgressBar หลังเปิดหน้าใหม่
                    });
                }).start();
            }
        });
        branchSelector2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFuture.setVisibility(View.VISIBLE); // 1. แสดง ProgressBar

                // สร้าง Thread เพื่อจำลองการโหลดและหน่วงเวลา
                new Thread(() -> {
                    try {
                        Thread.sleep(2000); // หน่วงเวลา 1 วินาที
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // กลับไปที่ Main Thread เพื่อเปิด Activity ใหม่
                    runOnUiThread(() -> {
                        Intent naeNumViChaActivity = new Intent(getApplicationContext(), NaeNumViChaActivity.class);
                        startActivity(naeNumViChaActivity);
                        loadFuture.setVisibility(View.GONE);
                    });
                }).start();
            }
        });
        branchSelector3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFuture.setVisibility(View.VISIBLE); // 1. แสดง ProgressBar

                // สร้าง Thread เพื่อจำลองการโหลดและหน่วงเวลา
                new Thread(() -> {
                    try {
                        Thread.sleep(2000); // หน่วงเวลา 1 วินาที
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // กลับไปที่ Main Thread เพื่อเปิด Activity ใหม่
                    runOnUiThread(() -> {
                        Intent projectActivity = new Intent(getApplicationContext(), ProjectActivity.class);
                        startActivity(projectActivity);
                        loadFuture.setVisibility(View.GONE);
                    });
                }).start();
            }
        });
        branchSelector4.setOnClickListener(new View.OnClickListener() {
            @Override   
            public void onClick(View view) {
                loadFuture.setVisibility(View.VISIBLE); // 1. แสดง ProgressBar

                // สร้าง Thread เพื่อจำลองการโหลดและหน่วงเวลา
                new Thread(() -> {
                    try {
                        Thread.sleep(2000); // หน่วงเวลา 1 วินาที
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // กลับไปที่ Main Thread เพื่อเปิด Activity ใหม่
                    runOnUiThread(() -> {
                        Intent yurmUbPaGornActivity = new Intent(getApplicationContext(), YurmUbPaGornActivity.class);
                        startActivity(yurmUbPaGornActivity);
                        loadFuture.setVisibility(View.GONE);
                    });
                }).start();
            }
        });
    }
}