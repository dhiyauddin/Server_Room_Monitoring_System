package jbr.springmvc.service;

import java.util.List;

import jbr.springmvc.model.Device_Esp;

public interface Device_EspService {

	void register(Device_Esp device_Esp,String user);
	List<Device_Esp> displayAll();
	List<Device_Esp> findByDeviceId(int deviceId);
}
