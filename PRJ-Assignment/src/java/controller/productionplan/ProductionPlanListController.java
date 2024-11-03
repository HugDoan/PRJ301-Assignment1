package controller.productionplan;

import controller.auth.BaseRBACController;
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
import model.auth.User;

public class ProductionPlanListController extends BaseRBACController {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response, User account)
            throws ServletException, IOException {
        ProductionPlanDBContext dbPlan = new ProductionPlanDBContext();
        ArrayList<ProductionPlan> plans = new ArrayList<>();
        plans = dbPlan.list();
        request.setAttribute("plans", plans);
        request.getRequestDispatcher("../view/productionplan/list.jsp").forward(request, response);
    }

    @Override
    protected void doAuthorizedPost(HttpServletRequest req, HttpServletResponse resp, User account) throws ServletException, IOException {
        processRequest(req, resp, account);
    }

    @Override
    protected void doAuthorizedGet(HttpServletRequest req, HttpServletResponse resp, User account) throws ServletException, IOException {
        processRequest(req, resp, account);
    }

}
