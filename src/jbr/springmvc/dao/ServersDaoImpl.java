package jbr.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jbr.springmvc.model.Servers;
import jbr.springmvc.util.DateToolsUtil;

public class ServersDaoImpl implements ServersDao {

	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	DateToolsUtil dateToolsUtil;
	
	@Override
	public void register(Servers servers,String user) {
		String today = dateToolsUtil.getCurrentDateWithTimeStamp();
		String sql = "insert into servers (Server_Id,Description,Device_Id,Created_Date,Created_By) values(?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] { servers.getServerId(),servers.getDescription(), servers.getDeviceId(),today,user});
	}

	@Override
	public List<Servers> displayAll() {
		String sql = "select distinct Server_Id,Description from servers";
        List<Servers> servers = jdbcTemplate.query(sql,new ServersMapperAll());
        return servers;
	}

	//use for MySql Database Pattern
	/*
	@Override
	public List<Servers> findByServersId(int serverId) {
		String sql = "select distinct server_id,description from servers where server_id like '%"+serverId+"%'";
        List<Servers> servers = jdbcTemplate.query(sql,new ServersMapperAll());
        return servers;
	}
	*/

	//use for Postgresql Database Pattern
	@Override
	public List<Servers> findByServersId(int serverId) {
		String sql = "select distinct server_id,description from servers where server_id = "+serverId;
        List<Servers> servers = jdbcTemplate.query(sql,new ServersMapperAll());
        return servers;
	}

	@Override
	public int totalRecords() {
		int count = 0;
		String sql = "select count(distinct server_id) Records from servers";
		count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}
}

class ServersMapper implements RowMapper<Servers> {

	public Servers mapRow(ResultSet rs, int arg1) throws SQLException {
		Servers servers = new Servers();
		servers.setRunningId(rs.getInt("Running_Id"));
		servers.setServerId(rs.getInt("Server_Id"));
		servers.setDescription(rs.getString("Description"));
		servers.setDeviceId(rs.getInt("Device_Id"));
		servers.setCreatedDate(rs.getString("Created_Date"));
		servers.setCreatedBy(rs.getString("Created_By"));
		servers.setUpdatedDate(rs.getString("Updated_Date"));
		servers.setUpdatedBy(rs.getString("Updated_By"));
		return servers;
	}
}

class ServersMapperAll implements RowMapper<Servers> {

	public Servers mapRow(ResultSet rs, int arg1) throws SQLException {
		Servers servers = new Servers();
		servers.setServerId(rs.getInt("Server_Id"));
		servers.setDescription(rs.getString("description"));
		return servers;
	}
}