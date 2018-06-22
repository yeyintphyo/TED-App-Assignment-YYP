package com.padcmyanmar.ted_app_assignment_yyp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.ted_app_assignment_yyp.R;
import com.padcmyanmar.ted_app_assignment_yyp.data.vos.TedTalksVO;
import com.padcmyanmar.ted_app_assignment_yyp.delegates.TalksDelegate;
import com.padcmyanmar.ted_app_assignment_yyp.viewholders.TalksViewHolder;

import java.util.ArrayList;
import java.util.List;

public class TalksAdapter extends RecyclerView.Adapter<TalksViewHolder> {
    private TalksDelegate mTalksDelegate;
    private List<TedTalksVO> talksList;

    public TalksAdapter(TalksDelegate talksDelegate) {
        mTalksDelegate = talksDelegate;
        talksList = new ArrayList<>();
    }

    @Override
    public TalksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.view_holder_talks, parent, false);
        return new TalksViewHolder(view, mTalksDelegate);
    }

    @Override
    public void onBindViewHolder(@NonNull TalksViewHolder holder, int position) {
        holder.setTalksData(talksList.get(position));
    }

    @Override
    public int getItemCount() {
        return talksList.size();
    }

    public void setTalksList(List<TedTalksVO> talksList) {
        this.talksList = talksList;
        notifyDataSetChanged();
    }
}
