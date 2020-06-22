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

import jbr.springmvc.model.Login;
import jbr.springmvc.model.Rooms;
import jbr.springmvc.model.User;
import jbr.springmvc.service.RoomsService;
import jbr.springmvc.service.UserService;

@Controller
public class RoomsController {
	@Autowired
	public RoomsService roomsService;

	@RequestMapping(value = "/rooms", method = RequestMethod.GET)
	public ModelAndView showRegisterRooms(HttpServletRequest request, HttpServletResponse response) {
		List<Rooms> data = roomsService.displayAll();
		ModelAndView mav = new ModelAndView("rooms");
		mav.addObject("rooms", new Rooms());
		mav.addObject("roomsData", data);
		return mav;
	}

	@RequestMapping(value = "/roomsFind", method = RequestMethod.GET)
	public ModelAndView showRoomsById(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "roomId", required = false) int roomId) {
		List<Rooms> data = roomsService.findByRoomsId(roomId);
		ModelAndView mav = new ModelAndView("rooms");
		mav.addObject("rooms", new Rooms());
		mav.addObject("roomsData", data);
		return mav;
	}


}
