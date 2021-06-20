package final_project.web;

import java.io.IOException;
import java.util.ArrayList;
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

import final_project.dao.ItemDao;
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
	public ItemDao itemDao;

	public OrderController() {
		super();
		orderDao = new OrderDao();
		userDao = new UserDao();
		itemDao = new ItemDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (SessionController.sessionExists(request.getSession())) {
			User user = (User) session.getAttribute("user");
			
			List<Order> listOrder = new ArrayList<Order>();
			List<Item> itemList = itemDao.getAllItem();
			List<Order> newListOrder = new ArrayList<Order>();
			
			listOrder = orderDao.getAllOrders();
			
			if (user.getRole().equalsIgnoreCase("admin")) {
				request.setAttribute("listOrder", listOrder);
				for (Order order : listOrder) {
					Set<Item> orderItems = new HashSet<Item>();
					for(Item item : itemList) {
						if (item.getOrder().getId() == order.getId()) {
							orderItems.add(item);
						}
					}
					order.setItems(orderItems);
					newListOrder.add(order);
				}
			} else {
				for (Order order : listOrder) {
					Set<Item> orderItems = new HashSet<Item>();
					for(Item item : itemList) {
						if (item.getOrder().getId() == order.getId()) {
							orderItems.add(item);
						}
					}
					if(order.getUser().getId() == user.getId()) {
						order.setItems(orderItems);
						newListOrder.add(order);
					}
				}
			}
			
			request.setAttribute("listOrder", newListOrder);
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