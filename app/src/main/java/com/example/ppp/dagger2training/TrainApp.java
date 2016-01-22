package com.example.ppp.dagger2training;

import android.app.Application;
import android.support.annotation.VisibleForTesting;

import com.example.ppp.dagger2training.network.NetModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ppp on 2016/01/23.
 */
public class TrainApp extends Application {
    AppComponent appComponent;

    @Singleton
    @Component(modules = NetModule.class)
    public interface AppComponent {
        void inject(MainActivity mainActivity);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // DI用
        if (appComponent == null) {
            appComponent = DaggerTrainApp_AppComponent.builder()
                    .netModule(new NetModule("https://api.github.com"))
                    .build();
        }
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    @VisibleForTesting
    public void setAppComponent(AppComponent appComponent) {
        this.appComponent = appComponent;
    }
}
