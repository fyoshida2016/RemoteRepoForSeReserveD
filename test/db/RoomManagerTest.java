package db;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import common.TestDataBase;
import model.Room;
import model.User;

public class RoomManagerTest {

	@Test
	public void 全会議室を読み込む() {
		// データベースにテストデータを挿入
		TestDataBase db=new TestDataBase();
		db.setTestData("./testdata/story05/dbaccess_test.xls");

		// 登録済みの部屋情報をデータベースから読み込み
		RoomManager rm=new RoomManager();
		LinkedList<Room> rooms=rm.getRooms();

		// 読み込んだオブジェクトの数が適切かどうかをチェック
		assertThat(rooms.size(),is(5));

		// 読み込んだオブジェクトのプロパティの値が適切かどうかをチェック
		Room room=rooms.get(4);
		assertThat(room.getName(),is("会議室"));
		assertThat(room.getBuildingName(),is("総合研究棟"));
		assertThat(room.getFloor(),is("6"));
		assertThat(room.getRoomNumber(),is("607"));
		assertThat(room.getArea(),is(98));
		assertThat(room.getCapacity(),is(50));
		assertThat(room.getTel(),is("5555"));
		assertThat(room.getWhiteboard(),is(5));
		assertThat(room.getProjecter(),is(0));
		assertThat(room.getScreen(),is(1));
		assertThat(room.getHdmi(),is(1));
		assertThat(room.getDsub(),is(1));
		assertThat(room.getComposite(),is(1));
		assertThat(room.getStereomini(),is(1));
	}

	@Test
	public void 存在するRIDを指定して会議室を読み込む() {
		// データベースにテストデータを挿入
		TestDataBase db=new TestDataBase();
		db.setTestData("./testdata/story06/dbaccess_test.xls");

		// 登録済みの部屋情報をデータベースから読み込み
		RoomManager rm=new RoomManager();
		Room room=rm.getRoom(5);

		// 読み込んだオブジェクトのプロパティの値が適切かどうかをチェック
		assertThat(room.getName(),is("会議室"));
		assertThat(room.getBuildingName(),is("総合研究棟"));
		assertThat(room.getFloor(),is("6"));
		assertThat(room.getRoomNumber(),is("607"));
		assertThat(room.getArea(),is(98));
		assertThat(room.getCapacity(),is(50));
		assertThat(room.getTel(),is("5555"));
		assertThat(room.getWhiteboard(),is(5));
		assertThat(room.getProjecter(),is(0));
		assertThat(room.getScreen(),is(1));
		assertThat(room.getHdmi(),is(1));
		assertThat(room.getDsub(),is(1));
		assertThat(room.getComposite(),is(1));
		assertThat(room.getStereomini(),is(1));
	}

	@Test
	public void 存在するRIDを指定して会議室名を読み込む() {
		// データベースにテストデータを挿入
		TestDataBase db=new TestDataBase();
		db.setTestData("./testdata/story09/dbaccess_test.xls");

		// 登録済みの部屋情報をデータベースから読み込み
		RoomManager rm=new RoomManager();
		String roomName=rm.getRoomName(1);

		// 読み込んだオブジェクトのプロパティの値が適切かどうかをチェック
		assertThat(roomName,is("物質・材料経営情報棟2階208号"));
	}



	@Test
	public void 存在しないRIDを指定して会議室を読み込む_1() {
		// データベースにテストデータを挿入
		TestDataBase db=new TestDataBase();
		db.setTestData("./testdata/story06/dbaccess_test.xls");

		// 登録済みの部屋情報をデータベースから読み込み
		RoomManager rm=new RoomManager();
		Room room=rm.getRoom(0);

		// オブジェクトが存在しないことをチェック
		assertThat(room,is(nullValue()));
	}

	@Test
	public void 存在しないRIDを指定して会議室を読み込む_2() {
		// データベースにテストデータを挿入
		TestDataBase db=new TestDataBase();
		db.setTestData("./testdata/story06/dbaccess_test.xls");

		// 登録済みの部屋情報をデータベースから読み込み
		RoomManager rm=new RoomManager();
		Room room=rm.getRoom(6);

		// オブジェクトが存在しないことをチェック
		assertThat(room,is(nullValue()));
	}

}

