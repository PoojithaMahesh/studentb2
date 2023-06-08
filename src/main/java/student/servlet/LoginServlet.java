package student.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.dao.StudentDao;
import student.dto.Student;

public class LoginServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
String email=req.getParameter("email");
String password=req.getParameter("password");
StudentDao dao=new StudentDao();
List<Student> listOfStudent=dao.getStudents();
boolean value=false;
for(Student student:listOfStudent) {
	if(student.getEmail().equals(email)) {
		value=true;
		break;	
	}
}
if(value==true) {
//	that email is present
	Student student=dao.loginStudent(email);
	if(student.getPassword().equals(password)) {
//		loggin success
//		PrintWriter printWriter=resp.getWriter();
//		printWriter.print("Login success");
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("display.html");
		dispatcher.forward(req, resp);
	}else {
//		login failed
//		PrintWriter printWriter=resp.getWriter();
//		printWriter.print("login failure");
		RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
		dispatcher.include(req, resp);
	}
	
	
}else {
//	PrintWriter printWriter=resp.getWriter();
//	printWriter.print("SOrry iam not having that email");
	RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
	dispatcher.include(req, resp);
}
}
}
