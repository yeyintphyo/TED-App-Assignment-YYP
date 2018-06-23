package com.padcmyanmar.ted_app_assignment_yyp.network;

import com.padcmyanmar.ted_app_assignment_yyp.events.ApiErrorEvent;
import com.padcmyanmar.ted_app_assignment_yyp.events.SuccessGetTalksEvent;
import com.padcmyanmar.ted_app_assignment_yyp.network.response.GetTalksResponse;
import com.padcmyanmar.ted_app_assignment_yyp.utils.TalksConstants;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitTalksDataAgentImpl implements TalksDataAgent {

    private static RetrofitTalksDataAgentImpl sObjInstance;

    private TalksApi mTheApi;

    private RetrofitTalksDataAgentImpl() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(TalksConstants.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        mTheApi = retrofit.create(TalksApi.class);
    }

    public static RetrofitTalksDataAgentImpl getInstance() {
        if (sObjInstance == null) {
            sObjInstance = new RetrofitTalksDataAgentImpl();
        }
        return sObjInstance;
    }

    @Override
    public void loadTalksList(int page, String accessToken) {
        Call<GetTalksResponse> loadNewsCall =  mTheApi.loadNewsList(accessToken, page);
        loadNewsCall.enqueue(new Callback<GetTalksResponse>() {
            @Override
            public void onResponse(Call<GetTalksResponse> call, Response<GetTalksResponse> response) {
                GetTalksResponse newsResponse = response.body();
                if (newsResponse != null && newsResponse.isResponseOK()) {
                    SuccessGetTalksEvent event = new SuccessGetTalksEvent(newsResponse.getTedTalks());
                    EventBus.getDefault().post(event);
                } else {
                    if (newsResponse == null) {
                        ApiErrorEvent event = new ApiErrorEvent("Empty response in network call.");
                        EventBus.getDefault().post(event);
                    } else {
                        ApiErrorEvent event = new ApiErrorEvent(newsResponse.getMessage());
                        EventBus.getDefault().post(event);
                    }
                }
            }

            @Override
            public void onFailure(Call<GetTalksResponse> call, Throwable t) {
                ApiErrorEvent event = new ApiErrorEvent(t.getMessage());
                EventBus.getDefault().post(event);
            }
        });
    }
}
