package jbr.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jbr.springmvc.model.Device_Adafruit;
import jbr.springmvc.model.Device_Esp;
import jbr.springmvc.model.Devices;
import jbr.springmvc.model.Report_Device_Adafruit;
import jbr.springmvc.model.Report_Device_Esp;
import jbr.springmvc.model.Rooms;
import jbr.springmvc.model.User;
import jbr.springmvc.service.Device_AdafruitService;
import jbr.springmvc.service.Device_EspService;
import jbr.springmvc.service.DevicesService;
import jbr.springmvc.service.UserService;

@Controller
public class DevicesController {
	@Autowired
	public DevicesService devicesService;
	@Autowired
	public Device_AdafruitService device_AdafruitService;
	@Autowired
	public Device_EspService device_EspService;
	
	@RequestMapping(value = "/devices", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		List<Devices> data = devicesService.displayAll();
		ModelAndView mav = new ModelAndView("devices");
		mav.addObject("devices", new Devices());
		mav.addObject("devicesData",data);
		return mav;
	}
	
	@RequestMapping(value = "/devicesFind", method = RequestMethod.GET)
	public ModelAndView showDevicesById(HttpServletRequest request, HttpServletResponse response,@RequestParam (value = "deviceId", required = false) int deviceId) {
		List<Devices> data = devicesService.findByDeviceId(deviceId);
		ModelAndView mav = new ModelAndView("devices");
		mav.addObject("devices", new Devices());
		mav.addObject("devicesData", data);
		return mav;
	}

	@RequestMapping(value = "/devicesAdafruitStatus", method = RequestMethod.GET)
	public ModelAndView showDevicesAdafruitByDeviceId(HttpServletRequest request, HttpServletResponse response,@RequestParam (value = "deviceId", required = false) int deviceId) {
		int totalRecords = 0; 
		List<Devices> dataDevice = devicesService.findByDeviceId(deviceId);
		List<Device_Adafruit> dataEntry = device_AdafruitService.findByDeviceId(deviceId);
		totalRecords = dataEntry.size();  
		ModelAndView mav = new ModelAndView("devices");
		mav.addObject("devices", new Device_Adafruit());
		mav.addObject("devicesData", dataDevice);
		mav.addObject("devicesAdafruitStatusData", dataEntry);
		mav.addObject("totalRecords",totalRecords);
		return mav;
	}
	
	@RequestMapping(value = "/devicesEspStatus", method = RequestMethod.GET)
	public ModelAndView showDevicesEspByDeviceId(HttpServletRequest request, HttpServletResponse response,@RequestParam (value = "deviceId", required = false) int deviceId) {
		List<Devices> dataDevice = devicesService.findByDeviceId(deviceId);
		List<Device_Esp> dataEntry = device_EspService.findByDeviceId(deviceId);
		ModelAndView mav = new ModelAndView("devices");
		mav.addObject("devices", new Device_Esp());
		mav.addObject("devicesData", dataDevice);
		mav.addObject("devicesEspStatusData", dataEntry);
		return mav;
	}
}
