package db;

import java.sql.ResultSet;
import java.util.LinkedList;

import common.DataBaseManager;
import model.Room;
import model.User;

public class RoomManager extends DataBaseManager {

	protected Object copyRecord(ResultSet rs) throws Exception {
		Room room = new Room();
		room.setRid(rs.getInt("RID"));
		room.setName(rs.getString("Name").trim());
		room.setBuildingName(rs.getString("BuildingName").trim());
		room.setFloor(rs.getString("Floor").trim());
		room.setRoomNumber(rs.getString("RoomNumber").trim());
		room.setArea(rs.getInt("Area"));
		room.setCapacity(rs.getInt("Capacity"));
		room.setTel(rs.getString("Tel").trim());
		room.setWhiteboard(rs.getInt("Whiteboard"));
		room.setProjecter(rs.getInt("Projecter"));
		room.setScreen(rs.getInt("Screen"));
		room.setHdmi(rs.getInt("HDMI"));
		room.setDsub(rs.getInt("Dsub"));
		room.setComposite(rs.getInt("Composite"));
		room.setStereomini(rs.getInt("Stereomini"));
		return room;
	}

	public Room getRoom(int rid) {
		String sql = "";
		sql += "Select * from RoomInfo Where ";
		sql += " RID = " + rid;
		return (Room) getRecord(sql);
	}

	public String getRoomName(int rid) {
		String sql = "";
		sql += "Select * from RoomInfo Where ";
		sql += " RID = " + rid;
		System.out.println(sql);

		Room result = (Room) getRecord(sql);

		String roomResult = result.getBuildingName() + result.getFloor() + "階" + result.getRoomNumber() + "号";

		System.out.println(roomResult);

		return roomResult;

	}

	public LinkedList<Room> getRooms() {
		String sql = "";
		sql += "Select * from RoomInfo";

		return (LinkedList<Room>) getRecords(sql);
	}
}
