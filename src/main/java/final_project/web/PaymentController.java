package final_project.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import final_project.utl.SessionController;

@WebServlet("/Payment")
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PaymentController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	if (SessionController.sessionExists(request.getSession())) {
            response.sendRedirect("payment.jsp");
    	}
    	else {
    		response.sendRedirect("home.jsp");
    	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
