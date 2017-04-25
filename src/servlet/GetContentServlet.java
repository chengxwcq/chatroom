package servlet;

import java.io.IOException;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContentDAO;
import bean.Content;

public class GetContentServlet extends HttpServlet{
    protected void service(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
            List<Content> list = new ContentDAO().ListContent();
            request.setAttribute("contents", list);
            request.getRequestDispatcher("interface.jsp").forward(request, response);
        }

}
