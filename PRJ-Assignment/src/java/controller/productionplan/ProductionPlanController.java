package controller.productionplan;

import controller.auth.BaseRBACController;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model.Products;
import dal.ProductsDBContext;
import dal.ProductionPlanDBContext;
import model.auth.PPlan;
import model.auth.User;

/**
 *
 * @author Admin
 */
public class ProductionPlanController extends BaseRBACController {

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp, User account) throws ServletException, IOException {

        ProductsDBContext db = new ProductsDBContext();
        ArrayList<Products> pl = db.list();
        
        req.setAttribute("pl", pl);

        ProductionPlanDBContext dbpp = new ProductionPlanDBContext();
        ArrayList<PPlan> ppl = dbpp.list();
        req.setAttribute("ppl", ppl);
        
        req.getRequestDispatcher("../view/plan/production-plan.jsp").forward(req, resp);
    }

    @Override
    protected void doAuthorizedGet(HttpServletRequest req, HttpServletResponse resp, User account) throws ServletException, IOException {
        processRequest(req, resp, account);
    }

    @Override
    protected void doAuthorizedPost(HttpServletRequest req, HttpServletResponse resp, User account) throws ServletException, IOException {
        processRequest(req, resp, account);
    }

}
