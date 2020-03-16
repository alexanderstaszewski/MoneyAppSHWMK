package com.example.moneyappshwmk;

import androidx.annotation.NonNull;
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
    private int transaction_tid;

    private float change;
    private Date date;
    private String location;

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

