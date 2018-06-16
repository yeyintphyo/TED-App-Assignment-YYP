package com.padcmyanmar.ted_app_assignment_yyp.data.vos;

import java.util.List;

public class TedTalksVO {

    private String talkId;
    private String title;
    private SpeakerVO speaker;
    private String imageUrl;
    private String durationInSec;
    private String description;
    private List<TagVO> tags;

    public String getTalkId() {
        return talkId;
    }

    public String getTitle() {
        return title;
    }

    public SpeakerVO getSpeaker() {
        return speaker;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDurationInSec() {
        return durationInSec;
    }

    public String getDescription() {
        return description;
    }

    public List<TagVO> getTags() {
        return tags;
    }
}
