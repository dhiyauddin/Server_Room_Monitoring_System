package jbr.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jbr.springmvc.model.Report_Device_Adafruit;
import jbr.springmvc.model.Report_Device_Esp;
import jbr.springmvc.service.Report_Device_AdafruitService;
import jbr.springmvc.service.Report_Device_EspService;

@Controller
public class ReportController {
	@Autowired
	public Report_Device_AdafruitService report_Device_AdafruitService;
	@Autowired
	public Report_Device_EspService report_Device_EspService;

	
	@RequestMapping(value = "/reports", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		int report_Device_AdafruitTotal = 0; int report_Device_EspTotal = 0; 
		ModelAndView mav = new ModelAndView("reports");
		List<Report_Device_Adafruit> data_Adafruit = report_Device_AdafruitService.displayAll();
		List<Report_Device_Esp> data_Esp = report_Device_EspService.displayAll();
		report_Device_AdafruitTotal = report_Device_AdafruitService.totalRecords();
		report_Device_EspTotal = report_Device_EspService.totalRecords();
		List<Report_Device_Adafruit> data_Adafruit_TimeSeries = report_Device_AdafruitService.displayTimeSeries(); 
		List<Report_Device_Esp> data_Esp_TimeSeries = report_Device_EspService.displayTimeSeries();
		
		
		mav.addObject("report_Device_AdafruitData", data_Adafruit);
		mav.addObject("report_Device_AdafruitTotal", report_Device_AdafruitTotal);
		mav.addObject("report_Device_AdafruitData_TimeSeries", data_Adafruit_TimeSeries);
		mav.addObject("report_Device_EspData", data_Esp);
		mav.addObject("report_Device_EspTotal", report_Device_EspTotal);
		mav.addObject("report_Device_EspData_TimeSeries", data_Esp_TimeSeries);
		
		return mav;
	}
	
	
}
