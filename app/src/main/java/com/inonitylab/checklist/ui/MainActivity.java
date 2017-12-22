package com.inonitylab.checklist.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.inonitylab.checklist.CheckListApp;
import com.inonitylab.checklist.R;
import com.inonitylab.checklist.db.DataManager;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";

    @Inject
    DataManager mDataManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((CheckListApp) getApplication()).getApplicationComponent().inject(this);
        ButterKnife.bind(this);

        mDataManager.setUserName("Captain Jack Sparrow");
        Log.d(TAG, "onCreate: .................................. "+mDataManager.getUserName());


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
}
