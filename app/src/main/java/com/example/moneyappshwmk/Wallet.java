package com.example.moneyappshwmk;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cash")
public class Wallet
{
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int wallet_wid;

    private int value;
    private int amount;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getAmount() {

        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Wallet(int value, int amount) {
        this.value = value;
        this.amount = amount;
    }
}
