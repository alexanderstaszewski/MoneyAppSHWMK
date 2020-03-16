package com.example.moneyappshwmk;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "payment",
        primaryKeys = {"tid", "value"},
        foreignKeys = {
                @ForeignKey(entity = Transaction.class,
                        parentColumns = "transaction_tid",
                        childColumns = "payment_tid"),
                @ForeignKey(entity = Wallet.class,
                        parentColumns = "wallet_wid",
                        childColumns = "payment_wid")
        })
public class Payment
{
    @PrimaryKey
    private int payment_tid;

    @PrimaryKey
    private int payment_wid;

    @ColumnInfo
    public int number;
}
