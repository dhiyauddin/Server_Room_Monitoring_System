package jbr.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jbr.springmvc.dao.Device_AdafruitDaoImpl;
import jbr.springmvc.model.Device_Adafruit;

public class Device_AdafruitServiceImpl implements Device_AdafruitService {

	@Autowired
	public Device_AdafruitDaoImpl device_AdafruitDaoImpl;

	@Override
	public void register(Device_Adafruit device_Adafruit, String user) {
		device_AdafruitDaoImpl.register(device_Adafruit, user);
	}

	@Override
	public List<Device_Adafruit> displayAll() {
		List<Device_Adafruit> device_Adafruit;
		device_Adafruit = device_AdafruitDaoImpl.displayAll();
		return device_Adafruit;
	}

	@Override
	public List<Device_Adafruit> findByDeviceId(int deviceId) {
		List<Device_Adafruit> device_Adafruit;
		device_Adafruit = device_AdafruitDaoImpl.findByDeviceId(deviceId);
		return device_Adafruit;
	}

}
