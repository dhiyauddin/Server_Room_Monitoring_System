package jbr.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jbr.springmvc.model.Device_Esp;
import jbr.springmvc.util.DateToolsUtil;

public class Device_EspDaoImpl implements Device_EspDao {

	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	DateToolsUtil dateToolsUtil;
	
	@Override
	public void register(Device_Esp device_Esp,String user) {
		String today = dateToolsUtil.getCurrentDateWithTimeStamp();
		String sql = "insert into device_esp (device_id,water_presence,created_date,created_by) values (?,?,?,?)";
		jdbcTemplate.update(sql,
				new Object[] { device_Esp.getDeviceId(), device_Esp.isWaterPresence(),today,user});
	}

	@Override
	public List<Device_Esp> displayAll() {
		String sql = "select device_id,water_presence from device_esp";
		List<Device_Esp> device_Esp = jdbcTemplate.query(sql,new Device_EspMapperAll());
        return device_Esp; 
	}

	@Override
	public List<Device_Esp> findByDeviceId(int deviceId) {
		String sql = "select device_id,water_presence from device_esp where device_id = '"+deviceId+"'";
		List<Device_Esp> device_Esp = jdbcTemplate.query(sql,new Device_EspMapperAll());
        return device_Esp; 
	}
}

class Device_EspMapper implements RowMapper<Device_Esp> {

	public Device_Esp mapRow(ResultSet rs, int arg1) throws SQLException {
		Device_Esp device_Esp = new Device_Esp();
		device_Esp.setRunningId(rs.getInt("Running_Id"));
		device_Esp.setDeviceId(rs.getInt("Device_Id"));
		device_Esp.setWaterPresence(rs.getBoolean("Water_Presence"));
		device_Esp.setCreatedDate(rs.getString("Created_Date"));
		device_Esp.setCreatedBy(rs.getString("Created_By"));
		device_Esp.setUpdatedDate(rs.getString("Updated_Date"));
		device_Esp.setUpdatedBy(rs.getString("Updated_By"));
		return device_Esp;
	}
}

class Device_EspMapperAll implements RowMapper<Device_Esp> {

	public Device_Esp mapRow(ResultSet rs, int arg1) throws SQLException {
		Device_Esp device_Esp = new Device_Esp();
		device_Esp.setDeviceId(rs.getInt("Device_Id"));
		device_Esp.setWaterPresence(rs.getBoolean("Water_Presence"));
		return device_Esp;
	}
}