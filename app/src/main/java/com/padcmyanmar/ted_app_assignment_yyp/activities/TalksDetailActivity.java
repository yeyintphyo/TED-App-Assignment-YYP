package com.padcmyanmar.ted_app_assignment_yyp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.ted_app_assignment_yyp.R;
import com.padcmyanmar.ted_app_assignment_yyp.adapters.TalksAdapter;
import com.padcmyanmar.ted_app_assignment_yyp.adapters.TalksDetailsAdapter;
import com.padcmyanmar.ted_app_assignment_yyp.data.models.TalksModel;
import com.padcmyanmar.ted_app_assignment_yyp.data.vos.TedTalksVO;
import com.padcmyanmar.ted_app_assignment_yyp.delegates.TalksDelegate;
import com.padcmyanmar.ted_app_assignment_yyp.utils.TalksConstants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TalksDetailActivity extends BaseActivity implements TalksDelegate {

    @BindView(R.id.tv_talker_name)
    TextView tvTalkerName;

    @BindView(R.id.iv_talks_backdrop)
    ImageView ivTalksBackdrop;

    @BindView(R.id.tv_talks_title)
    TextView tvTalksTitle;

    @BindView(R.id.tv_talks_time)
    TextView tvTalksTime;

    @BindView(R.id.tv_talks_details)
    TextView tvTalksDetails;

    @BindView(R.id.tv_about_speaker_name)
    TextView tvSpeakerName;

    @BindView(R.id.tv_about_speaker_job)
    TextView tvAboutSpeakerJob;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talks_details);
        ButterKnife.bind(this,this);

        RecyclerView rvTalks = findViewById(R.id.rv_next_talks_list);
        TalksDetailsAdapter talksDetailsAdapter = new TalksDetailsAdapter(this);
        rvTalks.setAdapter(talksDetailsAdapter);
        rvTalks.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        String talkId = getIntent().getStringExtra(TalksConstants.TALK_ID);
        Log.d("TalksDetailsActivity", TalksConstants.TALK_ID + talkId);

        TedTalksVO talksVO = TalksModel.getObjInstance().getTalksById(talkId);
        bindData(talksVO, talksDetailsAdapter);

    }

    private void bindData(TedTalksVO talk, TalksDetailsAdapter detailsAdapter) {
        if(talk.getSpeaker() != null){
            tvTalkerName.setText(talk.getSpeaker().getName());
            tvSpeakerName.setText(talk.getSpeaker().getName());
        }
        if (!talk.getImageUrl().isEmpty()) {
            ivTalksBackdrop.setVisibility(View.VISIBLE);
            Glide.with(ivTalksBackdrop.getContext())
                    .load(talk.getImageUrl())
                    .into(ivTalksBackdrop);
        } else {
            ivTalksBackdrop.setVisibility(View.GONE);
        }

        tvTalksTitle.setText(talk.getTitle());
        tvTalksTime.setText(talk.getDurationInSec());
        tvTalksDetails.setText(talk.getDescription());
        tvAboutSpeakerJob.setText(talk.getTitle());

        detailsAdapter.setTalksList(TalksModel.getObjInstance().getTalksList());
    }

    @Override
    public void onTagTalks(TedTalksVO tedTalk) {
        Intent intent = new Intent(getApplicationContext(), TalksDetailActivity.class);
        intent.putExtra(TalksConstants.TALK_ID, tedTalk.getTalkId());
        startActivity(intent);
    }
}
