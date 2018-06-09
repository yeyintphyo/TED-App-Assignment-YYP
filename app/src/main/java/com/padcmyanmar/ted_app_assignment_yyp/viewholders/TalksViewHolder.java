package com.padcmyanmar.ted_app_assignment_yyp.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.padcmyanmar.ted_app_assignment_yyp.delegates.TalksDelegate;

public class TalksViewHolder extends RecyclerView.ViewHolder {
    private TalksDelegate mTalksDelegate;
    public TalksViewHolder(View itemView, TalksDelegate talksDelegate){
        super(itemView);
        mTalksDelegate = talksDelegate;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTalksDelegate.onTagTalks();
            }
        });

    }
}
