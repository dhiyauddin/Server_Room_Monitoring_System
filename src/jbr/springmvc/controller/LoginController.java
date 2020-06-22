package jbr.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;
import jbr.springmvc.service.DevicesService;
import jbr.springmvc.service.RoomsService;
import jbr.springmvc.service.ServersService;
import jbr.springmvc.service.UserService;

@Controller
public class LoginController {
	@Autowired
	UserService userService;
	@Autowired
	public RoomsService roomsService;
	@Autowired
	public ServersService serversService;
	@Autowired
	public DevicesService devicesService;
	

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Login());
		return mav;
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("login") Login login) {
		int roomsTotal = 0; int serversTotal = 0 ; int devicesTotal = 0;
		ModelAndView mav = null;
		User user = userService.validateUser(login);
		if (null != user) {
			
			roomsTotal = roomsService.totalRecords();
			serversTotal = serversService.totalRecords();
			devicesTotal = devicesService.totalRecords();
			
			mav = new ModelAndView("dashboard");
			request.getSession().setAttribute("loginUser", user.getFirstname());
			mav.addObject("firstname", user.getFirstname());
			mav.addObject("roomsTotal", roomsTotal);
			mav.addObject("serversTotal", serversTotal);
			mav.addObject("devicesTotal", devicesTotal);
		} else {
			mav = new ModelAndView("login");
			mav.addObject("message", "Username or Password is wrong!!");
		}
		return mav;
	}
	
	
}
