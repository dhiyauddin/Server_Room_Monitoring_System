package jbr.springmvc.model;

public class Report_Device_Adafruit {
	
	private int roomId;
	private String roomDesc;
	private int serverId;
	private String serverDesc;
	private int deviceId;
	private int deviceType;
	private float temperature;
	private float humidity;
	private int battery;
	private String createdDate;
	private String createdBy;
	private String updatedDate;
	private String updatedBy;
	
	private int total;
	private String month;
	private String dayName;
	

	public Report_Device_Adafruit() {
	}

	public Report_Device_Adafruit(int roomId, String roomDesc, int serverId, String serverDesc, int deviceId, int deviceType, float temperature, float humidity,
			int battery, String createdDate, String createdBy, String updatedDate, String updatedBy) {
		this.roomId = roomId;
		this.roomDesc = roomDesc;
		this.serverId = serverId;
		this.serverDesc = serverDesc;
		this.deviceId = deviceId;
		this.deviceType = deviceType;
		this.temperature = temperature;
		this.humidity = humidity;
		this.battery = battery;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}

	public Report_Device_Adafruit(int total,String month,String dayName) {
		this.total = total;
		this.month = month;
		this.dayName = dayName;
	}
	
	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	
	public String getRoomDesc() {
		return roomDesc;
	}
	
	public void setRoomDesc(String roomDesc) {
		this.roomDesc = roomDesc;
	}

	public int getServerId() {
		return serverId;
	}

	public void setServerId(int serverId) {
		this.serverId = serverId;
	}
	
	public String getServerDesc() {
		return serverDesc;
	}

	public void setServerDesc(String serverDesc) {
		this.serverDesc = serverDesc;
	}
	
	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public int getDeviceType() {
		return deviceType;
	}
	
	public void setDeviceType(int deviceType) {
		this.deviceType = deviceType;
	}
	
	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
	
	public String getDayName() {
		return dayName;
	}

	public void setDayName(String dayName) {
		this.dayName = dayName;
	}
	
	
	
}
