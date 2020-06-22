package jbr.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jbr.springmvc.dao.ServersDaoImpl;
import jbr.springmvc.model.Servers;

public class ServersServiceImpl implements ServersService {

	@Autowired
	ServersDaoImpl serversDaoImpl;
	
	@Override
	public void register(Servers servers,String user) {
		serversDaoImpl.register(servers,user);

	}

	@Override
	public List<Servers> displayAll() {
		List<Servers> servers;
		servers = serversDaoImpl.displayAll();
		return servers;
	}

	@Override
	public List<Servers> findByServerId(int serverId) {
		List<Servers> servers;
		servers = serversDaoImpl.findByServersId(serverId);
		return servers;
	}

	@Override
	public int totalRecords() {
		int count = 0;
		count = serversDaoImpl.totalRecords();
		return count;
	}

}
