package com.example.cpe;

import android.annotation.SuppressLint;
import android.content.Intent;
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

public class ProjectActivity extends AppCompatActivity {
    Button backToFuture;
    ProgressBar loading;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_project);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        backToFuture = findViewById(R.id.button3);
        backToFuture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loading.setVisibility(View.VISIBLE); // 1. แสดง ProgressBar

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
                        loading.setVisibility(View.GONE); // 2. ซ่อน ProgressBar หลังเปิดหน้าใหม่
                    });
                }).start();
            }
        });

        loading = findViewById(R.id.progressBar4);
        loading.setVisibility(View.GONE);

        LinearLayout branchSelector13 = findViewById(R.id.branch_project_button13);
        branchSelector13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loading.setVisibility(View.VISIBLE); // 1. แสดง ProgressBar

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
                        Intent intent = new Intent(ProjectActivity.this, ProjectpdfviewActivity.class);
                        intent.putExtra("pdf_url", pdfUrl);
                        startActivity(intent);
                        loading.setVisibility(View.GONE); // 2. ซ่อน ProgressBar หลังเปิดหน้าใหม่
                    });
                }).start();
            }

        });
    }
}