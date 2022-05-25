package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import Model.Qs;
import Model.QsLogic;
import Model.Stat;
import Model.StatLogic;

/**
 * Servlet implementation class Calc
 */
@WebServlet("/calc")
public class Calc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final int NUMCOUNT=2,MIN=50,MAX=99;
		ServletContext application=this.getServletContext();
		Stat stat=(Stat)application.getAttribute("stat");
		
		if(stat==null) {
			stat=new Stat();
		}
		application.setAttribute("stat",stat);

		Qs qs=new Qs();
		QsLogic logic=new QsLogic();
		logic.create(qs,NUMCOUNT,MIN,MAX);
		HttpSession session=request.getSession();
		session.setAttribute("qs",qs);
		
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/index.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ans=(String)request.getParameter("ans");
		HttpSession session=request.getSession();
		Qs qs=(Qs)session.getAttribute("qs");
		QsLogic logic=new QsLogic();
		logic.result(qs,ans);
		
		ServletContext application=this.getServletContext();
		Stat stat=(Stat)application.getAttribute("stat");
		StatLogic statLogic=new StatLogic();
		
		if(qs.isCorrect()) {
			statLogic.correctPlus(stat);
		}else {
			statLogic.wrongPlus(stat);
		}

		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/index.jsp");
		rd.forward(request, response);
	}

}