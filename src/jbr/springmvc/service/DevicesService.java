package jbr.springmvc.service;

import java.util.List;

import jbr.springmvc.model.Devices;

public interface DevicesService {

	void register(Devices devices,String user);

	List<Devices> displayAll();

	List<Devices> findByDeviceId(int deviceId);
	
	int totalRecords();
}
