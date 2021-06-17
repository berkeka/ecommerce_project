package final_project.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import final_project.dao.ProductDao;
import final_project.dao.UserDao;
import final_project.model.Product;

@WebServlet("/Product")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ProductDao productDao;
	
    public ProductController() {
        super();
        productDao = new ProductDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id;
		try {
		   id = Integer.parseInt(request.getParameter("prod_id"));
		}
		catch (NumberFormatException e)
		{
		   id = 0;
		}
		
		if(id != 0) {
			Product product = productDao.getProduct(id);
	        request.setAttribute("product", product);
	        
	        RequestDispatcher dispatcher = request.getRequestDispatcher("product.jsp");
	        dispatcher.forward(request, response);
		}
		else {
	        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
	        dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
