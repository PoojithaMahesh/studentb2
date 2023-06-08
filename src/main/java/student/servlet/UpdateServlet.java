package student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.dao.StudentDao;
import student.dto.Student;

public class UpdateServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
int id=Integer.parseInt(req.getParameter("id"));
String name=req.getParameter("name");
StudentDao dao=new StudentDao();
Student student=dao.updateStudent(id,name);
if(student!=null) {
	PrintWriter printWriter=resp.getWriter();
	printWriter.print("updated successfully");
}else {
	PrintWriter printWriter=resp.getWriter();
	printWriter.print("update failure");
}

}
}
