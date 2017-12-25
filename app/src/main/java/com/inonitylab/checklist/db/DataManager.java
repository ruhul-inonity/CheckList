package com.inonitylab.checklist.db;

import android.content.Context;
import android.content.res.Resources;

import com.inonitylab.checklist.model.Task;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by ruhul-inonity on 12/23/17.
 */
@Singleton
public class DataManager implements IDataManager {

    private Context mContext;
    private PreferencesHelper mPreferencesHelper;
    private DbHelper mDbHelper;

    @Inject
    public DataManager(Context context,
                       PreferencesHelper preferencesHelper,  DbHelper dbHelper) {
        mContext = context;
        mPreferencesHelper = preferencesHelper;
        mDbHelper = dbHelper;
    }


    @Override
    public void setUserName(String userName) {
        mPreferencesHelper.setUserName(userName);
    }

    @Override
    public String getUserName() {
        return mPreferencesHelper.getUserName();
    }

    @Override
    public void setFirstTimeStatus(boolean flag) {
        mPreferencesHelper.setFirstTimeStatus(flag);
    }

    @Override
    public boolean isFirstTime() {
        return mPreferencesHelper.isFirstTime();
    }

    @Override
    public Long insertTask(Task task) throws Exception {
        return mDbHelper.insertTask(task);
    }

    @Override
    public ArrayList<Task> getAllTask() throws Resources.NotFoundException, NullPointerException {
        return mDbHelper.getAllTask();
    }
}
