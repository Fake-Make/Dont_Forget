package com.example.dontforget.presenter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dontforget.R;
import com.example.dontforget.adapters.AlarmsListAdapter;
import com.example.dontforget.adapters.CardsListAdapter;
import com.example.dontforget.model.Alarm;
import com.example.dontforget.model.Alarms;
import com.example.dontforget.model.Card;
import com.example.dontforget.model.Cards;

import org.w3c.dom.Text;

public class CardPresenter extends APresenter implements IPresenter {
    protected long cardId;
    protected Card currentCard;

    public CardPresenter(Context context, long id) {
        parent = context;
        cardsList = new Cards<>(getFile(context));
        setCardId(id);
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
        currentCard = cardsList.getById(cardId);
    }

    public long getCardId() {
        return cardId;
    }

    public void showCardInfo(TextView captionView, TextView descriptionView) {
        if (null != currentCard) {
            captionView.setText(currentCard.getCaption());
            descriptionView.setText(currentCard.getDescription());
        }
    }

    public void switchEmptinessMessage(TextView emptinessMessage) {
        if(null == currentCard || null == currentCard.getAlarms() || currentCard.getAlarms().isEmpty())
            emptinessMessage.setVisibility(View.VISIBLE);
        else
            emptinessMessage.setVisibility(View.INVISIBLE);
    }

    public void showAlarms(RecyclerView recyclerViewAlarmsList) {
        recyclerViewAlarmsList.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(parent);
        recyclerViewAlarmsList.setLayoutManager(layoutManager);

        Alarms<Alarm> alarms = cardsList.getById(cardId).getAlarms();
        if (null != alarms && null != alarms.getList())
            recyclerViewAlarmsList.setAdapter(new AlarmsListAdapter(alarms.getList()));
    }
}
