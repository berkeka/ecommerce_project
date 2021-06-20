package final_project.web;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

@WebServlet("/Payment")
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
	private OrderDao orderDao;

	public PaymentController() {
		super();
		userDao = new UserDao();
		orderDao = new OrderDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (SessionController.sessionExists(request.getSession())) {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			List<Item> cart = (List<Item>) session.getAttribute("cart");

			double total = 0;

			for (Item item : cart) {
				total += item.getProduct().getProductPrice() * item.getQuantity();
			}

			request.setAttribute("total", total);
			RequestDispatcher dispatcher = request.getRequestDispatcher("payment.jsp");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("error", "You have to be logged in to complete this purchase!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		List<Item> cart = (List<Item>) session.getAttribute("cart");
		Set<Item> items = new HashSet<Item>();

		Order order = new Order();
		order.setUser(user);
		
		for (Item item : cart) {
			item.setOrder(order);
			items.add(item);
		}
		order.setItems(items);
		orderDao.saveOrder(order);
		
		request.getRequestDispatcher(request.getContextPath() + "/Order").forward(request, response);
	}

}