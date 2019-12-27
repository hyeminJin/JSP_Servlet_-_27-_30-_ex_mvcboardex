package edu.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.bit.command.BCommand;
import edu.bit.command.BContentCommand;
import edu.bit.command.BDeleteCommand;
import edu.bit.command.BListCommand;
import edu.bit.command.BModifyCommand;
import edu.bit.command.BReplyCommand;
import edu.bit.command.BReplyViewCommand;
import edu.bit.command.BWriteCommand;

/**
 * Servlet implementation class BFrontController
 */
@WebServlet("*.do")
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo");
		request.setCharacterEncoding("EUC-KR");
		
		String viewPage = null;
		BCommand command = null; //BCommand 객체생성 (인터페이스)
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		System.out.println("테스트 uri: "+uri+" conPath: "+conPath+" com: "+com);
		if(com.equals("/write_view.do")) {
			
			viewPage = "write_view.jsp";
		
		}else if(com.equals("/write.do")) {
			
			command = new BWriteCommand();//다형성
			command.execute(request, response);
			
			viewPage = "list.do";
		
		}else if(com.equals("/list.do")) {
			command = new BListCommand();//다형성
			command.execute(request, response);
			
			viewPage = "list.jsp";
		
		}else if(com.equals("/content_view.do")) {
			
			command = new BContentCommand();//다형성
			command.execute(request, response);
			
			viewPage = "content_view.jsp";
		}else if(com.equals("/modify.do")) {
			
			command = new BModifyCommand();//다형성
			command.execute(request, response);
			
			viewPage = "list.do";
		}else if(com.equals("/delete.do")) {
			
			command = new BDeleteCommand();//다형성
			command.execute(request, response);
			
			viewPage = "list.do";
		}else if(com.equals("/reply_view.do")) {
			
			command = new BReplyViewCommand();//다형성
			command.execute(request, response);
			
			viewPage = "reply_view.jsp";
		}else if(com.equals("/reply.do")) {
			
			command = new BReplyCommand();//다형성
			command.execute(request, response);
			
			viewPage = "list.do";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);//user의 view 화면에 write_view.jsp 를 나타내게 한다.
	}

}
