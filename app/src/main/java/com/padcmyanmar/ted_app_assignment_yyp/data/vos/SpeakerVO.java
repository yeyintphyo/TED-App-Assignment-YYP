package com.padcmyanmar.ted_app_assignment_yyp.data.vos;

import com.google.gson.annotations.SerializedName;

public class SpeakerVO {

    @SerializedName("speaker_id")
    private String speakerId;
    @SerializedName("name")
    private String name;

    public String getSpeakerId() {
        return speakerId;
    }

    public String getName() {
        return name;
    }
}
