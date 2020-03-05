package com.example.moneyappshwmk;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "transaction")
public class Transaction
{
    @PrimaryKey
    public int tid;

    @ColumnInfo
    public float change;
}
