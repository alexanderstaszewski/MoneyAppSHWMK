package com.example.moneyappshwmk;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "payment",
        primaryKeys = {"tid", "value"},
        foreignKeys = @ForeignKey(entity = Transaction.class,
                                    parentColumns = "tid",
                                    childColumns = "value"))
public  class Payment
{
    public int tid;

    public int value;

    @ColumnInfo(name = "payment_number")
    public int number;
}
