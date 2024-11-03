///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package dal;
//
//import java.util.ArrayList;
//import model.ProductionPlan;
//import model.ProductionPlanHeader;
//
///**
// *
// * @author Admin
// */
//public class Test {
//
//
//    public static void main(String[] args) {
//        // Khởi tạo đối tượng ProductionPlanDBContext
//        ProductionPlanDBContext dbContext = new ProductionPlanDBContext();
//
//        // Gọi phương thức list() để lấy danh sách kế hoạch sản xuất
//        ArrayList<ProductionPlan> plans = dbContext.list();
//        
//        ProductionPlanHeaderDBContext dbContextHeader = new ProductionPlanHeaderDBContext();
//        ArrayList<ProductionPlanHeader> header = dbContextHeader.list();
//        
//
//        // Kiểm tra dữ liệu lấy được từ database
//        if (plans.isEmpty()) {
////            System.out.println("No plans retrieved.");
////        } else {
////            System.out.println("Total plans retrieved: " + plans.size());
////            for (ProductionPlan plan : plans) {
////                System.out.println("Plan ID: " + plan.getId() + ", Name: " + plan.getName()
////                        + ", Start Date: " + plan.getStart() + ", End Date: " + plan.getEnd());
////                for (ProductionPlanHeader header : plan.getHeaders()) {
////                    System.out.println("   Product Name: " + header.getProduct().getName()
////                            + ", Quantity: " + header.getQuantity()
////                            + ", Estimated Effort: " + header.getEstimatedeffort());
////                }
////            }
//System.out.println("Product in header: " + header..getName());
//        }
//    
//}
//
//}
