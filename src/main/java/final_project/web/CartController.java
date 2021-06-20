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

import final_project.dao.ProductDao;
import final_project.model.Item;
import final_project.model.Product;


@WebServlet("/Cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDao productDao ;
       
    
    public CartController() {
        super();
        productDao = new ProductDao();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
		if (action == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("cart.jsp");
	        dispatcher.forward(request, response);

		} else {
			if (action.equalsIgnoreCase("add")) {
				doGet_Buy(request, response);
			} else if (action.equalsIgnoreCase("remove")) {
				doGet_Remove(request, response);
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doGet_Buy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Product productModel = new Product();
		int count = Integer.valueOf(request.getParameter("prod_count"));
		HttpSession session = request.getSession();
		if (session.getAttribute("cart") == null) {
			List<Item> cart = new ArrayList<Item>();
			cart.add(new Item(productDao.getProduct(Integer.valueOf(request.getParameter("prod_id"))), count));
			session.setAttribute("cart", cart);
		} else {
			List<Item> cart = (List<Item>)session.getAttribute("cart");
			int index = isExisting(Integer.valueOf(request.getParameter("prod_id")), cart);
			if (index == -1) {
				cart.add(new Item(productDao.getProduct(Integer.valueOf(request.getParameter("prod_id"))), count));
			} else {
				int quantity = cart.get(index).getQuantity() + count;
				cart.get(index).setQuantity(quantity);
			}
			session.setAttribute("cart", cart);
		}
		response.sendRedirect("Cart");
	}
	private int isExisting(int id, List<Item> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProduct().getId() == id) {
				return i;
			}
		}
		return -1;
	}
	protected void doGet_Remove(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		int index = isExisting(Integer.valueOf(request.getParameter("id")), cart);
		cart.remove(index);
		session.setAttribute("cart", cart);
		response.sendRedirect("Cart");
	}
}
