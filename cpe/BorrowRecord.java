package com.example.cpe;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;

@Entity(tableName = "borrow_records") // กำหนดชื่อตาราง
@TypeConverters(Converters.class) // บอก Room ให้ใช้ตัวแปลงสำหรับ Date
public class BorrowRecord {

    @PrimaryKey(autoGenerate = true) // กำหนดให้ id เป็น primary key และสร้างอัตโนมัติ
    public int id;

    @ColumnInfo(name = "user_name") // กำหนดชื่อคอลัมน์
    private String userName;

    @ColumnInfo(name = "student_id")
    private String studentId;

    @ColumnInfo(name = "phone_number")
    private String phoneNumber;

    @ColumnInfo(name = "equipment_name")
    private String equipmentDetails;

    @ColumnInfo(name = "equipment_type")
    private String equipmentType;

    @ColumnInfo(name = "borrow_date")
    private Date borrowDate;

    @ColumnInfo(name = "return_date")
    private Date returnDate;

    // --- Constructor, Getters, and Setters ---
    public BorrowRecord() {}

    // --- Getters & Setters ---
    // (สร้าง Getters และ Setters สำหรับทุก Field รวมถึง equipmentType)
    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    // คุณสามารถสร้าง Constructor อื่นๆ เพื่อความสะดวกได้
    public BorrowRecord(String userName, String studentId, String phoneNumber, String equipmentDetails, Date borrowDate, Date returnDate) {
        this.userName = userName;
        this.studentId = studentId;
        this.phoneNumber = phoneNumber;
        this.equipmentDetails = equipmentDetails;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    // --- Getters ---
    // ... Getters และ Setters สำหรับ field อื่นๆ ...
    public String getUserName() { return userName; }
    public String getStudentId() { return studentId; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEquipmentDetails() { return equipmentDetails; }
    public Date getBorrowDate() { return borrowDate; }
    public Date getReturnDate() { return returnDate; }

    // --- Setters ---
    public void setUserName(String userName) { this.userName = userName; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setEquipmentDetails(String equipmentDetails) { this.equipmentDetails = equipmentDetails; }
    public void setBorrowDate(Date borrowDate) { this.borrowDate = borrowDate; }
    public void setReturnDate(Date returnDate) { this.returnDate = returnDate; }
}
