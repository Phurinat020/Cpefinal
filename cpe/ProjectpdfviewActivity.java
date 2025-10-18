package com.example.cpe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProjectpdfviewActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_projectpdfview);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        WebView webView = findViewById(R.id.pdf_webview2);
        webView.setWebViewClient(new WebViewClient()); // เพื่อให้ลิงก์เปิดในแอป ไม่เด้งไปเบราว์เซอร์
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true); // เปิดใช้งานการซูม

        // รับ URL ที่ส่งมาจาก Intent
        String pdfUrl = getIntent().getStringExtra("pdf_url");

        if (pdfUrl != null) {
            // เราจะใช้ Google Docs Viewer เป็นตัวกลางในการแสดงผล PDF จาก URL
            // ซึ่งเป็นวิธีที่เสถียรและรองรับไฟล์ได้หลากหลาย
            webView.loadUrl("https://drive.google.com/file/d/1xZq7tAFIZWCugRFMQMLNo5R3noTIBavz/view?usp=drive_link" + pdfUrl);
        }
    }
}