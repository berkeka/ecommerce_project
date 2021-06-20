package final_project.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import final_project.dao.OrderDao;
import final_project.dao.UserDao;
import final_project.model.Item;
import final_project.model.Order;
import final_project.model.User;
import final_project.utl.SessionController;

@WebServlet("/Order")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrderDao orderDao;
	public UserDao userDao;

	public OrderController() {
		super();
		orderDao = new OrderDao();
		userDao = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (SessionController.sessionExists(request.getSession())) {
			User user = (User) session.getAttribute("user");
			
			List<Order> listOrder = new ArrayList<Order>();

			if (user.getRole().equalsIgnoreCase("admin")) {
				listOrder = orderDao.getAllOrders();
				request.setAttribute("listOrder", listOrder);
			} else {
				listOrder = orderDao.getAllOrders();
				List<Order> newListOrder = new ArrayList<Order>();
				
				for (Order order : listOrder) {
					if(order.getUser().getId() == user.getId())
						newListOrder.add(order);
				}
				request.setAttribute("listOrder", newListOrder);
			}
			request.getRequestDispatcher("orders.jsp").forward(request, response);
    	}
    	else {
            response.sendRedirect("login.jsp");
    	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
