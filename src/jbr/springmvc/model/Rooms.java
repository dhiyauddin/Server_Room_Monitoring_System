package jbr.springmvc.model;

public class Rooms {

	private int runningId;
	private int roomId;
	private String description;
	private int serverId;
	private String createdDate;
	private String createdBy;
	private String updatedDate;
	private String updatedBy;

	public Rooms() {

	}

	public Rooms(int runningId, int roomId,String description, int serverId, String createdDate, String createdBy) {
		this.runningId = runningId;
		this.roomId = roomId;
		this.description = description;
		this.serverId = serverId;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
	}

	public int getRunningId() {
		return runningId;
	}

	public void setRunningId(int runningId) {
		this.runningId = runningId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public int getServerId() {
		return serverId;
	}

	public void setServerId(int serverId) {
		this.serverId = serverId;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

}
