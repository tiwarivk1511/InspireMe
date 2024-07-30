package com.android.inspireme.api.VidurQuotesApi;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.android.inspireme.database.vidurDB.VidurQuote;

import java.util.List;

@Dao
public interface VidurQuoteDao {
    @Insert
    void insertAll(List<VidurQuote> quotes);

    @Query("SELECT * FROM vidur_quotes")
    LiveData<List<VidurQuote>> getAllQuotes();
}
