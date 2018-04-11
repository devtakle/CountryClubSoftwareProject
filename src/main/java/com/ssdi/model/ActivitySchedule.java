package com.ssdi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ActivitySchedule {
	 @Column
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Id
		private int id;
	    @Column 
	    private String start_at;
	    @Column 
	    private String end_at;
	    @OneToOne
	    @JoinColumn(name="activity_id",referencedColumnName="id")
	    private Activity activity;
	    @OneToOne
	    @JoinColumn(name="venue_id", referencedColumnName="id")
	    private Venue venue;
	    @OneToOne
	    @JoinColumn(name="day_of_week", referencedColumnName="id")
	    private DayOfWeek dayOfWeek;
		
	    public DayOfWeek getDayOfWeek() {
			return dayOfWeek;
		}
		public void setDayOfWeek(DayOfWeek dayOfWeek) {
			this.dayOfWeek = dayOfWeek;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
<<<<<<< HEAD
	
=======
>>>>>>> branch 'master' of git@github.com:devtakle/CountryClubSoftwareProject.git
		
		public String getStart_at() {
			return start_at;
		}
		public void setStart_at(String start_at) {
			this.start_at = start_at;
		}
		public String getEnd_at() {
			return end_at;
		}
		public void setEnd_at(String end_at) {
			this.end_at = end_at;
		}
		public Activity getActivity() {
			return activity;
		}
		public void setActivity(Activity activity) {
			this.activity = activity;
		}
		public Venue getVenue() {
			return venue;
		}
		public void setVenue(Venue venue) {
			this.venue = venue;
		}
		

}
