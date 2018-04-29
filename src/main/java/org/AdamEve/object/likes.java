package org.AdamEve.object;

import java.time.LocalDateTime;

public class likes{
	
	private String liker;
	private String likee;
	private LocalDateTime timeLike;
	
	public String getLiker() {
		return liker;
	}
	public void setLiker(String liker) {
		this.liker = liker;
	}
	public String getLikee() {
		return likee;
	}
	public void setLikee(String likee) {
		this.likee = likee;
	}
	public LocalDateTime getTimeLike() {
		return timeLike;
	}
	public void setTimeLike(LocalDateTime timeLike) {
		this.timeLike = timeLike;
	}
	
}