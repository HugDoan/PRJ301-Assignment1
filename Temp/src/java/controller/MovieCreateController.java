
import dal.MovieDBContextImpl;
import dal.CategoryDBContext;
import model.movie;
import model.category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet()
public class MovieCreateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve category list and forward to create.jsp form
        CategoryDBContext dbC = new CategoryDBContext();
        ArrayList<category> cts = dbC.list();
        request.setAttribute("cts", cts);
        request.getRequestDispatcher("../movie/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Process form data from the user and insert movie into the database
        String raw_title = request.getParameter("title");
        String raw_date = request.getParameter("releaseddate");
        String raw_adultonly = request.getParameter("adultonly");
        String raw_cname = request.getParameter("cname");

        // Object binding and data validation
        movie m = new movie();
        m.setMtitle(raw_title);

        // Handling boolean adult check field
        boolean adultOnly = raw_adultonly != null && raw_adultonly.equalsIgnoreCase("yes");
        m.setAdultcheck(adultOnly);

        // Parse the release date string to java.sql.Date
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date releaseDate = sdf.parse(raw_date);
            m.setDate(new java.sql.Date(releaseDate.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
            // Handle error: set error message, return to form, etc.
            request.setAttribute("error", "Invalid date format");
            request.getRequestDispatcher("../movie/create.jsp").forward(request, response);
            return;
        }

        // Setting the category object
        category c = new category();
        c.setName(raw_cname);  // Assuming category name is entered; ideally, this should be selected by ID.
        m.setCate(c);

        // Save movie data into the database
        MovieDBContextImpl db = new MovieDBContextImpl();
        db.insert(m);

        // Respond to user (you can also redirect to a success page)
        response.getWriter().println("Movie created successfully!");
    }
}

