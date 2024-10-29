
package controller.productionplan;

import dal.DepartmentDBContext;
import dal.ProductDBContext;
import dal.ProductionPlanDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ProductionPlan;
import java.sql.*;
import model.Department;
import model.Product;
import model.ProductionPlanHeader;

/**
 *
 * @author sonnt-local hand-some
 */
public class ProductionPlanCreateController extends HttpServlet {
   
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        DepartmentDBContext dbDept = new DepartmentDBContext();
        ProductDBContext dbProduct = new ProductDBContext();
        
        request.setAttribute("depts", dbDept.get("Production"));
        request.setAttribute("products", dbProduct.list());
        
        request.getRequestDispatcher("../view/productionplan/create.jsp").forward(request, response);
    } 


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        ProductionPlan plan = new ProductionPlan();
        plan.setName(request.getParameter("name"));
        plan.setStart(Date.valueOf(request.getParameter("from")));
        plan.setEnd(Date.valueOf(request.getParameter("to")));
        
        Department d = new Department();
        d.setId(Integer.parseInt(request.getParameter("did")));
        
        plan.setDept(d);
        
        String[] pids = request.getParameterValues("pid");
        for (String pid : pids) {
            Product p = new Product();
            p.setId(Integer.parseInt(pid));
            
            ProductionPlanHeader header = new ProductionPlanHeader();
            header.setProduct(p);
            String raw_quantity = request.getParameter("quantity"+pid);
            String raw_effort = request.getParameter("effort"+pid);
            header.setQuantity(raw_quantity!=null && raw_quantity.length()>0?Integer.parseInt(raw_quantity):0);
            header.setEstimatedeffort(raw_effort!=null && raw_effort.length()>0?Float.parseFloat(raw_effort):0);
            
            if(header.getQuantity()>0&& header.getEstimatedeffort()>0)
                plan.getHeaders().add(header);
        }
        
        if(plan.getHeaders().size() >0)
        {
            ProductionPlanDBContext db = new ProductionPlanDBContext();
            db.insert(plan);
            response.getWriter().println("your plan has been added!");
        }
        else
        {
            response.getWriter().println("your plan does not have any headers! it is not allowed!");
        }
        
    }

   

}
