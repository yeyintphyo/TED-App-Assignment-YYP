package com.padcmyanmar.ted_app_assignment_yyp.network;

import com.padcmyanmar.ted_app_assignment_yyp.network.response.GetTalksResponse;
import com.padcmyanmar.ted_app_assignment_yyp.utils.TalksConstants;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface TalksApi {

    @FormUrlEncoded
    @POST(TalksConstants.API_GET_TALKS)
    Call<GetTalksResponse> loadNewsList(
            @Field(TalksConstants.PARAM_ACCESS_TOKEN) String accessToken,
            @Field(TalksConstants.PARAM_PAGE) int page);
}
