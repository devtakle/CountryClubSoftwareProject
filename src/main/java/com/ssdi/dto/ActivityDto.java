package com.ssdi.dto;

public class ActivityDto {
    private Integer activityId;
    private String ActivityName;

    public ActivityDto(Integer activityId, String activityName) {
        this.activityId = activityId;
        ActivityName = activityName;
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
        return ActivityName;
    }

    public void setActivityName(String activityName) {
        ActivityName = activityName;
    }
}
