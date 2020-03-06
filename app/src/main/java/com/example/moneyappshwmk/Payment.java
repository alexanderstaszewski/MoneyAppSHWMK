package com.example.moneyappshwmk;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "payment", foreignKeys = @ForeignKey(entity = Transaction.class,
                                    parentColumns = "tid",
                                    childColumns = "value"))
public class Payment
{
    @PrimaryKey(autoGenerate = true)
    public int tid;

    @PrimaryKey
    public int value;

    @ColumnInfo(name = "payment_number")
    public int number;
}
