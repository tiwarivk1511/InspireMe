package com.android.inspireme.api.VidurQuotesApi;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

import com.android.inspireme.database.vidurDB.VidurQuote;

@Database(entities = {VidurQuote.class}, version = 2) // Incremented version number
public abstract class VidurQuotesDatabase extends RoomDatabase {
    public abstract VidurQuoteDao quoteDao();

    private static volatile VidurQuotesDatabase INSTANCE;

    public static VidurQuotesDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (VidurQuotesDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    VidurQuotesDatabase.class, "vidur_quotes_database")
                            .fallbackToDestructiveMigration() // This will delete old data
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
