package jbr.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jbr.springmvc.model.Devices;
import jbr.springmvc.util.DateToolsUtil;

public class DevicesDaoImpl implements DevicesDao {

	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	DateToolsUtil dateToolsUtil;
	
	@Override
	public void register(Devices devices,String user) {
		String today = dateToolsUtil.getCurrentDateWithTimeStamp();
		String sql = "insert into devices (Device_Id,Device_Type,Description,Created_Date,Created_By) values(?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] { devices.getDeviceId(),devices.getDeviceType(),devices.getDeviceDesc(),today,user});
	}

	@Override
	public List<Devices> displayAll() {
		String sql = "select distinct device_id,device_type,description from devices";
        List<Devices> devices = jdbcTemplate.query(sql,new DevicesMapperAll());
        return devices;
	}

	//use for MySql Database Pattern
	/*
	@Override
	public List<Devices> findByDeviceId(int deviceId) {
		String sql = "select distinct device_id,device_type,description from devices where device_id like '%"+deviceId+"%'";
        List<Devices> devices = jdbcTemplate.query(sql,new DevicesMapperAll());
        return devices;
	}
	*/
	
	//use for Postgresql Database Pattern
	@Override
	public List<Devices> findByDeviceId(int deviceId) {
		String sql = "select distinct device_id,device_type,description from devices where device_id = "+deviceId;
        List<Devices> devices = jdbcTemplate.query(sql,new DevicesMapperAll());
        return devices;
	}

	@Override
	public int totalRecords() {
		int count = 0;
		String sql = "select count(distinct device_id) Records from devices";
		count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}
}

class DevicesMapper implements RowMapper<Devices> {

	public Devices mapRow(ResultSet rs, int arg1) throws SQLException {
		Devices devices = new Devices();
		devices.setDeviceId(rs.getInt("Device_Id"));
		devices.setDeviceType(rs.getInt("Device_Type"));
		devices.setCreatedDate(rs.getString("Created_Date"));
		devices.setCreatedBy(rs.getString("Created_By"));
		devices.setUpdatedDate(rs.getString("Updated_Date"));
		devices.setUpdatedBy(rs.getString("Updated_By"));
		return devices;
	}
}

class DevicesMapperAll implements RowMapper<Devices> {

	public Devices mapRow(ResultSet rs, int arg1) throws SQLException {
		Devices devices = new Devices();
		devices.setDeviceId(rs.getInt("Device_Id"));
		devices.setDeviceType(rs.getInt("Device_Type"));
		devices.setDeviceDesc(rs.getString("Description"));
		return devices;
	}
}
