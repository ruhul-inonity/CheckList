package com.inonitylab.checklist;

import android.app.Application;

import com.inonitylab.checklist.di.component.ApplicationComponent;
import com.inonitylab.checklist.di.component.DaggerApplicationComponent;
import com.inonitylab.checklist.di.module.ApplicationModule;

/**
 * Created by ruhul-ionity on 12/22/17.
 */

public class CheckListApp extends Application {
    public static final String TAG = CheckListApp.class.getSimpleName();
    public ApplicationComponent mApplicationComponent;
    private static CheckListApp mInstance;

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        mApplicationComponent = initDagger(this);

    }

    protected ApplicationComponent initDagger(CheckListApp application) {
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(application))
                .build();
    }

    public static synchronized CheckListApp getInstance() {
        return mInstance;
    }
}
