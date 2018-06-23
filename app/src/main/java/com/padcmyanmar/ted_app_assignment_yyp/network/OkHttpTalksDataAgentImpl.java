package com.padcmyanmar.ted_app_assignment_yyp.network;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.padcmyanmar.ted_app_assignment_yyp.events.ApiErrorEvent;
import com.padcmyanmar.ted_app_assignment_yyp.events.SuccessGetTalksEvent;
import com.padcmyanmar.ted_app_assignment_yyp.network.response.GetTalksResponse;
import com.padcmyanmar.ted_app_assignment_yyp.utils.TalksConstants;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpTalksDataAgentImpl implements TalksDataAgent {

    private static OkHttpTalksDataAgentImpl sObjInstance;

    private OkHttpClient mHttpClient;

    private OkHttpTalksDataAgentImpl() {
        mHttpClient = new OkHttpClient.Builder() //1.
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    public static OkHttpTalksDataAgentImpl getInstance() {
        if (sObjInstance == null) {
            sObjInstance = new OkHttpTalksDataAgentImpl();
        }
        return sObjInstance;
    }

    @Override
    public void loadTalksList(final int page, final String accessToken) {
        new AsyncTask<Void, Void, String>() {

            @Override
            protected String doInBackground(Void... voids) {
                RequestBody formBody = new FormBody.Builder() //2.
                        .add(TalksConstants.PARAM_ACCESS_TOKEN, accessToken)
                        .add(TalksConstants.PARAM_PAGE, String.valueOf(page))
                        .build();

                Request request = new Request.Builder() //3
                        .url(TalksConstants.API_BASE_URL + TalksConstants.API_GET_TALKS)
                        .post(formBody)
                        .build();

                try {
                    Response response = mHttpClient.newCall(request).execute(); //4.
                    if (response.isSuccessful()) {
                        String responseString = response.body().string();
                        return responseString;
                    }
                } catch (IOException e) {
                    Log.e("Io exception", e.getMessage());
                }

                return null;
            }

            @Override
            protected void onPostExecute(String responseString) {
                super.onPostExecute(responseString);
                Gson gson = new Gson();
                GetTalksResponse talksResponse = gson.fromJson(responseString, GetTalksResponse.class);
                Log.d("onPostExcute", "Talks List Size" + talksResponse.getTedTalks().size());

                if (talksResponse.isResponseOK()){
                    SuccessGetTalksEvent event = new SuccessGetTalksEvent(talksResponse.getTedTalks());
                    EventBus.getDefault().post(event);
                } else {
                    ApiErrorEvent event = new ApiErrorEvent(talksResponse.getMessage());
                    EventBus.getDefault().post(event);
                }
            }
        }.execute();
    }
}
