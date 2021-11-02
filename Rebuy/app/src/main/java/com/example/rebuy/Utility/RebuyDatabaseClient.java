package com.example.rebuy.Utility;

import android.content.Context;

import androidx.room.Room;

public class RebuyDatabaseClient
{
    private Context context;
    private static RebuyDatabaseClient RubuyInstance;

    private RebuyDatabase rebuyDatabase;

    public RebuyDatabaseClient(Context context) {
        this.context = context;
        rebuyDatabase= Room.databaseBuilder(context,RebuyDatabase.class,"MyDB").allowMainThreadQueries().build();
    }
    public static synchronized RebuyDatabaseClient getRebuyInstance(Context context)
    {
        if (RubuyInstance==null)
        {
            RubuyInstance=new RebuyDatabaseClient(context);
        }
        return RubuyInstance;
    }
    public RebuyDatabase getRebuyDatabase()
    {
        return rebuyDatabase;
    }
}
