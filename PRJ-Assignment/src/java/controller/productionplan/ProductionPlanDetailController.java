package controller.productionplan;

import controller.auth.BaseRBACController;
import dal.ProductDBContext;
import dal.ProductionPlanDBContext;
import dal.ProductionPlanDetailDBContext;
import dal.ShiftDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ProductionPlan;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import model.Product;
import model.ProductionPlanDetail;
import model.ProductionPlanHeader;
import model.Shift;
import model.auth.User;

/**
 *
 * @author Admin
 */
public class ProductionPlanDetailController extends BaseRBACController {

    @Override
    protected void doAuthorizedPost(HttpServletRequest request, HttpServletResponse response, User account) throws ServletException, IOException {
        String[] dates = request.getParameterValues("date");
        ProductionPlanDetailDBContext dbDetail = new ProductionPlanDetailDBContext();
        for (String d : dates) {

            String[] hids = request.getParameterValues("hid" + d);
            String[] sids = request.getParameterValues("sid" + d);
            for (String s : sids) {
                for (String h : hids) {

                    String raw_quantity = request.getParameter("quantity" + h + s + d);
                    if (raw_quantity != null && !raw_quantity.isEmpty()) {
                        ProductionPlanDetail detail = new ProductionPlanDetail();
                        int hid = Integer.parseInt(h);
                        Date date = Date.valueOf(d);
                        int sid = Integer.parseInt(s);
                        int quantity = Integer.parseInt(raw_quantity);
                        detail.setSid(sid);

                        ProductionPlanHeader header = new ProductionPlanHeader();
                        header.setId(hid);
                        detail.setHeader(header);
                        detail.setDate(date);
                        detail.setQuantity(quantity);
                        dbDetail.insert(detail);
                    }

                }
            }
        }
        response.sendRedirect("list");

    }

    @Override
    protected void doAuthorizedGet(HttpServletRequest request, HttpServletResponse response, User account) throws ServletException, IOException {
        int plid = Integer.parseInt(request.getParameter("plid"));
        ProductionPlan plan = new ProductionPlan();

        ProductionPlanDBContext dbPlan = new ProductionPlanDBContext();
        plan = dbPlan.get(plid);
        ArrayList<java.sql.Date> datePlan = new ArrayList<>();
        java.sql.Date start = plan.getStart();
        java.sql.Date end = plan.getEnd();
        Calendar calendar = Calendar.getInstance();

        while (!start.after(end)) {
            datePlan.add(new java.sql.Date(start.getTime())); // Thêm một bản sao của start vào danh sách
            calendar.setTime(start);                          // Đặt thời gian của calendar bằng start
            calendar.add(Calendar.DATE, 1);                   // Tăng thêm 1 ngày
            start = new java.sql.Date(calendar.getTimeInMillis()); // Cập nhật lại giá trị cho start
        }

        ArrayList<Shift> shifts = new ArrayList<>();
        ShiftDBContext dbShift = new ShiftDBContext();
        shifts = dbShift.list();

        ArrayList<ProductionPlanDetail> details = new ArrayList<>();
        ProductionPlanDetailDBContext dbDetail = new ProductionPlanDetailDBContext();
        details = dbDetail.list();

        request.setAttribute("details", details);
        request.setAttribute("shifts", shifts);
        request.setAttribute("datePlan", datePlan);

        request.setAttribute("plan", plan);
        request.getRequestDispatcher("../view/productionplan/listdetail.jsp").forward(request, response);
    }
}
