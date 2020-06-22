package jbr.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jbr.springmvc.model.Device_Adafruit;
import jbr.springmvc.util.DateToolsUtil;

public class Device_AdafruitDaoImpl implements Device_AdafruitDao {

	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	DateToolsUtil dateToolsUtil;

	@Override
	public void register(Device_Adafruit device_Adafruit, String user) {
		String today = dateToolsUtil.getCurrentDateWithTimeStamp();
		String sql = "insert into device_adafruit (Device_Id,Temperature,Humidity,Battery,Created_Date,Created_By) values(?,?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] { device_Adafruit.getDeviceId(), device_Adafruit.getTemperature(),
				device_Adafruit.getHumidity(), device_Adafruit.getBattery(),today,user });
	}

	@Override
	public List<Device_Adafruit> displayAll() {
		
		String sql = "select device_id,temperature,humidity,battery from device_adafruit";
		List<Device_Adafruit> device_Adafruit = jdbcTemplate.query(sql, new Device_AdafruitMapperAll());
		return device_Adafruit;
	}

	@Override
	public List<Device_Adafruit> findByDeviceId(int deviceId) {
		String sql = "select device_id,temperature,humidity,battery from device_adafruit where device_id = '" + deviceId
				+ "'";
		List<Device_Adafruit> device_Adafruit = jdbcTemplate.query(sql, new Device_AdafruitMapperAll());
		return device_Adafruit;
	}
}

class Device_AdafruitMapper implements RowMapper<Device_Adafruit> {

	public Device_Adafruit mapRow(ResultSet rs, int arg1) throws SQLException {
		Device_Adafruit device_Adafruit = new Device_Adafruit();
		device_Adafruit.setRunningId(rs.getInt("Running_Id"));
		device_Adafruit.setDeviceId(rs.getInt("Device_Id"));
		device_Adafruit.setTemperature(rs.getFloat("Temperature"));
		device_Adafruit.setHumidity(rs.getFloat("Humidity"));
		device_Adafruit.setBattery(rs.getInt("Battery"));
		device_Adafruit.setCreatedDate(rs.getString("Created_Date"));
		device_Adafruit.setCreatedBy(rs.getString("Created_By"));
		device_Adafruit.setUpdatedDate(rs.getString("Updated_Date"));
		device_Adafruit.setUpdatedBy(rs.getString("Updated_By"));
		return device_Adafruit;
	}
}

class Device_AdafruitMapperAll implements RowMapper<Device_Adafruit> {

	public Device_Adafruit mapRow(ResultSet rs, int arg1) throws SQLException {
		Device_Adafruit device_Adafruit = new Device_Adafruit();
		device_Adafruit.setDeviceId(rs.getInt("Device_Id"));
		device_Adafruit.setTemperature(rs.getFloat("Temperature"));
		device_Adafruit.setHumidity(rs.getFloat("Humidity"));
		device_Adafruit.setBattery(rs.getInt("Battery"));
		
		return device_Adafruit;
	}
}