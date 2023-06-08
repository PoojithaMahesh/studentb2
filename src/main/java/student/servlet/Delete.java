package student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.dao.StudentDao;
import student.dto.Student;

public class Delete extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
int id=Integer.parseInt(req.getParameter("id"));
StudentDao dao=new StudentDao();
Student  student=dao.deleteStudentById(id);
if(student!=null) {
	PrintWriter printWriter=resp.getWriter();
	printWriter.print("Yes deleted successfully");
}else {
	PrintWriter printWriter=resp.getWriter();
	printWriter.print("Sorry student is not present");
}

}
}
