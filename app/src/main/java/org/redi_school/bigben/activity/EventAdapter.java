package org.redi_school.bigben.activity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.redi_school.bigben.R;
import org.redi_school.bigben.entities.Event;

import java.util.List;

/**
 * Created by root on 21.07.17.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {


    private List<Event> events;

    public EventAdapter(List<Event> users) {
        this.events = users;
    }



    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_event, parent, false);
        return new EventViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        final Event item = events.get(position);
        holder.name.setText(item.getName());
        holder.owner.setText(item.getOwner());
        holder.Location.setText( "" + item.getPlace());
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    static class EventViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView owner;
        TextView Location;
        TextView date;

        public EventViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.event_textView);
            owner = (TextView) itemView.findViewById(R.id.owner_textView);
            Location = (TextView) itemView.findViewById(R.id.location_textView);
            date = (TextView) itemView.findViewById(R.id.date_textView);
        }
    }
}
