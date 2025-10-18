package com.example.cpe;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;
import java.util.Date;

public class YurmIpadActivity extends AppCompatActivity {

    Spinner listIpad;
    Button confirm, backButton;
    EditText name, studentId, phoneNumber;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_yurm_ipad);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listIpad = findViewById(R.id.spinner2);

        String[] ipads = {"IpadAir4", "IpadAir5", "IpadAir6", "IpadAir7"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, ipads);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        listIpad.setAdapter(adapter);

        name = findViewById(R.id.editTextText5);
        studentId = findViewById(R.id.editTextText6);
        phoneNumber = findViewById(R.id.editTextText4);
        confirm = findViewById(R.id.button9);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameStr = name.getText().toString();
                String idStr = studentId.getText().toString();
                String phoneStr = phoneNumber.getText().toString();
                String ipadStr = listIpad.getSelectedItem().toString();
                Date currentDate = new Date();

                if (nameStr.isEmpty() || idStr.isEmpty() || phoneStr.isEmpty() || ipadStr.isEmpty()) {
                    new AlertDialog.Builder(YurmIpadActivity.this)
                            .setTitle("ข้อมูลไม่ครบถ้วน")
                            .setMessage("กรุณากรอกข้อมูลให้ครบทุกช่อง")
                            .setPositiveButton("ตกลง", null)
                            .show();
                    return; // หยุดการทำงาน
                }

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(currentDate);
                calendar.add(Calendar.DATE, 5);
                Date returnDate = calendar.getTime();

                BorrowRecord newRecord = new BorrowRecord(nameStr, idStr, phoneStr, ipadStr, currentDate, returnDate);

                new Thread(() -> {
                    // เข้าถึง Database
                    AppDatabase db = AppDatabase.getDatabase(getApplicationContext());
                    // เรียกใช้คำสั่ง insert จาก DAO
                    db.borrowDao().insert(newRecord);

                    // เมื่อบันทึกเสร็จแล้ว สามารถแสดง AlertDialog บน UI thread
                    runOnUiThread(() -> {
                        String successMessage = "บันทึกข้อมูลสำเร็จ:\n\n" +
                                "ชื่อ: " + newRecord.getUserName() + "\n" +
                                "รหัสนักศึกษา: " + newRecord.getStudentId() + "\n" +
                                "อุปกรณ์: " + newRecord.getEquipmentDetails() + "\n" +
                                "วันคืน: " + newRecord.getReturnDate().toString();

                        new AlertDialog.Builder(YurmIpadActivity.this)
                                .setTitle("บันทึกข้อมูลสำเร็จ")
                                .setMessage(successMessage)
                                .setPositiveButton("ตกลง", (dialog, which) -> {
                                    // เมื่อกดตกลง อาจจะให้กลับไปหน้าหลัก หรือเคลียร์ฟอร์ม
                                    finish();
                                })
                                .show();
                    });
                }).start();
            }
        });

        backButton = findViewById(R.id.button8);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Back");
                Intent yurmActivity = new Intent(getApplicationContext(), YurmUbPaGornActivity.class);
                startActivity(yurmActivity);
            }
        });
    }
}