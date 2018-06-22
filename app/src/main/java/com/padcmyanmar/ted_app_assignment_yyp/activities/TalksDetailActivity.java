package com.padcmyanmar.ted_app_assignment_yyp.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.padcmyanmar.ted_app_assignment_yyp.R;
import com.padcmyanmar.ted_app_assignment_yyp.adapters.TalksAdapter;
import com.padcmyanmar.ted_app_assignment_yyp.adapters.TalksDetailsAdapter;
import com.padcmyanmar.ted_app_assignment_yyp.data.vos.TedTalksVO;
import com.padcmyanmar.ted_app_assignment_yyp.delegates.TalksDelegate;

public class TalksDetailActivity extends BaseActivity implements TalksDelegate {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talks_details);

        RecyclerView rvTalks = findViewById(R.id.rv_next_talks_list);
        TalksDetailsAdapter talksDetailsAdapter = new TalksDetailsAdapter(this);
        rvTalks.setAdapter(talksDetailsAdapter);
        rvTalks.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

    }

    @Override
    public void onTagTalks(TedTalksVO talksVO) {

    }
}
