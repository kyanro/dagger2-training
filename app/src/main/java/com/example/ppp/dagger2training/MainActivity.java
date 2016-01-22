package com.example.ppp.dagger2training;

import android.app.Application;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ppp.dagger2training.models.User;
import com.example.ppp.dagger2training.network.GithubApi;

import javax.inject.Inject;

import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Inject
    GithubApi githubApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TrainApp.AppComponent component = ((TrainApp) getApplication()).getAppComponent();
        component.inject(this);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        githubApi.getUserAsync("kyanro").enqueue(new Callback<User>() {
            @Override
            public void onResponse(Response<User> response) {
                Log.d("my", response.body().login);
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
