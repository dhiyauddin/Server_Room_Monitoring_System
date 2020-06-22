package jbr.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jbr.springmvc.model.User;
import jbr.springmvc.service.DevicesService;
import jbr.springmvc.service.RoomsService;
import jbr.springmvc.service.ServersService;
import jbr.springmvc.service.UserService;

@Controller
public class DashboardController {
	@Autowired
	public UserService userService;
	@Autowired
	public RoomsService roomsService;
	@Autowired
	public ServersService serversService;
	@Autowired
	public DevicesService devicesService;

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		int roomsTotal = 0; int serversTotal = 0 ; int devicesTotal = 0;
		roomsTotal = roomsService.totalItems();
		serversTotal = serversService.totalRecords();
		devicesTotal = devicesService.totalRecords();
		 
		ModelAndView mav = new ModelAndView("dashboard");
		mav.addObject("roomsTotal", roomsTotal);
		mav.addObject("serversTotal", serversTotal);
		mav.addObject("devicesTotal", devicesTotal);
		return mav;
	}
}
