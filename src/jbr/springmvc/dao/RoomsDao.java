package jbr.springmvc.dao;

import java.util.List;

import jbr.springmvc.model.Rooms;

public interface RoomsDao {

	void register(Rooms rooms,String user);

	List<Rooms> displayAll();

	List<Rooms> findByRoomsId(int roomsId);
	
	int totalRecords();
	
	int totalItems();
}
