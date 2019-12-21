package com.example.dontforget.presenter;

import android.content.Context;
import android.widget.EditText;

import com.example.dontforget.model.Card;
import com.example.dontforget.model.Cards;

public class CreatingCardPresenter extends APresenter implements IPresenter {
    protected String caption, description;

    public CreatingCardPresenter(Context context) {
        cardsList = new Cards<>(getFile(context));
    }

    public void setCaption(EditText editTextCaption) {
        caption = editTextCaption.getText().toString();
    }

    public void setDescription(EditText editTextDescription) {
        description = editTextDescription.getText().toString();
    }

    public int createCard() {
        if (null == caption || 0 >= caption.length())
            return 1;

        cardsList.add(new Card(caption, description));
        return 0;
    }
}
