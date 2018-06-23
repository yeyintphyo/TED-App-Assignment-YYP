package com.padcmyanmar.ted_app_assignment_yyp.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.ted_app_assignment_yyp.R;
import com.padcmyanmar.ted_app_assignment_yyp.data.vos.TedTalksVO;
import com.padcmyanmar.ted_app_assignment_yyp.delegates.TalksDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TalksDetailsViewHolder extends RecyclerView.ViewHolder{

    private TalksDelegate mTalksDelegate;

    private TedTalksVO mTalk;

    @BindView(R.id.iv_talk_img)
    ImageView ivTalkImg;

    @BindView(R.id.tv_name)
    TextView tvName;

    @BindView(R.id.tv_description)
    TextView tvDescription;

    @BindView(R.id.tv_post_time)
    TextView tvPostTime;

    public TalksDetailsViewHolder(View itemView, TalksDelegate talksDelegate){
        super(itemView);
        ButterKnife.bind(this, itemView);

        mTalksDelegate = talksDelegate;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTalksDelegate.onTagTalks(mTalk);
            }
        });
    }

    public void setTalksData (TedTalksVO tedTalk) {
        mTalk = tedTalk;

        if (!tedTalk.getImageUrl().isEmpty()) {
            ivTalkImg.setVisibility(View.VISIBLE);
            Glide.with(ivTalkImg.getContext())
                    .load(tedTalk.getImageUrl())
                    .into(ivTalkImg);
        } else {
            ivTalkImg.setVisibility(View.GONE);
        }

        if (tedTalk.getSpeaker() != null) {
            tvName.setText(tedTalk.getSpeaker().getName());
        }

        tvDescription.setText(tedTalk.getTitle());
        tvPostTime.setText(tedTalk.getDurationInSec());

    }
}
