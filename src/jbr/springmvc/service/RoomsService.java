package jbr.springmvc.service;

import java.util.List;

import jbr.springmvc.model.Rooms;

public interface RoomsService {

	void register(Rooms rooms,String user);

	List<Rooms> displayAll();

	List<Rooms> findByRoomsId(int roomsId);
	
	int totalRecords();
	
	int totalItems();
}
