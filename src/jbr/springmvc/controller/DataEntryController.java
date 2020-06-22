package jbr.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jbr.springmvc.model.Device_Adafruit;
import jbr.springmvc.model.Device_Esp;
import jbr.springmvc.model.Devices;
import jbr.springmvc.model.Rooms;
import jbr.springmvc.model.Servers;
import jbr.springmvc.service.Device_AdafruitService;
import jbr.springmvc.service.Device_EspService;
import jbr.springmvc.service.DevicesService;
import jbr.springmvc.service.Report_Device_AdafruitService;
import jbr.springmvc.service.Report_Device_EspService;
import jbr.springmvc.service.RoomsService;
import jbr.springmvc.service.ServersService;

@Controller
public class DataEntryController {

	@Autowired
	public RoomsService roomsService;
	@Autowired
	public ServersService serversService;
	@Autowired
	public DevicesService devicesService;
	@Autowired
	public Device_AdafruitService device_AdafruitService;
	@Autowired
	public Device_EspService device_EspService;
	@Autowired
	public Report_Device_AdafruitService report_device_AdafruitService;
	@Autowired
	public Report_Device_EspService report_Device_EspService;

	@RequestMapping(value = "/dataEntry", method = RequestMethod.GET)
	public ModelAndView showEntry(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("dataEntry");

		int roomsRecordsTotal = 0;
		int serversRecordsTotal = 0;
		int devicesRecordsTotal = 0;
		int device_AdafruitRecordsTotal = 0;
		int device_EspRecordsTotal = 0;

		roomsRecordsTotal = roomsService.totalRecords();
		serversRecordsTotal = serversService.totalRecords();
		devicesRecordsTotal = devicesService.totalRecords();
		device_AdafruitRecordsTotal = report_device_AdafruitService.totalRecords();
		device_EspRecordsTotal = report_Device_EspService.totalRecords();

		mav.addObject("roomsRecordsTotal", roomsRecordsTotal);
		mav.addObject("serversRecordsTotal", serversRecordsTotal);
		mav.addObject("devicesRecordsTotal", devicesRecordsTotal);
		mav.addObject("device_AdafruitRecordsTotal", device_AdafruitRecordsTotal);
		mav.addObject("device_EspRecordsTotal", device_EspRecordsTotal);

		return mav;
	}

	@RequestMapping(value = "/dataEntry_Rooms", method = RequestMethod.GET)
	public ModelAndView showDataEntry_Rooms(HttpServletRequest request, HttpServletResponse response) {
		List<Rooms> data = roomsService.displayAll();
		ModelAndView mav = new ModelAndView("dataEntry_Rooms");
		mav.addObject("dataEntry_Rooms", new Rooms());
		mav.addObject("roomsData", data);
		return mav;
	}

	@RequestMapping(value = "/registerRoomsProcess", method = RequestMethod.POST)
	public ModelAndView addRooms(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("dataEntry_Rooms") Rooms rooms) {
		String firstName = (String)request.getSession().getAttribute("loginUser");
		roomsService.register(rooms,firstName);
		ModelAndView mav = new ModelAndView("dataEntry_Rooms");
		mav.addObject("dataEntry_Rooms", new Rooms());
		return mav;
	}

	@RequestMapping(value = "/dataEntry_Servers", method = RequestMethod.GET)
	public ModelAndView showDataEntry_Servers(HttpServletRequest request, HttpServletResponse response) {
		List<Servers> data = serversService.displayAll();
		ModelAndView mav = new ModelAndView("dataEntry_Servers");
		mav.addObject("dataEntry_Servers", new Servers());
		mav.addObject("serversData", data);
		return mav;
	}

	@RequestMapping(value = "/registerServersProcess", method = RequestMethod.POST)
	public ModelAndView addServers(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("dataEntry_Servers") Servers servers) {
		String firstName = (String)request.getSession().getAttribute("loginUser");
		serversService.register(servers,firstName);
		ModelAndView mav = new ModelAndView("dataEntry_Servers");
		mav.addObject("dataEntry_Servers", new Servers());
		return mav;
	}

	@RequestMapping(value = "/dataEntry_Devices", method = RequestMethod.GET)
	public ModelAndView showDataEntry_Devices(HttpServletRequest request, HttpServletResponse response) {
		List<Devices> data = devicesService.displayAll();
		ModelAndView mav = new ModelAndView("dataEntry_Devices");
		mav.addObject("dataEntry_Devices", new Devices());
		mav.addObject("devicesData", data);
		return mav;
	}

	@RequestMapping(value = "/registerDevicesProcess", method = RequestMethod.POST)
	public ModelAndView addDevices(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("dataEntry_Devices") Devices devices) {
		String firstName = (String)request.getSession().getAttribute("loginUser");
		devicesService.register(devices,firstName);
		ModelAndView mav = new ModelAndView("dataEntry_Devices");
		mav.addObject("dataEntry_Devices", new Devices());
		return mav;
	}

	@RequestMapping(value = "/device_Adafruit", method = RequestMethod.GET)
	public ModelAndView showDevice_Adafruit(HttpServletRequest request, HttpServletResponse response) {
		List<Device_Adafruit> data = device_AdafruitService.displayAll();
		ModelAndView mav = new ModelAndView("device_Adafruit");
		mav.addObject("device_Adafruit", new Device_Adafruit());
		mav.addObject("device_AdafruitData", data);
		return mav;
	}

	@RequestMapping(value = "/registerDevice_AdafruitProcess", method = RequestMethod.POST)
	public ModelAndView addDevice_Adafruit(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("device_Adafruit") Device_Adafruit device_Adafruit) {
		String firstName = (String)request.getSession().getAttribute("loginUser");
		device_AdafruitService.register(device_Adafruit,firstName);
		ModelAndView mav = new ModelAndView("device_Adafruit");
		mav.addObject("device_Adafruit", new Device_Adafruit());
		return mav;
	}

	@RequestMapping(value = "/device_Esp", method = RequestMethod.GET)
	public ModelAndView showDevice_Esp(HttpServletRequest request, HttpServletResponse response) {
		List<Device_Esp> data = device_EspService.displayAll();
		ModelAndView mav = new ModelAndView("device_Esp");
		mav.addObject("device_Esp", new Device_Esp());
		mav.addObject("device_EspData", data);
		return mav;
	}

	@RequestMapping(value = "/registerDevice_EspProcess", method = RequestMethod.POST)
	public ModelAndView addDevice_Esp(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("device_Esp") Device_Esp device_Esp) {
		String firstName = (String)request.getSession().getAttribute("loginUser");
		device_EspService.register(device_Esp,firstName);
		ModelAndView mav = new ModelAndView("device_Esp");
		mav.addObject("device_Esp", new Device_Esp());
		return mav;
	}
}
