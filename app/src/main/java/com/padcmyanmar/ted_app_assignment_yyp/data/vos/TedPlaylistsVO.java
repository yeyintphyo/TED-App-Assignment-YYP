package com.padcmyanmar.ted_app_assignment_yyp.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TedPlaylistsVO {

    @SerializedName("playlist_id")
    private String playlistId;
    @SerializedName("title")
    private String title;
    @SerializedName("imageUrl")
    private String imageUrl;
    @SerializedName("totalTalks")
    private String totalTalks;
    @SerializedName("description")
    private String description;
    @SerializedName("talksInPlaylist")
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
