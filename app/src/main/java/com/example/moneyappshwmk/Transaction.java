package com.example.moneyappshwmk;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import java.util.Date;

@Entity(tableName = "transaction")
@TypeConverters(DateConverter.class)
public class Transaction
{
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "transaction_id")
    private int transaction_id;

    @ColumnInfo(name = "change")
    private float change;

    @ColumnInfo(name = "date")
    private Date date;

    @ColumnInfo(name = "location")
    private String location;

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public float getChange() {
        return change;
    }

    public void setChange(float change) {
        this.change = change;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

