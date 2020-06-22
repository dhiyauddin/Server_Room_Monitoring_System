package jbr.springmvc.dao;

import java.util.List;

import jbr.springmvc.model.Servers;

public interface ServersDao {

	void register(Servers servers,String user);

	List<Servers> displayAll();

	List<Servers> findByServersId(int serverId);
	
	int totalRecords();
}
