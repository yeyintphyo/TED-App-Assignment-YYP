package com.padcmyanmar.ted_app_assignment_yyp.network.response;

import com.google.gson.annotations.SerializedName;
import com.padcmyanmar.ted_app_assignment_yyp.data.vos.TedTalksVO;

import java.util.List;

public class GetTalksResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("page")
    private String page;

    @SerializedName("ted_talks")
    private List<TedTalksVO> tedTalks;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<TedTalksVO> getTedTalks() {
        return tedTalks;
    }

    public boolean isResponseOK() {
        return (code == 200 && tedTalks != null);
    }
}
