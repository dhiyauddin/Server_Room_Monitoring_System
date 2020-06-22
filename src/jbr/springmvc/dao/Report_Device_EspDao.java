package jbr.springmvc.dao;

import java.util.List;

import jbr.springmvc.model.Report_Device_Esp;

public interface Report_Device_EspDao {

	List<Report_Device_Esp> displayAll();
	
	int totalRecords();
	
	List<Report_Device_Esp> displayTimeSeries();
}
