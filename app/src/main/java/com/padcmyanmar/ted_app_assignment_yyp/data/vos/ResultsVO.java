package com.padcmyanmar.ted_app_assignment_yyp.data.vos;

import com.google.gson.annotations.SerializedName;

public class ResultsVO {

    @SerializedName("search_result_id")
    private String searchResultId;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("imageUrl")
    private String imageUrl;
    @SerializedName("result_type")
    private String resultType;
    @SerializedName("result_id")
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
