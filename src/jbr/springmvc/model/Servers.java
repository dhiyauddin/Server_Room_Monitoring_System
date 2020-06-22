package jbr.springmvc.model;

public class Servers {

	private int runningId;
	private int serverId;
	private String description;
	private int deviceId;
	private String createdDate;
	private String createdBy;
	private String updatedDate;
	private String updatedBy;

	public Servers() {

	}

	public Servers(int runningId, int serverId, String description, int deviceId, String createdDate, String createdBy) {
		this.runningId = runningId;
		this.serverId = serverId;
		this.description = description;
		this.deviceId = deviceId;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
	}

	public int getRunningId() {
		return runningId;
	}

	public void setRunningId(int runningId) {
		this.runningId = runningId;
	}

	public int getServerId() {
		return serverId;
	}

	public void setServerId(int serverId) {
		this.serverId = serverId;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
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
