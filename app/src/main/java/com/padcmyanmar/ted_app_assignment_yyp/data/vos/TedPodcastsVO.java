package com.padcmyanmar.ted_app_assignment_yyp.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TedPodcastsVO {

    @SerializedName("podcast_id")
    private String podcastId;
    @SerializedName("title")
    private String title;
    @SerializedName("imageUrl")
    private String imageUrl;
    @SerializedName("description")
    private String description;
    @SerializedName("segments")
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
