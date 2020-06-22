package jbr.springmvc.service;

import java.util.List;

import jbr.springmvc.model.Device_Adafruit;

public interface Device_AdafruitService {

	void register(Device_Adafruit device_Adafruit,String user);
	List<Device_Adafruit> displayAll();
	List<Device_Adafruit> findByDeviceId(int deviceId);
}
