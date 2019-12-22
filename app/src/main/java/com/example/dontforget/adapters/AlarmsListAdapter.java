package com.example.dontforget.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dontforget.R;
import com.example.dontforget.model.Alarm;

import java.util.List;

public class AlarmsListAdapter extends RecyclerView.Adapter<AlarmsListAdapter.AlarmViewHolder> implements View.OnClickListener {
    private List<Alarm> alarmsList;

    public static class AlarmViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View view;

        public AlarmViewHolder(View view) {
            super(view);
            this.view = view;
        }
    }

    public AlarmsListAdapter(List<Alarm> alarmsList) {
        this.alarmsList = alarmsList;
    }

    @NonNull
    @Override
    public AlarmsListAdapter.AlarmViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_alarm, parent, false);

        AlarmsListAdapter.AlarmViewHolder vh = new AlarmsListAdapter.AlarmViewHolder(v);
        v.setOnClickListener(this);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AlarmsListAdapter.AlarmViewHolder holder, int position) {
        Alarm currentAlarm = alarmsList.get(position);

        ((TextView) holder.view.findViewById(R.id.textViewListItemAlarmCaption)).setText(currentAlarm.getCaption());
        ((TextView) holder.view.findViewById(R.id.textViewListItemAlarmDatetime)).setText(currentAlarm.getDatetime());
        ((TextView) holder.view.findViewById(R.id.hiddenAlarmId)).setText(String.valueOf(currentAlarm.getId()));
    }

    @Override
    public int getItemCount() {
        return alarmsList.size();
    }

    @Override
    public void onClick(View v) {
        // Save card's id and transfer it into next Activity
        //Intent intent = new Intent(v.getContext(), CardActivity.class);
        //intent.putExtra("CARD_ID", ((TextView) v.findViewById(R.id.hiddenCardId)).getText().toString());
        //v.getContext().startActivity(intent);
    }
}
