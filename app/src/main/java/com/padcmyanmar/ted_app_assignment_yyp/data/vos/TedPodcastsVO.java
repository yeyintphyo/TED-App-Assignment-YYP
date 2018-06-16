package com.padcmyanmar.ted_app_assignment_yyp.data.vos;

import java.util.List;

public class TedPodcastsVO {

    private String podcastId;
    private String title;
    private String imageUrl;
    private String description;
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
