package com.ssdi.model;

import javax.persistence.*;

@Entity
public class Activity {
    @Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
    @Column
    private String activity_name;
<<<<<<< HEAD

	public Activity(int id, String activity_name) {
		super();
		this.id = id;
		this.activity_name = activity_name;
	}
	public Activity() {
		super();
	}

	public int getActivityId() {
        return id;
    }

    public void setActivityId(int activityId) {
        this.id = activityId;
    }

    public String getActivityName() {
        return activity_name;
    }

    public void setActivityName(String activityName) {
        this.activity_name = activityName;
    }
=======
    @OneToOne
    @JoinColumn(name="category_id", referencedColumnName="id")
    private Category categoryNname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getActivity_name() {
		return activity_name;
	}
	public void setActivity_name(String activity_name) {
		this.activity_name = activity_name;
	}
	public Category getCategoryNname() {
		return categoryNname;
	}
	public void setCategoryNname(Category categoryNname) {
		this.categoryNname = categoryNname;
	}
    
	

	

>>>>>>> branch 'master' of git@github.com:devtakle/CountryClubSoftwareProject.git

}
