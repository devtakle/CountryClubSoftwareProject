package com.ssdi.dto;

import java.util.ArrayList;
import java.util.List;

public class VenueDto {
    private Integer venueId;
    private String venueName;
    private List<ActivityDto> activityDtos= new ArrayList<>();

    public VenueDto(Integer venueId, String venueName, List<ActivityDto> activityDtos) {
        this.venueId = venueId;
        this.venueName = venueName;
        this.activityDtos = activityDtos;
    }

    public VenueDto() {
    }

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public List<ActivityDto> getActivityDtos() {
        return activityDtos;
    }

    public void setActivityDtos(List<ActivityDto> activityDtos) {
        this.activityDtos = activityDtos;
    }
}
