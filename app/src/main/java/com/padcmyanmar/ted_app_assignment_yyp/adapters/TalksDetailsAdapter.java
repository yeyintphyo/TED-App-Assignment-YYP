package com.padcmyanmar.ted_app_assignment_yyp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.ted_app_assignment_yyp.R;
import com.padcmyanmar.ted_app_assignment_yyp.delegates.TalksDelegate;
import com.padcmyanmar.ted_app_assignment_yyp.viewholders.TalksViewHolder;

public class TalksDetailsAdapter extends RecyclerView.Adapter {
    private TalksDelegate mtalTalksDelegate;

    public TalksDetailsAdapter(TalksDelegate talksDelegate) {
        mtalTalksDelegate = talksDelegate;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.view_holder_talks_details, parent, false);
        return new TalksViewHolder(view, mtalTalksDelegate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
