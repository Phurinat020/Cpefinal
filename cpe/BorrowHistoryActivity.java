package com.example.cpe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BorrowHistoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BorrowHistoryAdapter adapter;
    private List<BorrowRecord> borrowRecords = new ArrayList<>();

    Button backButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrow_history);

        recyclerView = findViewById(R.id.recycler_view_history);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // สร้าง Adapter และผูกกับ RecyclerView
        adapter = new BorrowHistoryAdapter(borrowRecords);
        recyclerView.setAdapter(adapter);

        // โหลดข้อมูลจาก Database
        loadBorrowHistory();

        backButton = findViewById(R.id.button14);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Back");
                Intent yurmActivity = new Intent(getApplicationContext(), YurmUbPaGornActivity.class);
                startActivity(yurmActivity);
            }
        });
    }

    private void loadBorrowHistory() {
        // ทำงานใน Thread แยกเพื่อไม่ให้ UI ค้าง
        new Thread(() -> {
            // เข้าถึง Database และดึงข้อมูลทั้งหมด
            AppDatabase db = AppDatabase.getDatabase(getApplicationContext());
            List<BorrowRecord> recordsFromDb = db.borrowDao().getAllRecords();

            // อัปเดต UI บน Main Thread
            runOnUiThread(() -> {
                borrowRecords.clear();
                borrowRecords.addAll(recordsFromDb);
                adapter.notifyDataSetChanged(); // แจ้ง Adapter ว่าข้อมูลมีการเปลี่ยนแปลง
            });
        }).start();
    }
}