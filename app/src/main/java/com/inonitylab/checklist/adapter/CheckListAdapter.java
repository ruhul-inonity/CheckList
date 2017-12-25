package com.inonitylab.checklist.adapter;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;

import com.inonitylab.checklist.CheckListApp;
import com.inonitylab.checklist.R;
import com.inonitylab.checklist.db.DataManager;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by ruhul on 12/23/17.
 */

 class CheckListAdapter  {

/*    private final Activity context;
    private final List<String> task, id, isdone;*/

  /*  @Inject
    DataManager mDatamanager;



    public CheckListAdapter(Activity context, List<String> i, List<String> t, List<String> d) {
        super(context, R.layout.checklist_item, t);
        this.context = context;
        (CheckListApp.getInstance()).getApplicationComponent().inject(this);
        task = t;
        id = i;
        isdone = d;
    }

    class ViewHolder {
        CheckBox c;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View vi = view;             //trying to reuse a recycled view
        ViewHolder holder = null;
        if (vi == null) {

            vi = inflater.inflate(R.layout.checklist_item, parent, false);
            holder = new ViewHolder();
            holder.c = (CheckBox) vi.findViewById(R.id.cb1);
            vi.setTag(holder);

        } else {
            holder = (ViewHolder) vi.getTag();
        }


        if (isdone.get(position).equals("1")) {
            holder.c.setPaintFlags(holder.c.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            holder.c.setChecked(true);
        } else {
            holder.c.setPaintFlags(holder.c.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
            holder.c.setChecked(false);
        }
        holder.c.setText(task.get(position));

  *//*      holder.c.setOnClickListener(view1 -> {
            CheckBox c2 = (CheckBox) view1;
           *//**//* if (c2.isChecked()) {

                String x = "UPDATE " + TableEntry.TABLE_NAME + " SET " + TableEntry.COLUMN_NAME_ISDONE + " = 1 WHERE " +
                        TableEntry.COLUMN_NAME_ID + " IS " + id.get(position);

                db.execSQL(x);
                Log.e("execited", x + " ");
            } else {
                String x = "UPDATE " + TableEntry.TABLE_NAME + " SET " + TableEntry.COLUMN_NAME_ISDONE + " = 0 WHERE " +
                        TableEntry.COLUMN_NAME_ID + " IS " + id.get(position);
                db.execSQL(x);
                Log.e("execited", x + " ");
            }*//**//*
            refresh();
        });*//*
        return vi;
    }
*/
}

