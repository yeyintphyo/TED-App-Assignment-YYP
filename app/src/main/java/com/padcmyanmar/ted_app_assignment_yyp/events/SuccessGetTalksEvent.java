package com.padcmyanmar.ted_app_assignment_yyp.events;

import com.padcmyanmar.ted_app_assignment_yyp.data.vos.TedTalksVO;

import java.util.List;

public class SuccessGetTalksEvent {

    private List<TedTalksVO> talksList;

    public SuccessGetTalksEvent (List<TedTalksVO> talksList) {
        this.talksList = talksList;
    }

    public List<TedTalksVO> getTalksList() {
        return talksList;
    }
}
