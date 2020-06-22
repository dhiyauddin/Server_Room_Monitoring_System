package jbr.springmvc.service;

import java.util.List;

import jbr.springmvc.model.Report_Device_Adafruit;

public interface Report_Device_AdafruitService {

	List<Report_Device_Adafruit> displayAll();

	List<Report_Device_Adafruit> findByServerId(int serverId);

	int totalRecords();
	
	List<Report_Device_Adafruit> displayTimeSeries();
}
