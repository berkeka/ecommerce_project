package final_project.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import final_project.dao.ProductDao;
import final_project.model.Product;

@WebServlet("/")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDao productDao;

    public HomeController() {
        super();
        productDao = new ProductDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List < Product > listProduct = productDao.getAllProduct();

        int itemCount = listProduct.size();
        
        int page = 1;
        int productPerPage = 4;
        int pageCount = (int)Math.ceil(itemCount / productPerPage) + 1;
        
        if(request.getParameter("currentPage") != null)
            page = Integer.parseInt(request.getParameter("currentPage"));
        
        int startIndex = (page - 1)* productPerPage;
        int endIndex = startIndex + productPerPage;
        
        if (endIndex - 1 >= itemCount) {
        	endIndex = itemCount;
        }
        
        List<Product> paginatedList = listProduct.subList(startIndex, endIndex);
        
        request.setAttribute("pageCount", pageCount);
        request.setAttribute("listProduct", paginatedList);
        request.setAttribute("currentPage", page);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
