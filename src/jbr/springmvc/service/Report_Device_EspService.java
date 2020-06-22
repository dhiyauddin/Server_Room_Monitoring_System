package jbr.springmvc.service;

import java.util.List;

import jbr.springmvc.model.Report_Device_Esp;

public interface Report_Device_EspService {

	List<Report_Device_Esp> displayAll();

	int totalRecords();
	
	List<Report_Device_Esp> displayTimeSeries();
}
