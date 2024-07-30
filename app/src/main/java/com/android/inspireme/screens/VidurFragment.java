package com.android.inspireme.screens;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.inspireme.Adapters.vidurQuotesAdapter;
import com.android.inspireme.R;
import com.android.inspireme.api.VidurQuotesApi.VidurQuotesApiService;
import com.android.inspireme.api.VidurQuotesApi.VidurQuotesDatabase;
import com.android.inspireme.api.VidurQuotesApi.VidurRetrofitClient;
import com.android.inspireme.database.vidurDB.VidurQuote;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VidurFragment extends Fragment {

    private RecyclerView recyclerView;
    private vidurQuotesAdapter adapter;
    private VidurQuotesDatabase db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vidur, container, false);
        recyclerView = view.findViewById(R.id.VidurRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize the adapter with an empty list to avoid null checks later
        adapter = new vidurQuotesAdapter(new ArrayList<>(), getContext());
        recyclerView.setAdapter(adapter);

        db = VidurQuotesDatabase.getDatabase(getContext());

        // Load data from API
        loadQuotesFromApi();

        // Observe the database and update the RecyclerView
        LiveData<List<VidurQuote>> quotesLiveData = db.quoteDao().getAllQuotes();
        quotesLiveData.observe(getViewLifecycleOwner(), new Observer<List<VidurQuote>>() {
            @Override
            public void onChanged(List<VidurQuote> quotes) {
                adapter.updateQuotes(quotes);
            }
        });

        return view;
    }

    private void loadQuotesFromApi() {
        VidurQuotesApiService apiService = VidurRetrofitClient.getApiService();
        apiService.getQuotes().enqueue(new Callback<List<VidurQuote>>() {
            @Override
            public void onResponse(Call<List<VidurQuote>> call, Response<List<VidurQuote>> response) {
                if (response.isSuccessful()) {
                    List<VidurQuote> quotes = response.body();
                    if (quotes != null) {
                        // Insert data into Room database in a separate thread
                        new Thread(() -> db.quoteDao().insertAll(quotes)).start();
                    }
                } else {
                    Log.e("API_ERROR", "Failed to fetch quotes");
                }
            }

            @Override
            public void onFailure(Call<List<VidurQuote>> call, Throwable t) {
                Log.e("API_FAILURE", "Failed to fetch quotes", t);
            }
        });
    }
}
