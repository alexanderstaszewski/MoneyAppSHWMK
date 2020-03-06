package com.example.moneyappshwmk;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cash")
public class Cash
{
    @PrimaryKey
    private int value;

    @ColumnInfo(name = "cash_amount")
    private String amount;

    public Cash(int value, String amount) {
        this.value = value;
        this.amount = amount;
    }
}
