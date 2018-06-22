package com.padcmyanmar.ted_app_assignment_yyp.data.models;

import com.padcmyanmar.ted_app_assignment_yyp.data.vos.TedTalksVO;
import com.padcmyanmar.ted_app_assignment_yyp.events.SuccessGetTalksEvent;
import com.padcmyanmar.ted_app_assignment_yyp.network.HttpUrlConnectionTalksDataAgentImpl;
import com.padcmyanmar.ted_app_assignment_yyp.network.TalksDataAgent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.Map;

public class TalksModel {

    private static final String DUMMY_ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916";
    private static TalksModel objInstance;

    private TalksDataAgent mTalksDataAgent;
    private Map<String, TedTalksVO> mtalksMap;

    private TalksModel() {
        mTalksDataAgent = HttpUrlConnectionTalksDataAgentImpl.getInstance();
        mtalksMap = new HashMap<>();

        EventBus.getDefault().register(this);

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

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onSuccessGetNews (SuccessGetTalksEvent event) {
        for (TedTalksVO talksVO : event.getTalksList()) {
            mtalksMap.put(talksVO.getTalkId(), talksVO);
        }
    }
}
