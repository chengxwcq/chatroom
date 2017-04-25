package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import java.util.Enumeration;

import dao.ContentDAO;
import bean.Content;
import bean.User;

public class SubmitServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {

            /*Enumeration paramNames = request.getSession().getAttributeNames();
            while (paramNames.hasMoreElements()) {
                String paraName = (String)paramNames.nextElement();  
                System.out.println(paraName);
            }*/
            String text = request.getParameter("text");

            User user = (User) request.getSession().getAttribute("user");

            Content p = new Content();
            p.setContent(text);
            p.setUsername(user.getName());
            p.setStime(new Date().toLocaleString());
            
            new ContentDAO().addContent(p);
            new GetContentServlet().service(request, response);
    }
}
