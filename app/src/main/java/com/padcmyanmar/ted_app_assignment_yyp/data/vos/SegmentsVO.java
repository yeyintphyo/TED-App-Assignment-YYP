package com.padcmyanmar.ted_app_assignment_yyp.data.vos;

import com.google.gson.annotations.SerializedName;

public class SegmentsVO {

    @SerializedName("speaker_id")
    private String segmentId;
    @SerializedName("speaker_id")
    private String title;
    @SerializedName("speaker_id")
    private String imageUrl;

    public String getSegmentId() {
        return segmentId;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
