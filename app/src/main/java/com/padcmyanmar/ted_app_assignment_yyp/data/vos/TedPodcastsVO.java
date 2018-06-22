package com.padcmyanmar.ted_app_assignment_yyp.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TedPodcastsVO {

    @SerializedName("speaker_id")
    private String podcastId;
    @SerializedName("speaker_id")
    private String title;
    @SerializedName("speaker_id")
    private String imageUrl;
    @SerializedName("speaker_id")
    private String description;
    @SerializedName("speaker_id")
    private List<SegmentsVO> segments;

    public String getPodcastId() {
        return podcastId;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public List<SegmentsVO> getSegments() {
        return segments;
    }
}
