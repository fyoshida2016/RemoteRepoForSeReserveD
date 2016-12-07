package servlet;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import common.TestDataBase;
import common.TestServlet;
import model.Reservation;
import model.Room;
import model.User;

public class ReservationListServletTest extends TestServlet {

	@Test
	public void RIDを指定して予約情報を読み込む() throws Exception {
		// データベースにテストデータを挿入
		TestDataBase db=new TestDataBase();
		db.setTestData("./testdata/story09/ReservationListtest.xls");

		// Getメソッドを指定
				setGet();

				// Servletを呼び出す。
				callServlet();


		// RequestにReservationオブジェクトが保存されていること（nullではないこと）を確認
		assertThat(request.getAttribute("Reservations"),is(notNullValue()));
		// RequestからUserオブジェクトを読み込み
		LinkedList<Reservation> reservations=(LinkedList<Reservation>)request.getAttribute("Reservations");

		// 読み込んだリストに登録されているユーザ数をチェック
		assertThat(reservations.size(),is(2));

		// 読み込んだオブジェクトのプロパティの値が適切かどうかをチェック
		Reservation reservation=reservations.get(1);

		assertThat(reservation.getRid(),is(2));
		assertThat(reservation.getUser().getRid(),is(2));
		assertThat(reservation.getRoom().getRid(),is(5));
		assertThat(reservation.getStartMonth(),is(1));
		assertThat(reservation.getStartDay(),is(1));
		assertThat(reservation.getStartHour(),is(1));
		assertThat(reservation.getStartMinute(),is(1));
		assertThat(reservation.getPeriodHour(),is(2));
		assertThat(reservation.getPeriodMinute(),is(30));

	}

}
