package com.android.inspireme.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.inspireme.R;
import com.android.inspireme.database.vidurDB.VidurQuote;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class vidurQuotesAdapter extends RecyclerView.Adapter<vidurQuotesAdapter.ViewHolder> {
    private List<VidurQuote> quotes;
    private Context context;

    public vidurQuotesAdapter(List<VidurQuote> quotes, Context context) {
        this.quotes = quotes;
        this.context = context;
    }

    @NonNull
    @Override
    public vidurQuotesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quotes_layout, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull vidurQuotesAdapter.ViewHolder holder, int position) {
        VidurQuote quote = quotes.get(position);
        holder.quoteText.setText(quote.getText());
        holder.translatedText.setText(quote.getTranslatedText());
        holder.writerText.setText(quote.getWriter());
        holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.drawable.vidur));

        holder.downloadBtn.setOnClickListener(v -> {
            // Implement download the quote as PNG Image
        });

        holder.shareBtn.setOnClickListener(v -> {
            // Implement share the quote as PNG Image
        });

        holder.copyBtn.setOnClickListener(v -> {
            // Implement copy the quote as text here
        });
    }

    @Override
    public int getItemCount() {
        return quotes != null ? quotes.size() : 0;
    }

    // Method to update the list of quotes
    public void updateQuotes(List<VidurQuote> newQuotes) {
        this.quotes = newQuotes;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView quoteText;
        public TextView translatedText;
        public TextView writerText;
        public MaterialButton downloadBtn;
        public MaterialButton shareBtn;
        public MaterialButton copyBtn;
        public MaterialCardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            quoteText = itemView.findViewById(R.id.quoteTxt);
            translatedText = itemView.findViewById(R.id.translatedTxt);
            writerText = itemView.findViewById(R.id.writerTxt);
            downloadBtn = itemView.findViewById(R.id.downloadBtn);
            shareBtn = itemView.findViewById(R.id.shareBtn);
            copyBtn = itemView.findViewById(R.id.copyBtn);
            cardView = itemView.findViewById(R.id.quoteLayout);
        }
    }
}
