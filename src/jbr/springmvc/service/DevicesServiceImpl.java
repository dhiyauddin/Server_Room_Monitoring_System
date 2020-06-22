package jbr.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jbr.springmvc.dao.DevicesDaoImpl;
import jbr.springmvc.model.Devices;

public class DevicesServiceImpl implements DevicesService {

	@Autowired
	public DevicesDaoImpl devicesDaoImpl;
	
	@Override
	public void register(Devices devices,String user) {
		devicesDaoImpl.register(devices,user);

	}

	@Override
	public List<Devices> displayAll() {
		List<Devices> devices;
		devices = devicesDaoImpl.displayAll();
		return devices;
	}

	@Override
	public List<Devices> findByDeviceId(int deviceId) {
		List<Devices> devices;
		devices = devicesDaoImpl.findByDeviceId(deviceId);
		return devices;
	}

	@Override
	public int totalRecords() {
		int count = 0;
		count = devicesDaoImpl.totalRecords();
		return count;
	}
}
