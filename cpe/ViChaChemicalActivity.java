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

public class ViChaChemicalActivity extends AppCompatActivity {

    Button backToVicha;
    ProgressBar loadingProgressBar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vi_cha_chemical);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        loadingProgressBar = findViewById(R.id.progressBar);
        loadingProgressBar.setVisibility(View.GONE);

        LinearLayout branchSelector10 = findViewById(R.id.branch_pdf_button10);
        branchSelector10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadingProgressBar.setVisibility(View.VISIBLE); // 1. แสดง ProgressBar

                // สร้าง Thread เพื่อจำลองการโหลดและหน่วงเวลา
                new Thread(() -> {
                    try {
                        Thread.sleep(2000); // หน่วงเวลา 1 วินาที
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // กลับไปที่ Main Thread เพื่อเปิด Activity ใหม่
                    runOnUiThread(() -> {
                        String pdfUrl = "https://drive.google.com/file/d/1PaMe4CWzv6bzO7NM3XnFYnzFas2D3Wzc/view?usp=drivesdk";
                        Intent intent = new Intent(ViChaChemicalActivity.this, PdfViewActivity.class);
                        intent.putExtra("pdf_url", pdfUrl);
                        startActivity(intent);
                        loadingProgressBar.setVisibility(View.GONE); // 2. ซ่อน ProgressBar หลังเปิดหน้าใหม่
                    });
                }).start();
            }
        });

        // --- ปุ่มที่ 2: แบบฝึกหัด (Kahoot) ---
        LinearLayout branchSelector11 = findViewById(R.id.branch_Kahoot_button11);
        branchSelector11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadingProgressBar.setVisibility(View.VISIBLE); // 1. แสดง ProgressBar

                // สร้าง Thread เพื่อจำลองการโหลดและหน่วงเวลา
                new Thread(() -> {
                    try {
                        Thread.sleep(2000); // หน่วงเวลา 1 วินาที
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // กลับไปที่ Main Thread เพื่อเปิด Activity ใหม่
                    runOnUiThread(() -> {
                        String url = "https://create.kahoot.it/share/1b2536b5-1884-4cb9-842d-b57a56432958";
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        startActivity(intent);
                        loadingProgressBar.setVisibility(View.GONE); // 2. ซ่อน ProgressBar หลังเปิดหน้าใหม่
                    });
                }).start();
            }
        });

        // --- ปุ่มที่ 3: เครื่องคิดเลขเคมี ---
        LinearLayout branchSelector13 = findViewById(R.id.branch_ChemistryCalculator_button13);
        branchSelector13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadingProgressBar.setVisibility(View.VISIBLE); // 1. แสดง ProgressBar

                // สร้าง Thread เพื่อจำลองการโหลดและหน่วงเวลา
                new Thread(() -> {
                    try {
                        Thread.sleep(2000); // หน่วงเวลา 1 วินาที
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // กลับไปที่ Main Thread เพื่อเปิด Activity ใหม่
                    runOnUiThread(() -> {
                        Intent intent = new Intent(ViChaChemicalActivity.this, ChemistryCalcutorActivity.class);
                        startActivity(intent);
                        loadingProgressBar.setVisibility(View.GONE); // 2. ซ่อน ProgressBar หลังเปิดหน้าใหม่
                    });
                }).start();
            }
        });
        backToVicha = findViewById(R.id.button16);
        backToVicha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadingProgressBar.setVisibility(View.VISIBLE); // 1. แสดง ProgressBar

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
                        loadingProgressBar.setVisibility(View.GONE); // 2. ซ่อน ProgressBar หลังเปิดหน้าใหม่
                    });
                }).start();
            }
        });
    }
}