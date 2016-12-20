package db;

import java.sql.ResultSet;
import java.util.LinkedList;

import common.DataBaseManager;
import model.Reservation;
import model.Room;
import model.User;


public class ReservationManager extends DataBaseManager{

	protected Object copyRecord(ResultSet rs) throws Exception{
		Reservation reservation = new Reservation();
		reservation.setRid(rs.getInt("RID"));
		int userRid=rs.getInt("UserRID");
		int roomRid=rs.getInt("RoomRID");
		reservation.setStartYear(rs.getInt("StartYear"));
		reservation.setStartMonth(rs.getInt("StartMonth"));
		reservation.setStartDay(rs.getInt("StartDay"));
		reservation.setStartHour(rs.getInt("StartHour"));
		reservation.setStartMinute(rs.getInt("StartMinute"));
		reservation.setPeriodHour(rs.getInt("PeriodHour"));
		reservation.setPeriodMinute(rs.getInt("PeriodMinute"));

		UserManager um=new UserManager();
		User user=um.getUser(userRid);
		reservation.setUser(user);

		RoomManager rm=new RoomManager();
		Room room=rm.getRoom(roomRid);
		reservation.setRoom(room);

		return reservation;
	}

	public Reservation getReservation(int rid){
		String sql = "";
		sql += "Select * from ReservationInfo Where ";
		sql += " RID = "+rid;
		return (Reservation)getRecord(sql);
	}

	public LinkedList<Reservation> getReservations(){
		String sql = "";
		sql += "Select * from ReservationInfo";

		return (LinkedList<Reservation>)getRecords(sql);
	}


}
