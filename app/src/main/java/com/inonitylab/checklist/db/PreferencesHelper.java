package com.inonitylab.checklist.db;

import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by ruhul-inonity on 12/23/17.
 */
@Singleton
public class PreferencesHelper implements IPreferencesHelper {
    public static final String PREF_NAME = "CHECKLISTPREFS";

    public static final String PREF_KEY_USER_NAME = "name";

    private final SharedPreferences mPreferenceHelper;

    @Inject
    public PreferencesHelper(SharedPreferences sharedPreferences) {
        mPreferenceHelper = sharedPreferences;
    }


    @Override
    public void setUserName(String userName) {
        mPreferenceHelper.edit().putString(PREF_KEY_USER_NAME, userName).apply();
    }

    @Override
    public String getUserName() {
        return mPreferenceHelper.getString(PREF_KEY_USER_NAME,null);
    }
}
