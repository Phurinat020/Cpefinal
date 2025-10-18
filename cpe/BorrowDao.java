package com.example.cpe;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BorrowDao {

    @Insert
    void insert(BorrowRecord borrowRecord);

    @Query("SELECT * FROM borrow_records ORDER BY borrow_date DESC")
    List<BorrowRecord> getAllRecords();
}



