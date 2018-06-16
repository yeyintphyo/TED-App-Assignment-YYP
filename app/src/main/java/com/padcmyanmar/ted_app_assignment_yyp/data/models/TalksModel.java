package com.padcmyanmar.ted_app_assignment_yyp.data.models;

import com.padcmyanmar.ted_app_assignment_yyp.network.HttpUrlConnectionTalksDataAgentImpl;
import com.padcmyanmar.ted_app_assignment_yyp.network.TalksDataAgent;

public class TalksModel {

    private static final String DUMMY_ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916";
    private static TalksModel objInstance;

    private TalksDataAgent mTalksDataAgent;

    private TalksModel() {
        mTalksDataAgent = HttpUrlConnectionTalksDataAgentImpl.getInstance();
    }

    public static TalksModel getObjInstance() {
        if (objInstance == null){
            objInstance = new TalksModel();
        }
        return objInstance;
    }

    public void loadTalksList() {
        mTalksDataAgent.loadTalksList(1, DUMMY_ACCESS_TOKEN);
    }
}
