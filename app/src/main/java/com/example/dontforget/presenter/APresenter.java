package com.example.dontforget.presenter;

import android.content.Context;

import com.example.dontforget.model.Card;
import com.example.dontforget.model.Cards;

import java.io.File;
import java.io.IOException;

public abstract class APresenter implements IPresenter {
    protected Context parent;
    protected Cards<Card> cardsList;

    protected File getFile(Context context) {
        return context.getFilesDir();
    }
}
