package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dogDAO;
import model.dogDTO;


@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		HttpSession session = request.getSession();
		String dogName = request.getParameter("dogName");
		dogDAO dao = new dogDAO();
		ArrayList<dogDTO> list = new ArrayList<dogDTO>();
		System.out.println(dogName);
		if(dogName != null) {
			list = dao.dogTextSelect(dogName);
			
		}
		
		if(list != null) {
			int cnt = 1;
			session.setAttribute("list", list);
			session.setAttribute("cnt", cnt);
			System.out.println("검색성공");
			response.sendRedirect("dog2.jsp");
		}else {
			System.out.println("검색실패");
			response.sendRedirect("dog.jsp");
		}
		
	
		
		
		
		
		
	}

}
