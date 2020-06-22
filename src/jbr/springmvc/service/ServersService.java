package jbr.springmvc.service;

import java.util.List;

import jbr.springmvc.model.Servers;

public interface ServersService {

	void register(Servers server,String user);
	
	List<Servers> displayAll();
	
	List<Servers> findByServerId(int serverId);
	
	int totalRecords();
}
