package com.zumba.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zumba.bean.Batch;
import com.zumba.service.BatchService;

/**
 * Servlet implementation class ParticipantUpdateController
 */
@WebServlet("/ParticipantUpdateController")
public class ParticipantUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ParticipantUpdateController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw = response.getWriter();
		BatchService bs = new BatchService();
		HttpSession hs = request.getSession();

		List<Batch> listOfBatch = bs.allBatchDetails();
		System.out.println(listOfBatch.size());
		hs.setAttribute("batchInfo", listOfBatch);
		RequestDispatcher rd1 = request.getRequestDispatcher("updateParticipants.jsp");

		rd1.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
