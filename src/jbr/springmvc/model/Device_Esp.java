package jbr.springmvc.model;

public class Device_Esp {

	private int runningId;
	private int deviceId;
	private boolean waterPresence;
	private String createdDate;
	private String createdBy;
	private String updatedDate;
	private String updatedBy;

	public Device_Esp() {

	}

	public Device_Esp(int runningId, int deviceId, boolean waterPresence, String createdDate, String createdBy) {
		this.runningId = runningId;
		this.deviceId = deviceId;
		this.waterPresence = waterPresence;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
	}

	public int getRunningId() {
		return runningId;
	}

	public void setRunningId(int runningId) {
		this.runningId = runningId;
	}

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public boolean isWaterPresence() {
		return waterPresence;
	}

	public void setWaterPresence(boolean waterPresence) {
		this.waterPresence = waterPresence;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + deviceId;
		result = prime * result + runningId;
		result = prime * result + ((updatedBy == null) ? 0 : updatedBy.hashCode());
		result = prime * result + ((updatedDate == null) ? 0 : updatedDate.hashCode());
		result = prime * result + (waterPresence ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Device_Esp other = (Device_Esp) obj;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (deviceId != other.deviceId)
			return false;
		if (runningId != other.runningId)
			return false;
		if (updatedBy == null) {
			if (other.updatedBy != null)
				return false;
		} else if (!updatedBy.equals(other.updatedBy))
			return false;
		if (updatedDate == null) {
			if (other.updatedDate != null)
				return false;
		} else if (!updatedDate.equals(other.updatedDate))
			return false;
		if (waterPresence != other.waterPresence)
			return false;
		return true;
	}

}
