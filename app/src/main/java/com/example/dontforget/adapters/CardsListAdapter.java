package com.example.dontforget.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dontforget.R;
import com.example.dontforget.model.Card;

import java.util.ArrayList;
import java.util.List;

public class CardsListAdapter extends RecyclerView.Adapter<CardsListAdapter.CardViewHolder> {
    private List<Card> cardsList;
    public static class CardViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View view;

        public CardViewHolder(View view) {
            super(view);
            this.view = view;
        }
    }

    public CardsListAdapter(List<Card> cardsList) {
        this.cardsList = cardsList;
    }

    @NonNull
    @Override
    public CardsListAdapter.CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_as_list_item, parent, false);

        CardViewHolder vh = new CardViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CardsListAdapter.CardViewHolder holder, int position) {
        Card currentCard = cardsList.get(position);

        ((TextView) holder.view.findViewById(R.id.cardListItemCaption)).setText(currentCard.getCaption());
        ((TextView) holder.view.findViewById(R.id.cardListItemDescription)).setText(currentCard.getDescription());
    }

    @Override
    public int getItemCount() {
        return cardsList.size();
    }
}
