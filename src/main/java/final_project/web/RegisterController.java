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

@WebServlet("/Register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
		UserDao registerDao;
    public RegisterController() {
        registerDao = new UserDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	if (SessionController.sessionExists(request.getSession())) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(request.getContextPath());
            dispatcher.forward(request, response);
    	}
    	else {
            response.sendRedirect("register.jsp");
    	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            register(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	
	private void register(HttpServletRequest request, HttpServletResponse response)
		    throws Exception {
		        String username = request.getParameter("username");
		        String password = request.getParameter("password");
		        String firstname = request.getParameter("firstname");
		        String lastname = request.getParameter("lastname");
		        
		        User user = new User(firstname, lastname, username, password);

		        registerDao.saveUser(user);
		        
		        User return_user = registerDao.validate(username, password);
		        
		        if (return_user != null) {
		        	HttpSession session = request.getSession();
		        	session.setAttribute("user", return_user);
		            RequestDispatcher dispatcher = request.getRequestDispatcher(request.getContextPath());
		            dispatcher.forward(request, response);
		        } else {
		        	request.setAttribute("error", "Register error!");
		        	request.getRequestDispatcher("register.jsp").forward(request, response);
		        }
		    }

}
