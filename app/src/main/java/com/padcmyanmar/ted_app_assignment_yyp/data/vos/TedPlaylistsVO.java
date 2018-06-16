package com.padcmyanmar.ted_app_assignment_yyp.data.vos;

import java.util.List;

public class TedPlaylistsVO {

    private String playlistId;
    private String title;
    private String imageUrl;
    private String totalTalks;
    private String description;
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
