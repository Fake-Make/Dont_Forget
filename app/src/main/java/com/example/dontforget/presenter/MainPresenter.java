package com.example.dontforget.presenter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.dontforget.adapters.CardsListAdapter;
import com.example.dontforget.model.Cards;

public class MainPresenter extends APresenter implements IPresenter {
    public MainPresenter(Context context) {
        parent = context;
        cardsList = new Cards<>(getFile(context));
    }

    public void showCards(RecyclerView recyclerView) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new CardsListAdapter(cardsList.getList()));
    }

    public void switchEmptinessMessage(TextView emptinessMessage) {
        if(cardsList.isEmpty())
            emptinessMessage.setVisibility(View.VISIBLE);
        else
            emptinessMessage.setVisibility(View.INVISIBLE);
    }
}


