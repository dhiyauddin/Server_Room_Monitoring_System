package jbr.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jbr.springmvc.dao.Device_EspDaoImpl;
import jbr.springmvc.model.Device_Esp;

public class Device_EspServiceImpl implements Device_EspService {

	@Autowired
	public Device_EspDaoImpl device_EspDaoImpl;
	
	@Override
	public void register(Device_Esp device_Esp,String user) {
		device_EspDaoImpl.register(device_Esp,user);

	}

	@Override
	public List<Device_Esp> displayAll() {
		List<Device_Esp> device_Esp;
		device_Esp = device_EspDaoImpl.displayAll();
		return device_Esp;
	}

	@Override
	public List<Device_Esp> findByDeviceId(int deviceId) {
		List<Device_Esp> device_Esp;
		device_Esp = device_EspDaoImpl.findByDeviceId(deviceId);
		return device_Esp;
	}

}
