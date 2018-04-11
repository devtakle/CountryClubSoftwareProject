package com.ssdi.dto;

public class ActivityDto {
    private Integer activityId;
    private String activityName;

    public ActivityDto(Integer activityId, String activityName) {
        this.activityId = activityId;
        this.activityName = activityName;
    }

    public ActivityDto() {
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
}
