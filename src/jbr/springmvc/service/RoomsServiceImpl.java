package jbr.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jbr.springmvc.dao.RoomsDaoImpl;
import jbr.springmvc.model.Rooms;

public class RoomsServiceImpl implements RoomsService {

	@Autowired
	RoomsDaoImpl roomsDaoImpl;
	
	@Override
	public void register(Rooms rooms,String user) {
		roomsDaoImpl.register(rooms,user);

	}

	@Override
	public List<Rooms> displayAll() {
		List<Rooms> rooms;
		rooms = roomsDaoImpl.displayAll();
		return rooms;
	}

	@Override
	public List<Rooms> findByRoomsId(int roomsId) {
		List<Rooms> rooms;
		rooms = roomsDaoImpl.findByRoomsId(roomsId);
		return rooms;
	}

	@Override
	public int totalRecords() {
		int count = 0;
		count = roomsDaoImpl.totalRecords();
		return count;
	}

	@Override
	public int totalItems() {
		int count = 0;
		count = roomsDaoImpl.totalItems();
		return count;
	}

}
