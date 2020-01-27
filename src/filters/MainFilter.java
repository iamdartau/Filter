package filters;

import dao.DBmanager;
import models.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class MainFilter extends HttpFilter {

    private DBmanager dBmanager;

    public void destroy() {
    }

    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {

        User user = (User) (request).getSession().getAttribute("user");
//        System.out.println("offline");
//        boolean isonline = false;
        if (user != null) {
            User tempUser = dBmanager.checkUser(user.getName(), user.getPassword());
            if (tempUser != null) {
//                isonline = true;
//                System.out.println(" isOnline");
//                request.setAttribute("isonline", isonline);
                chain.doFilter(request, response);
            } else {
//                System.out.println("baseCheckedNegative");
//                request.getSession().removeAttribute("user");
                request.getRequestDispatcher("index.jsp?error=1").forward(request, response);
            }
        }
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {
        dBmanager = new DBmanager();
        dBmanager.createConnection();
    }

}
