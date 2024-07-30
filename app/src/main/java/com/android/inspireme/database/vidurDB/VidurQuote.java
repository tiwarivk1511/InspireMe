package com.android.inspireme.database.vidurDB;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "vidur_quotes")
public class VidurQuote {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String text;
    private String translatedText;
    private String writer;

    // Getters and Setters...

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
