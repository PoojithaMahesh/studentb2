package student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.dao.StudentDao;
import student.dto.Student;

public class StudentServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
String name=req.getParameter("name");
String email=req.getParameter("email");
String password=req.getParameter("password");
String address=req.getParameter("address");
long phone=Long.parseLong(req.getParameter("phoneNumber"));

Student student=new Student();
student.setAddress(address);
student.setEmail(email);
student.setName(name);
student.setPassword(password);
student.setPhoneNumber(phone);

StudentDao dao=new StudentDao();
dao.signStudent(student);
RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
dispatcher.forward(req, resp);


}
}
