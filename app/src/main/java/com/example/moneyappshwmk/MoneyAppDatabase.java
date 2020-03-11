package com.example.moneyappshwmk;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(
        entities = {
                Cash.class,
                Payment.class,
                Transaction.class
        },
        exportSchema = false, version = 1)
public abstract class MoneyAppDatabase extends RoomDatabase
{
    private static final String db_name = "money_app_db";
    private static MoneyAppDatabase instance;

    public static synchronized MoneyAppDatabase getInstance(Context context)
    {
        if(instance == null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext(), MoneyAppDatabase.class, db_name).fallbackToDestructiveMigration().build();
        }
        //please fix this later
        return instance;
    }
    public abstract DAO money_dao();
}
