package com.android.inspireme.api.VidurQuotesApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VidurRetrofitClient {
    private static Retrofit retrofit = null;
    private static final String BASE_URL = "https://shloka.onrender.com/";

    public static VidurQuotesApiService getApiService() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(VidurQuotesApiService.class);
    }
}
