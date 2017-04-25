package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import bean.User;
import dao.UserDAO;

public class UserLoginServlet extends HttpServlet{
    protected void service(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
            String name = request.getParameter("user");
            String password = request.getParameter("password");
            System.out.println(name);
            System.out.println(password);
            User p = new UserDAO().getUser(name, password);
            if (p != null) {
                request.getSession().setAttribute("user", p);
                response.sendRedirect("/content");
            }
            else {
                response.sendRedirect("/login.jsp");
            }
        }
}
