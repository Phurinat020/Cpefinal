package com.example.cpe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class BorrowHistoryAdapter extends RecyclerView.Adapter<BorrowHistoryAdapter.ViewHolder> {
    private List<BorrowRecord> records;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

    public BorrowHistoryAdapter(List<BorrowRecord> records) {
        this.records = records;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_borrow_record, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BorrowRecord record = records.get(position);

        String equipmentType = record.getEquipmentType();
        if (equipmentType == null) { // สำหรับข้อมูลเก่าที่ยังไม่มี Type
            equipmentType = "อุปกรณ์";
        }

        // ตั้งค่าข้อความให้แสดงประเภทด้วย
        holder.equipmentName.setText(equipmentType + ": " + record.getEquipmentDetails());
        holder.userName.setText("ผู้ยืม: " + record.getUserName());

        if (record.getBorrowDate() != null) {
            holder.borrowDate.setText("วันที่ยืม: " + dateFormat.format(record.getBorrowDate()));
        }
        if (record.getReturnDate() != null) {
            holder.returnDate.setText("กำหนดคืน: " + dateFormat.format(record.getReturnDate()));
        }
    }

    @Override
    public int getItemCount() {
        return records.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView equipmentName, userName, borrowDate, returnDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            equipmentName = itemView.findViewById(R.id.item_equipment_name);
            userName = itemView.findViewById(R.id.item_user_name);
            borrowDate = itemView.findViewById(R.id.item_borrow_date);
            returnDate = itemView.findViewById(R.id.item_return_date);
        }
    }
}
