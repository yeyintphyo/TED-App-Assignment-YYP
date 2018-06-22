package com.padcmyanmar.ted_app_assignment_yyp.data.vos;

import com.google.gson.annotations.SerializedName;

public class ResultsVO {

    @SerializedName("speaker_id")
    private String searchResultId;
    @SerializedName("speaker_id")
    private String title;
    @SerializedName("speaker_id")
    private String description;
    @SerializedName("speaker_id")
    private String imageUrl;
    @SerializedName("speaker_id")
    private String resultType;
    @SerializedName("speaker_id")
    private String resultId;

    public String getSearchResultId() {
        return searchResultId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getResultType() {
        return resultType;
    }

    public String getResultId() {
        return resultId;
    }
}
