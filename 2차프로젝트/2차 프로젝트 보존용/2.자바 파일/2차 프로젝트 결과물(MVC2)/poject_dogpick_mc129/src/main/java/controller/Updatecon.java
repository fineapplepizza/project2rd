package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.memberDAO;
import model.memberDTO;

@WebServlet("/Updatecon")
public class Updatecon extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		//세션에 저장되어 있는 memberDTO의 정보(지금 로그인중인 회원정보)를 가져옴
		HttpSession session = request.getSession();
		memberDTO member = (memberDTO)session.getAttribute("member");
		
		String newpw = request.getParameter("newpw");
		String newtel = request.getParameter("newtel");
		String newemail = request.getParameter("newemail");
		String newaddress = request.getParameter("newaddress");
		
		memberDTO member2 = new memberDTO(member.getId(),newpw,newtel,newemail,newaddress);
		memberDAO dao = new memberDAO();
		int cnt = dao.update(member2);
		
		if (cnt > 0) {
			session.setAttribute("member", member2);
			System.out.println("수정성공");
			RequestDispatcher dispatcher = request.getRequestDispatcher("introduce.jsp");
			dispatcher.forward(request, response);

		} else {
			response.sendRedirect("introduce.jsp");
		}
		
		
	}

}
