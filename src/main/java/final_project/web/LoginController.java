package final_project.web;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import final_project.dao.UserDao;
import final_project.model.User;
import final_project.utl.SessionController;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao loginDao;

    public void init() {
        loginDao = new UserDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	if (SessionController.sessionExists(request.getSession())) {
    		response.sendRedirect("home.jsp");
    	}
    	else {
            response.sendRedirect("login.jsp");
    	}
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            authenticate(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response)
    throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = loginDao.validate(username, password);
        
        if (user != null) {
        	HttpSession session = request.getSession();
        	session.setAttribute("user", user);
            RequestDispatcher dispatcher = request.getRequestDispatcher(request.getContextPath());
            dispatcher.forward(request, response);
        } else {
        	request.setAttribute("error", "Username or password is invalid!");
        	request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}