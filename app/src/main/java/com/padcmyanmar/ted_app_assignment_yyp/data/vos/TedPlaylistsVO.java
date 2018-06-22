package com.padcmyanmar.ted_app_assignment_yyp.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TedPlaylistsVO {

    @SerializedName("speaker_id")
    private String playlistId;
    @SerializedName("speaker_id")
    private String title;
    @SerializedName("speaker_id")
    private String imageUrl;
    @SerializedName("speaker_id")
    private String totalTalks;
    @SerializedName("speaker_id")
    private String description;
    @SerializedName("speaker_id")
    private List<TedTalksVO> talksInPlaylist;

    public String getPlaylistId() {
        return playlistId;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTotalTalks() {
        return totalTalks;
    }

    public String getDescription() {
        return description;
    }

    public List<TedTalksVO> getTalksInPlaylist() {
        return talksInPlaylist;
    }
}
