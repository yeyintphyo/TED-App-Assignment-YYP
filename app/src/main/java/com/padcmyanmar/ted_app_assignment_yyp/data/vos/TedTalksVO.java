package com.padcmyanmar.ted_app_assignment_yyp.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TedTalksVO {

    @SerializedName("talk_id")
    private String talkId;
    @SerializedName("title")
    private String title;
    @SerializedName("speaker")
    private SpeakerVO speaker;
    @SerializedName("imageUrl")
    private String imageUrl;
    @SerializedName("durationInSec")
    private String durationInSec;
    @SerializedName("description")
    private String description;
    @SerializedName("tag")
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
