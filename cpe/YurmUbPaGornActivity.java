package com.example.cpe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class YurmUbPaGornActivity extends AppCompatActivity {

    Button backToFuture;
    ProgressBar loadYurm;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_yurm_ub_pa_gorn);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        backToFuture = findViewById(R.id.button5);
        backToFuture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadYurm.setVisibility(View.VISIBLE); // 1. แสดง ProgressBar

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
                        loadYurm.setVisibility(View.GONE);
                    });
                }).start();
            }
        });
        loadYurm = findViewById(R.id.progressBar3);
        loadYurm.setVisibility(View.GONE);

        LinearLayout branchselector5 = findViewById(R.id.branch_Laptop_button5);
        branchselector5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadYurm.setVisibility(View.VISIBLE); // 1. แสดง ProgressBar

                // สร้าง Thread เพื่อจำลองการโหลดและหน่วงเวลา
                new Thread(() -> {
                    try {
                        Thread.sleep(2000); // หน่วงเวลา 1 วินาที
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // กลับไปที่ Main Thread เพื่อเปิด Activity ใหม่
                    runOnUiThread(() -> {
                        Intent laptopActivity = new Intent(getApplicationContext(), YurmLaptopActivity.class);
                        startActivity(laptopActivity);
                        loadYurm.setVisibility(View.GONE);
                    });
                }).start();
            }
        });

        LinearLayout branchselector6 = findViewById(R.id.branch_Ipad_button6);
        branchselector6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadYurm.setVisibility(View.VISIBLE); // 1. แสดง ProgressBar

                // สร้าง Thread เพื่อจำลองการโหลดและหน่วงเวลา
                new Thread(() -> {
                    try {
                        Thread.sleep(2000); // หน่วงเวลา 1 วินาที
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // กลับไปที่ Main Thread เพื่อเปิด Activity ใหม่
                    runOnUiThread(() -> {
                        Intent ipadActivity = new Intent(getApplicationContext(), YurmIpadActivity.class);
                        startActivity(ipadActivity);
                        loadYurm.setVisibility(View.GONE);
                    });
                }).start();
            }
        });

        LinearLayout branchselector7 = findViewById(R.id.branch_Headphone_button7);
        branchselector7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadYurm.setVisibility(View.VISIBLE); // 1. แสดง ProgressBar

                // สร้าง Thread เพื่อจำลองการโหลดและหน่วงเวลา
                new Thread(() -> {
                    try {
                        Thread.sleep(2000); // หน่วงเวลา 1 วินาที
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // กลับไปที่ Main Thread เพื่อเปิด Activity ใหม่
                    runOnUiThread(() -> {
                        Intent headphoneActivity = new Intent(getApplicationContext(), YurmHeadPhoneActivity.class);
                        startActivity(headphoneActivity);
                        loadYurm.setVisibility(View.GONE);
                    });
                }).start();
            }
        });

        LinearLayout branchselector8 = findViewById(R.id.branch_chemical_button8);
        branchselector8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadYurm.setVisibility(View.VISIBLE); // 1. แสดง ProgressBar

                // สร้าง Thread เพื่อจำลองการโหลดและหน่วงเวลา
                new Thread(() -> {
                    try {
                        Thread.sleep(2000); // หน่วงเวลา 1 วินาที
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // กลับไปที่ Main Thread เพื่อเปิด Activity ใหม่
                    runOnUiThread(() -> {
                        Intent chamicalActivity = new Intent(getApplicationContext(), YurmChemicalActivity.class);
                        startActivity(chamicalActivity);
                        loadYurm.setVisibility(View.GONE);
                    });
                }).start();
            }
        });

        Button viewHistoryButton = findViewById(R.id.button_view_history);
        viewHistoryButton.setOnClickListener(v -> {
            loadYurm.setVisibility(View.VISIBLE); // 1. แสดง ProgressBar

            // สร้าง Thread เพื่อจำลองการโหลดและหน่วงเวลา
            new Thread(() -> {
                try {
                    Thread.sleep(1000); // หน่วงเวลา 1 วินาที
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // กลับไปที่ Main Thread เพื่อเปิด Activity ใหม่
                runOnUiThread(() -> {
                    Intent intent = new Intent(getApplicationContext(), BorrowHistoryActivity.class);
                    startActivity(intent);
                    loadYurm.setVisibility(View.GONE);
                });
            }).start();
        });
    }
}