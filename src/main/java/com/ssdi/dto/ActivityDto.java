package com.ssdi.dto;

public class ActivityDto {
    private Integer activityId;
    private String activityName;
<<<<<<< HEAD

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
=======
    private String category_Name;
    
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
	public String getCategory_Name() {
		return category_Name;
	}
	public void setCategory_Name(String category_Name) {
		this.category_Name = category_Name;
	}
	public ActivityDto(int activityId, String activityName, String category_Name  ) {
		super();
		this.activityId = activityId;
		this.activityName = activityName;
		this.category_Name = category_Name;
	}
	
>>>>>>> branch 'master' of git@github.com:devtakle/CountryClubSoftwareProject.git
}
