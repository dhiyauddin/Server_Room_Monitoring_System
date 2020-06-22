package jbr.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jbr.springmvc.dao.Report_Device_EspDaoImpl;
import jbr.springmvc.model.Report_Device_Esp;

public class Report_Device_EspServiceImpl implements Report_Device_EspService {

	@Autowired
	Report_Device_EspDaoImpl report_Device_EspDaoImpl;

	@Override
	public List<Report_Device_Esp> displayAll() {
		List<Report_Device_Esp> report_Device_Esp;
		report_Device_Esp = report_Device_EspDaoImpl.displayAll();
		return report_Device_Esp;
	}

	@Override
	public int totalRecords() {
		int count = 0;
		count = report_Device_EspDaoImpl.totalRecords();
		return count;
	}

	@Override
	public List<Report_Device_Esp> displayTimeSeries() {
		List<Report_Device_Esp> report_Device_Esp;
		report_Device_Esp = report_Device_EspDaoImpl.displayTimeSeries();
		return report_Device_Esp;
	}

}
