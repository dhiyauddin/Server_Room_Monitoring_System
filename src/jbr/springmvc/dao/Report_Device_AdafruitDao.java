package jbr.springmvc.dao;

import java.util.List;

import jbr.springmvc.model.Devices;
import jbr.springmvc.model.Report_Device_Adafruit;

public interface Report_Device_AdafruitDao {
	
	List<Report_Device_Adafruit> displayAll();
	
	List<Report_Device_Adafruit> findByServerId(int serverId);
	
	int totalRecords();
	
	List<Report_Device_Adafruit> displayTimeSeries();
}
