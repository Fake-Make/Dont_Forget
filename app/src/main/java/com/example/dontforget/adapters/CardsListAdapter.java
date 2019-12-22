package com.example.dontforget.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dontforget.CardActivity;
import com.example.dontforget.R;
import com.example.dontforget.model.Card;

import java.util.List;

public class CardsListAdapter extends RecyclerView.Adapter<CardsListAdapter.CardViewHolder> implements View.OnClickListener {
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
                .inflate(R.layout.list_item_card, parent, false);

        CardViewHolder vh = new CardViewHolder(v);
        v.setOnClickListener(this);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CardsListAdapter.CardViewHolder holder, int position) {
        Card currentCard = cardsList.get(position);

        ((TextView) holder.view.findViewById(R.id.textViewCardCaption)).setText(currentCard.getCaption());
        ((TextView) holder.view.findViewById(R.id.textViewCardDescription)).setText(currentCard.getDescription());
        ((TextView) holder.view.findViewById(R.id.hiddenCardId)).setText(String.valueOf(currentCard.getId()));
    }

    @Override
    public int getItemCount() {
        return cardsList.size();
    }

    @Override
    public void onClick(View v) {
        // Save card's id and transfer it into next Activity
        Intent intent = new Intent(v.getContext(), CardActivity.class);
        intent.putExtra("CARD_ID", ((TextView) v.findViewById(R.id.hiddenCardId)).getText().toString());
        v.getContext().startActivity(intent);
    }
}