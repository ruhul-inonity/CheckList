package com.inonitylab.checklist.db;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by ruhul-inonity on 12/23/17.
 */
@Singleton
public class DataManager implements IDataManager {

    private Context mContext;
    private PreferencesHelper mPreferencesHelper;

    @Inject
    public DataManager(Context context,
                       PreferencesHelper preferencesHelper) {
        mContext = context;
        mPreferencesHelper = preferencesHelper;
    }


    @Override
    public void setUserName(String userName) {
        mPreferencesHelper.setUserName(userName);
    }

    @Override
    public String getUserName() {
        return mPreferencesHelper.getUserName();
    }
}
