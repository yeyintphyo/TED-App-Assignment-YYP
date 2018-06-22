package com.padcmyanmar.ted_app_assignment_yyp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.padcmyanmar.ted_app_assignment_yyp.R;
import com.padcmyanmar.ted_app_assignment_yyp.adapters.TalksAdapter;
import com.padcmyanmar.ted_app_assignment_yyp.data.models.TalksModel;
import com.padcmyanmar.ted_app_assignment_yyp.data.vos.TedTalksVO;
import com.padcmyanmar.ted_app_assignment_yyp.delegates.TalksDelegate;
import com.padcmyanmar.ted_app_assignment_yyp.events.SuccessGetTalksEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class TalksListActivity extends BaseActivity implements TalksDelegate{

    private TalksAdapter mTalksAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talks_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView rvTalks = findViewById(R.id.rv_talks);
        mTalksAdapter = new TalksAdapter(this);
        rvTalks.setAdapter(mTalksAdapter);
        rvTalks.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        TalksModel.getObjInstance().loadTalksList();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    public void onTagTalks(TedTalksVO tedTalk) {
        Intent intent = new Intent(getApplicationContext(), TalksDetailActivity.class);
        intent.putExtra("talkId", tedTalk.getTalkId());
        startActivity(intent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSuccessGetTalks(SuccessGetTalksEvent event){
        Log.d("onSuccessGetTalks", "onSuccessGetTalks" + event.getTalksList());
        mTalksAdapter.setTalksList(event.getTalksList());

    }
}
