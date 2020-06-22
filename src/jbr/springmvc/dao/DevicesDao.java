package jbr.springmvc.dao;

import java.util.List;

import jbr.springmvc.model.Devices;

public interface DevicesDao {
	void register(Devices devices,String user);

	List<Devices> displayAll();

	List<Devices> findByDeviceId(int deviceId);
	
	int totalRecords();
}
