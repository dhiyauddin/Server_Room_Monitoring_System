package jbr.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jbr.springmvc.model.Devices;
import jbr.springmvc.model.Report_Device_Adafruit;

public class Report_Device_AdafruitDaoImpl implements Report_Device_AdafruitDao {

	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Report_Device_Adafruit> displayAll() {
		String sql = "Select a.Room_Id,a.description Room_Description,b.Server_Id,b.description Server_Description,c.Device_Id,c.Device_Type,d.Temperature,d.Humidity,d.Battery "
				+ "from " + "Rooms a " + "inner join Servers b on a.Server_Id=b.Server_Id "
				+ "inner join Devices c on b.Device_Id = c.Device_Id "
				+ "inner join Device_Adafruit d on c.Device_Id = d.Device_Id";
		List<Report_Device_Adafruit> report_Device_Adafruit = jdbcTemplate.query(sql,
				new Report_Device_AdafruitMapperAll());
		return report_Device_Adafruit;
	}

	// use for MySql Database Pattern
	/*
	 * @Override public List<Report_Device_Adafruit> findByServerId(int serverId) {
	 * String sql =
	 * "Select a.Room_Id,a.description Room_Description,b.Server_Id,b.description Server_Description,c.Device_Id,c.Device_Type,d.Temperature,d.Humidity,d.Battery "
	 * + "from " + "Rooms a " + "inner join Servers b on a.Server_Id=b.Server_Id " +
	 * "inner join Devices c on b.Device_Id = c.Device_Id " +
	 * "inner join Device_Adafruit d on c.Device_Id = d.Device_Id " +
	 * "where b.server_Id = '"+serverId+"'" +
	 * "group by a.Room_Id,b.Server_Id,c.Device_Id;"; List<Report_Device_Adafruit>
	 * devices = jdbcTemplate.query(sql,new Report_Device_AdafruitMapperAll());
	 * return devices; }
	 */

	// use for Postgresql Database Pattern
	@Override
	public List<Report_Device_Adafruit> findByServerId(int serverId) {
		String sql = "Select a.Room_Id,a.description Room_Description,b.Server_Id,b.description Server_Description,c.Device_Id,c.Device_Type,d.Temperature,d.Humidity,d.Battery "
				+ "from " + "Rooms a " + "inner join Servers b on a.Server_Id=b.Server_Id "
				+ "inner join Devices c on b.Device_Id = c.Device_Id "
				+ "inner join Device_Adafruit d on c.Device_Id = d.Device_Id " + "where b.server_Id = " + serverId + " "
				+ "group by a.Room_Id,b.Server_Id,c.Device_Id,a.description,b.description,d.Temperature,d.Humidity,d.Battery;";
		System.out.println(sql);
		List<Report_Device_Adafruit> devices = jdbcTemplate.query(sql, new Report_Device_AdafruitMapperAll());
		return devices;
	}

	@Override
	public int totalRecords() {
		int count = 0;
		String sql = "Select count(c.Device_Id) Records " + "from " + "Rooms a "
				+ "inner join Servers b on a.Server_Id=b.Server_Id "
				+ "inner join Devices c on b.Device_Id = c.Device_Id "
				+ "inner join Device_Adafruit d on c.Device_Id = d.Device_Id";
		count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}

	// use for MySql Database Pattern
	/*
	@Override
	public List<Report_Device_Adafruit> displayTimeSeries() {
		String sql = "select count(*) total,monthname(created_date) months,dayname(created_date) days, date(created_date) created_date "
				+ "from " + "device_adafruit " + "group by month(created_date),dayname(created_date)";
		List<Report_Device_Adafruit> report_Device_Adafruit = jdbcTemplate.query(sql,
				new Report_Device_AdafruitMapperGroup());
		return report_Device_Adafruit;
	}
	*/
	
	// use for MySql Database Pattern
	@Override
	public List<Report_Device_Adafruit> displayTimeSeries() {
		String sql = "select count(*) total,date_part('month',created_date) months,date_part('day',created_date) days, date(created_date) created_date "
				+ "from " + "device_adafruit " + "group by device_adafruit.created_date,date_part('month',created_date),date_part('day',created_date)";
		List<Report_Device_Adafruit> report_Device_Adafruit = jdbcTemplate.query(sql,
				new Report_Device_AdafruitMapperGroup());
		return report_Device_Adafruit;
	}

}

class Report_Device_AdafruitMapperAll implements RowMapper<Report_Device_Adafruit> {

	public Report_Device_Adafruit mapRow(ResultSet rs, int arg1) throws SQLException {
		Report_Device_Adafruit report_Device_Adafruit = new Report_Device_Adafruit();
		report_Device_Adafruit.setRoomId(rs.getInt("Room_Id"));
		report_Device_Adafruit.setRoomDesc(rs.getString("Room_Description"));
		report_Device_Adafruit.setServerId(rs.getInt("Server_Id"));
		report_Device_Adafruit.setServerDesc(rs.getString("Server_Description"));
		report_Device_Adafruit.setDeviceId(rs.getInt("Device_Id"));
		report_Device_Adafruit.setDeviceType(rs.getInt("Device_Type"));
		report_Device_Adafruit.setTemperature(rs.getFloat("temperature"));
		report_Device_Adafruit.setHumidity(rs.getFloat("humidity"));
		report_Device_Adafruit.setBattery(rs.getInt("battery"));
		return report_Device_Adafruit;
	}
}

class Report_Device_AdafruitMapperGroup implements RowMapper<Report_Device_Adafruit> {

	public Report_Device_Adafruit mapRow(ResultSet rs, int arg1) throws SQLException {
		Report_Device_Adafruit report_Device_Adafruit = new Report_Device_Adafruit();
		report_Device_Adafruit.setTotal(rs.getInt("total"));
		report_Device_Adafruit.setMonth(rs.getString("months"));
		report_Device_Adafruit.setDayName(rs.getString("days"));
		report_Device_Adafruit.setCreatedDate(rs.getString("created_date"));
		return report_Device_Adafruit;
	}
}
