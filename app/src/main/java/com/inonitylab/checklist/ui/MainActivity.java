package com.inonitylab.checklist.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;

import com.inonitylab.checklist.CheckListApp;
import com.inonitylab.checklist.R;
import com.inonitylab.checklist.db.DataManager;
import com.inonitylab.checklist.model.Task;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";


    private final List<String> taskId = new ArrayList<>();
    private final List<String> task = new ArrayList<>();
    private final List<String> isdone = new ArrayList<>();

    private CheckListAdapter checkAdapter;

    DateFormat df;
    String date;

    @Inject
    DataManager mDataManager;
    @BindView(R.id.lvAllTasks)
    ListView lvAllTasks;


    @SuppressLint("SimpleDateFormat")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((CheckListApp) getApplication()).getApplicationComponent().inject(this);
        ButterKnife.bind(this);

        df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm");
        date = df.format(Calendar.getInstance().getTime());

        mDataManager.setUserName("Captain Jack Sparrow");
        Log.d(TAG, "onCreate: .................................. " + mDataManager.getUserName());


        firstTimeDemoData();


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void firstTimeDemoData() {

        if (mDataManager.isFirstTime()) {
            Task task1 = new Task("Bags", "0", date);
            Task task2 = new Task("Charger", "0", date);
            Task task3 = new Task("Earphones", "0", date);
            Task task4 = new Task("Clothes", "0", date);


            try {
                mDataManager.insertTask(task1);
                mDataManager.insertTask(task2);
                mDataManager.insertTask(task3);
                mDataManager.insertTask(task4);
            } catch (Exception e1) {
                e1.printStackTrace();
            }

            mDataManager.setFirstTimeStatus(false);
        }

        checkAdapter = new CheckListAdapter(this, taskId, task, isdone);
        lvAllTasks.setAdapter(checkAdapter);

        refresh();
    }

    private void refresh() {
        taskId.clear();
        task.clear();
        isdone.clear();
        checkAdapter.notifyDataSetChanged();
        ArrayList<Task> taskArrayList = mDataManager.getAllTask();

        for (Task t : taskArrayList) {
            taskId.add(String.valueOf(t.getTaskId()));
            task.add(t.getTask());
            isdone.add(t.getIsDone());
        }
        checkAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class CheckListAdapter extends ArrayAdapter<String> {

        private final Activity context;
        private final List<String> task, id, isdone;

    /*    @Inject
        DataManager mDatamanager;*/



        private CheckListAdapter(Activity context, List<String> i, List<String> t, List<String> d) {
            super(context, R.layout.checklist_item, t);
            this.context = context;
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
                holder.c = vi.findViewById(R.id.cb1);
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

  /*      holder.c.setOnClickListener(view1 -> {
            CheckBox c2 = (CheckBox) view1;
           *//* if (c2.isChecked()) {

                String x = "UPDATE " + TableEntry.TABLE_NAME + " SET " + TableEntry.COLUMN_NAME_ISDONE + " = 1 WHERE " +
                        TableEntry.COLUMN_NAME_ID + " IS " + id.get(position);

                db.execSQL(x);
                Log.e("execited", x + " ");
            } else {
                String x = "UPDATE " + TableEntry.TABLE_NAME + " SET " + TableEntry.COLUMN_NAME_ISDONE + " = 0 WHERE " +
                        TableEntry.COLUMN_NAME_ID + " IS " + id.get(position);
                db.execSQL(x);
                Log.e("execited", x + " ");
            }*//*
            refresh();
        });*/
            return vi;
        }

    }

}
