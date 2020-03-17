package com.example.moneyappshwmk;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "payment",
        primaryKeys = {"cash_id", "transaction_id"},
        foreignKeys = {
                @ForeignKey(entity = Transaction.class,
                        parentColumns = "transaction_id",
                        childColumns = "transaction_id"),
                @ForeignKey(entity = Wallet.class,
                        parentColumns = "cash_id",
                        childColumns = "cash_id")
        })
public class WalletTransactions
{
    @ColumnInfo(name = "cash_id")
    private int cash_id;

    @ColumnInfo(name = "transaction_id")
    private int transaction_id;

    public int getCash_id() {
        return cash_id;
    }

    public void setCash_id(int cash_id) {
        this.cash_id = cash_id;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @ColumnInfo(name = "count")
    public int count;
}
