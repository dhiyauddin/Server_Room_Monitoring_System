package jbr.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jbr.springmvc.dao.Report_Device_AdafruitDaoImpl;
import jbr.springmvc.model.Report_Device_Adafruit;

public class Report_Device_AdafruitServiceImpl implements Report_Device_AdafruitService {

	@Autowired
	Report_Device_AdafruitDaoImpl report_Device_AdafruitDaoImpl;
	
	@Override
	public List<Report_Device_Adafruit> displayAll() {
		List<Report_Device_Adafruit> report_Device_Adafruit;
		report_Device_Adafruit = report_Device_AdafruitDaoImpl.displayAll();
		return report_Device_Adafruit;
	}

	@Override
	public List<Report_Device_Adafruit> findByServerId(int serverId) {
		List<Report_Device_Adafruit> report_Device_Adafruit;
		report_Device_Adafruit = report_Device_AdafruitDaoImpl.findByServerId(serverId);
		return report_Device_Adafruit;
	}

	@Override
	public int totalRecords() {
		int count = 0;
		count = report_Device_AdafruitDaoImpl.totalRecords();
		return count;
	}

	@Override
	public List<Report_Device_Adafruit> displayTimeSeries() {
		List<Report_Device_Adafruit> report_Device_Adafruit;
		report_Device_Adafruit = report_Device_AdafruitDaoImpl.displayTimeSeries();
		return report_Device_Adafruit;
	}

}
