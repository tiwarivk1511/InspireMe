package com.android.inspireme.api.VidurQuotesApi;

import com.android.inspireme.database.vidurDB.VidurQuote;

import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

public interface VidurQuotesApiService {
    @GET("api/v1/vidur_niti/all")
    Call<List<VidurQuote>> getQuotes();
}
