package servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.ReservationManager;
import db.UserManager;
import model.Reservation;

@WebServlet(name = "ReservationServlet", urlPatterns = { "/ReservationServlet" })
public class ReservationListServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doMain(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doMain(req, res);
	}

	public void doMain(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");

		ReservationManager rm=new ReservationManager();
		LinkedList<Reservation> reservations=rm.getReservations();

		req.setAttribute("Reservations", reservations);
		req.getRequestDispatcher("ReservationList.jsp").forward(req, res);


	}
}
