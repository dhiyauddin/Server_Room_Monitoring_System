package jbr.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jbr.springmvc.model.Report_Device_Adafruit;
import jbr.springmvc.model.Report_Device_Esp;

public class Report_Device_EspDaoImpl implements Report_Device_EspDao {

	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Report_Device_Esp> displayAll() {
		String sql = 
				"Select a.Room_Id,a.description Room_Description,b.Server_Id,b.description Server_Description,c.Device_Id,c.Device_Type,e.Water_Presence " + 
				"from " + 
				"Rooms a " + 
				"inner join Servers b on a.Server_Id=b.Server_Id " + 
				"inner join Devices c on b.Device_Id = c.Device_Id " + 
				"inner join Device_Esp e on c.Device_Id = e.Device_Id";
		List<Report_Device_Esp> report_Device_Esp = jdbcTemplate.query(sql,new Report_Device_EspMapperAll());
        return report_Device_Esp;
	}

	@Override
	public int totalRecords() {
		int count = 0;
		String sql = 
				"Select count(c.Device_Id) Records " + 
				"from " + 
				"Rooms a " + 
				"inner join Servers b on a.Server_Id=b.Server_Id " + 
				"inner join Devices c on b.Device_Id = c.Device_Id " + 
				"inner join Device_Esp e on c.Device_Id = e.Device_Id";
		count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}

	//use for MySql Database Pattern
	/*
	@Override
	public List<Report_Device_Esp> displayTimeSeries() {
		String sql = 
				"select count(*) total,monthname(created_date) months,dayname(created_date) days, date(created_date) created_date " + 
				"from " + 
				"device_esp " + 
				"group by month(created_date),dayname(created_date)";
		List<Report_Device_Esp> report_Device_Esp = jdbcTemplate.query(sql,new Report_Device_EspMapperGroup());
        return report_Device_Esp;
	}
	*/
	
	//use for Postgresql Database Pattern
	//date_part('month', created_at)
	@Override
	public List<Report_Device_Esp> displayTimeSeries() {
		String sql = 
				"select count(*) total, date_part('month',created_date) months, date_part('day',created_date) days, date(created_date) created_date " + 
				"from " + 
				"device_esp " + 
				"group by device_esp.created_date,date_part('month',created_date),date_part('day',created_date)";
		List<Report_Device_Esp> report_Device_Esp = jdbcTemplate.query(sql,new Report_Device_EspMapperGroup());
        return report_Device_Esp;
	}

}

class Report_Device_EspMapperAll implements RowMapper<Report_Device_Esp> {

	public Report_Device_Esp mapRow(ResultSet rs, int arg1) throws SQLException {
		Report_Device_Esp report_Device_Esp = new Report_Device_Esp();
		report_Device_Esp.setRoomId(rs.getInt("Room_Id"));
		report_Device_Esp.setRoomDesc(rs.getString("Room_Description"));
		report_Device_Esp.setServerId(rs.getInt("Server_Id"));
		report_Device_Esp.setServerDesc(rs.getString("Server_Description"));
		report_Device_Esp.setDeviceId(rs.getInt("Device_Id"));
		report_Device_Esp.setDeviceType(rs.getInt("Device_Type"));
		report_Device_Esp.setWaterPresence(rs.getBoolean("water_presence"));
		return report_Device_Esp;
	}
}

class Report_Device_EspMapperGroup implements RowMapper<Report_Device_Esp> {

	public Report_Device_Esp mapRow(ResultSet rs, int arg1) throws SQLException {
		Report_Device_Esp report_Device_Esp = new Report_Device_Esp();
		report_Device_Esp.setTotal(rs.getInt("total"));
		report_Device_Esp.setMonth(rs.getString("months"));
		report_Device_Esp.setDayName(rs.getString("days"));
		report_Device_Esp.setCreatedDate(rs.getString("created_date"));
		return report_Device_Esp;
	}
}