package jbr.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jbr.springmvc.model.Report_Device_Adafruit;
import jbr.springmvc.model.Rooms;
import jbr.springmvc.model.Servers;
import jbr.springmvc.service.Report_Device_AdafruitService;
import jbr.springmvc.service.ServersService;

@Controller
public class ServersController {
	@Autowired
	public ServersService serversService;
	@Autowired
	public Report_Device_AdafruitService report_Device_AdafruitService;
	
	@RequestMapping(value = "/servers", method = RequestMethod.GET)
	public ModelAndView showRegisterServers(HttpServletRequest request, HttpServletResponse response) {
		List<Servers> data = serversService.displayAll();
		ModelAndView mav = new ModelAndView("servers");
		mav.addObject("servers", new Servers());
		mav.addObject("serversData",data);
		return mav;
	}
	
	@RequestMapping(value = "/serversFind", method = RequestMethod.GET)
	public ModelAndView showServersById(HttpServletRequest request, HttpServletResponse response,@RequestParam (value = "serverId", required = false) int serverId) {
		List<Servers> data = serversService.findByServerId(serverId);
		ModelAndView mav = new ModelAndView("servers");
		mav.addObject("servers", new Servers());
		mav.addObject("serversData", data);
		return mav;
	}
	
	@RequestMapping(value = "/devicesStatus", method = RequestMethod.GET)
	public ModelAndView showDevicesByServerId(HttpServletRequest request, HttpServletResponse response,@RequestParam (value = "serverId", required = false) int serverId) {
		List<Servers> dataServer = serversService.findByServerId(serverId);
		List<Report_Device_Adafruit> dataEntry = report_Device_AdafruitService.findByServerId(serverId);
		ModelAndView mav = new ModelAndView("servers");
		mav.addObject("servers", new Report_Device_Adafruit());
		mav.addObject("serversData", dataServer);
		mav.addObject("devicesStatusData", dataEntry);
		return mav;
	}
	
}
