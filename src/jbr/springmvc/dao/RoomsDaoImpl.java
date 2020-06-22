package jbr.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jbr.springmvc.model.Rooms;
import jbr.springmvc.model.User;
import jbr.springmvc.util.DateToolsUtil;

public class RoomsDaoImpl implements RoomsDao {

	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	DateToolsUtil dateToolsUtil;
	
	@Override
	public void register(Rooms rooms,String user) {
		String today = dateToolsUtil.getCurrentDateWithTimeStamp();
		String sql = "insert into rooms (Room_Id,Description,Server_Id,Created_Date,Created_By) values(?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] { rooms.getRoomId(),rooms.getDescription(),rooms.getServerId(),today,user });
	}

	@Override
	public List<Rooms> displayAll() {
		String sql = "select distinct Room_Id,Server_Id,Description from rooms";
        List<Rooms> rooms = jdbcTemplate.query(sql,new RoomsMapperAll());
        return rooms;
	}

	//use for MySql Database Pattern
	/*	
	@Override
	public List<Rooms> findByRoomsId(int roomsId) {
		String sql = "select distinct Room_Id,Server_Id,Description from rooms where room_id like '%"+roomsId+"%'";
        List<Rooms> rooms = jdbcTemplate.query(sql,new RoomsMapperAll());
        return rooms;
	}
	*/
	
	//use for Postgresql Database Pattern
	@Override
	public List<Rooms> findByRoomsId(int roomsId) {
		String sql = "select distinct Room_Id,Server_Id,Description from rooms where room_id = "+roomsId;
        List<Rooms> rooms = jdbcTemplate.query(sql,new RoomsMapperAll());
        return rooms;
	}

	@Override
	public int totalRecords() {
		int count = 0;
		String sql = "select count(*) Records from rooms";
		count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}

	@Override
	public int totalItems() {
		int count = 0;
		String sql = "select count(distinct room_id) Records from rooms";
		count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}
}

class RoomsMapper implements RowMapper<Rooms> {

	public Rooms mapRow(ResultSet rs, int arg1) throws SQLException {
		Rooms rooms = new Rooms();
		rooms.setRunningId(rs.getInt("Running_Id"));
		rooms.setRoomId(rs.getInt("Room_Id"));
		rooms.setDescription(rs.getString("Description"));
		rooms.setServerId(rs.getInt("Server_Id"));
		rooms.setCreatedDate(rs.getString("Created_Date"));
		rooms.setCreatedBy(rs.getString("Created_By"));
		rooms.setUpdatedDate(rs.getString("Updated_Date"));
		rooms.setUpdatedBy(rs.getString("Updated_By"));
		return rooms;
	}
}

class RoomsMapperAll implements RowMapper<Rooms> {

	public Rooms mapRow(ResultSet rs, int arg1) throws SQLException {
		Rooms rooms = new Rooms();
		rooms.setRoomId(rs.getInt("Room_Id"));
		rooms.setServerId(rs.getInt("Server_Id"));
		rooms.setDescription(rs.getString("Description"));
		return rooms;
	}
}
