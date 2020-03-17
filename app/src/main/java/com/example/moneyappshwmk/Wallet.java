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
    @ColumnInfo(name = "cash_id")
    private int cash_id;

    @ColumnInfo(name = "value")
    private int value;

    @ColumnInfo(name = "amount")
    private int amount;

    public int getCash_id() {
        return cash_id;
    }

    public void setCash_id(int cash_id) {
        this.cash_id = cash_id;
    }

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

    public Wallet(int cash_id, int value, int amount) {
        this.cash_id = cash_id;
        this.value = value;
        this.amount = amount;
    }
}
