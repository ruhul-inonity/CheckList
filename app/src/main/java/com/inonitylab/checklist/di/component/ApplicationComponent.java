package com.inonitylab.checklist.di.component;

import com.inonitylab.checklist.di.module.ApplicationModule;
import com.inonitylab.checklist.di.module.PresenterModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ruhul-inonity on 12/22/17.
 */

@Singleton
@Component(modules = {ApplicationModule.class, PresenterModule.class})
public interface ApplicationComponent {

}
