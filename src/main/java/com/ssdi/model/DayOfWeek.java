package com.ssdi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DayOfWeek {
	    @Column
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Id
		private int id;
	    @Column
	    private String day_of_week;
	    
<<<<<<< HEAD
	    
=======
>>>>>>> branch 'master' of git@github.com:devtakle/CountryClubSoftwareProject.git
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getDay_of_week() {
			return day_of_week;
		}
		public void setDay_of_week(String day_of_week) {
			this.day_of_week = day_of_week;
		}


}
