package controllers;

import dao.DBmanager;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

    private DBmanager dBmanager;

    @Override
    public void init() throws ServletException {
        dBmanager = new DBmanager();
        dBmanager.createConnection();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        User user = dBmanager.checkUser(name, password);

        if (user != null) {
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher("/home.jsp").forward(request,response);
        } else {

            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        //   response.sendRedirect("/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        boolean isonline = (boolean) request.getAttribute("isonline");
//
//        if (isonline) {
//            response.sendRedirect("/home.jsp");
//        } else{
//
//            request.getRequestDispatcher("/index.jsp").forward(request, response);
//        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
