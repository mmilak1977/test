package com.example.agnieszka.kompetencyjny;

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by DELL on 2015-06-07.
 */
public class ListVisitAdapter extends BaseAdapter {

    Context context;

    protected List<MyVisit> listVisit;
    LayoutInflater inflater;

    public ListVisitAdapter(Context context, List<MyVisit> listVisit)
    {
        this.listVisit = listVisit;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return listVisit.size();
    }

    @Override
    public Object getItem(int position) {
        return listVisit.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listVisit.get(position).getDrawableId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null)
        {
            holder = new ViewHolder();
            convertView = this.inflater.inflate(R.layout.layout_list_item, parent, false);

            holder.txtTitle = (TextView) convertView.findViewById(R.id.txt_title_visit);
            holder.txtDate = (TextView) convertView.findViewById(R.id.txt_date_visit);
            holder.txtHour = (TextView) convertView.findViewById(R.id.txt_hour_visit);


            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        MyVisit myVisit = listVisit.get(position);
        holder.txtTitle.setText(myVisit.getTitleVisit());
        holder.txtDate.setText(myVisit.getDateVisit().toString());
        holder.txtHour.setText(myVisit.getHourVisit());


        return convertView;
    }

    private class ViewHolder {
        TextView txtTitle;
        TextView txtDate;
        TextView txtHour;

    }
}
