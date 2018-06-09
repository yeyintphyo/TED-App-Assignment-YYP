package com.padcmyanmar.ted_app_assignment_yyp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.padcmyanmar.ted_app_assignment_yyp.R;
import com.padcmyanmar.ted_app_assignment_yyp.adapters.TalksAdapter;
import com.padcmyanmar.ted_app_assignment_yyp.delegates.TalksDelegate;

public class TalksListActivity extends BaseActivity implements TalksDelegate{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talks_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView rvTalks = findViewById(R.id.rv_talks);
        TalksAdapter talksAdapter = new TalksAdapter(this);
        rvTalks.setAdapter(talksAdapter);
        rvTalks.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

    }

    @Override
    public void onTagTalks() {
        Intent intent = new Intent(getApplicationContext(), TalksDetailActivity.class);
        startActivity(intent);
    }
}
