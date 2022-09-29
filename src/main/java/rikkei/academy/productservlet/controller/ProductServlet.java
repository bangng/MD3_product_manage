package rikkei.academy.productservlet.controller;

import rikkei.academy.productservlet.model.Product;
import rikkei.academy.productservlet.service.IProductService;
import rikkei.academy.productservlet.service.ProductServiceIMPL;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(value = {"/", "/product"})
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductServiceIMPL();

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.findAll();
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
            case "delete":
                showFormDelete(request, response);
                break;


            default:
                showListProduct(request, response);
        }


    }

    private void showFormDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/delete.jsp");
        dispatcher.forward(request, response);
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
        dispatcher.forward(request, response);

    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                formCreatePro(request, response);
                break;
            case "edit":
                formEditPro(request, response);
                break;
            case "delete":
                formDeletePro(request, response);
                break;
            case "search":
                fromSearchByName(request,response);
                break;
        }

    }

    private void fromSearchByName(HttpServletRequest request, HttpServletResponse response) {

    }

    private void formDeletePro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.productService.deleteById(id);
        request.setAttribute("message", "Delete Ok");
        request.setAttribute("productList", this.productService.findAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(request, response);

    }

    private void formEditPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        String namePro = request.getParameter("namePro");
        float pricePro = Float.parseFloat(request.getParameter("pricePro"));
        String desPro = request.getParameter("desPro");
        String madePro = request.getParameter("madePro");
        product.setProName(namePro);
        product.setProPrice(pricePro);
        product.setDescription(desPro);
        product.setMade(madePro);
        request.setAttribute("message", "Edit success");
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
        dispatcher.forward(request, response);


    }

    private void formCreatePro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = productService.findAll().get(productService.findAll().size() - 1).getId() + 1;
        String name = request.getParameter("namePro");
        float price = Float.parseFloat(request.getParameter("pricePro"));
        String description = request.getParameter("desPro");
        String made = request.getParameter("madePro");
        Product product = new Product(id, name, price, description, made);
        productService.save(product);
        request.setAttribute("message", "Create success");
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        dispatcher.forward(request, response);


    }
}
