package com.example.dontforget.presenter;

import com.example.dontforget.model.Card;
import com.example.dontforget.model.Cards;

public abstract class APresenter implements IPresenter {
    protected Cards<Card> cardsList;
}
