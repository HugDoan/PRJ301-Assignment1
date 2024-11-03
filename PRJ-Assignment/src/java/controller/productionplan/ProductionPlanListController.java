
package controller.productionplan;

import dal.DepartmentDBContext;
import dal.EmployeeDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import dal.ProductionPlanHeaderDBContext;
import dal.ProductionPlanDBContext;
import model.ProductionPlanHeader;
import model.ProductionPlan;


public class ProductionPlanListController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductionPlanDBContext dbPlan= new ProductionPlanDBContext();
        ArrayList<ProductionPlan> plans= new ArrayList<>();
        plans= dbPlan.list();
        request.setAttribute("plans", plans);
        request.getRequestDispatcher("../view/productionplan/list.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
