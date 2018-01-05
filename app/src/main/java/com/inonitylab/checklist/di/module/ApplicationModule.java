package com.inonitylab.checklist.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.inonitylab.checklist.db.PreferencesHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ruhul-inonity on 12/22/17.
 */
//first thing to implement

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application){
        this.mApplication = application;
    }

    @Provides
    @Singleton
    public Context provideContext(){
        return mApplication;
    }

    @Provides
    Application provideApplication(){
        return mApplication;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPrefs() {
        return mApplication.getSharedPreferences(PreferencesHelper.PREF_NAME, Context.MODE_PRIVATE);
    }


}
