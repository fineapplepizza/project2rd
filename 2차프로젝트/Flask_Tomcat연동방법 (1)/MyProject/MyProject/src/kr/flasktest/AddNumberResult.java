package kr.flasktest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddNumberResult")
public class AddNumberResult extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("euc-kr");
		PrintWriter out = response.getWriter();
		
		String result = request.getParameter("result");
		
		System.out.println("두 수를 더한 결과 >> "+result);
		
		out.print("<html>");
		out.print("<body>");
		out.print("<h1>두 수를 더한 결과</h1>");
		out.print("<h1>"+result+"</h1>");
		out.print("</body>");
		out.print("</html>");

	}

}
