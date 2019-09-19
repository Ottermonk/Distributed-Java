import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "DBServlet", urlPatterns = "/search")
public class DBServlet extends HttpServlet {
    private final String DRIVER_NAME = "jdbc:derby:";
    private final String DATABASE_PATH = "/WEB-INF/lib/DuehrDB";
    private final String USERNAME = "Ottermonk";
    private final String PASSWORD = "Pokemon1";

    // Comment

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Declare outside the try/catch so the variables are in scope in the finally block
        String results = request.getParameter("results");

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;

        try {
            // Load the driver
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            // Find the absolute path of the database folder
            String absPath = getServletContext().getRealPath(DATABASE_PATH);

            StringBuilder sql = new StringBuilder("select CUSTOMER_NM, PRODUCT_NM, CUSTOMERORDER.ORDER_ID, QUANTITY ");
            sql.append("from CUSTOMER, CUSTOMERORDER, PRODUCT, PRODUCTORDER ");
            sql.append("where customerOrder.customer_id = customer.customer_id and ");
            sql.append("productOrder.product_id = product.product_id and ");
            sql.append("customerOrder.order_id = ProductOrder.order_id and ");
            sql.append("customerOrder.order_Id = ? ");
            sql.append("order by customer_nm, customerOrder.order_id "); // Don't end SQL with semicolon!

            // Create a connection
            conn = DriverManager.getConnection(DRIVER_NAME + absPath, USERNAME, PASSWORD);
            // Create a statement to execute SQL
            stmt = conn.prepareStatement(sql.toString());
            stmt.setInt(1, Integer.parseInt(results));
            // Execute a SELECT query and get a result set
            rset = stmt.executeQuery();

            // Create a StringBuilder for ease of appending strings
            StringBuilder output = new StringBuilder();

            // HTML to create a simple web page
            output.append("<html><body><ul>");

            // Loop while the result set has more rows
            while (rset.next()) {
                // Get the first string (the pet name) from each record
                String customer_nm = rset.getString(1);
                String product_nm = rset.getString(2);
                int order_id = rset.getInt(3);
                int quantity = rset.getInt(4);
                // Append it as a list item
                output.append("<li>").append(customer_nm + ": " + product_nm + ": " + order_id + ": " + quantity).append("</li>");
            }
            // Close all those opening tags
            output.append("</ul></body></html>");

            // Send the HTML as the response
            response.getWriter().print(output.toString());

        } catch (SQLException | ClassNotFoundException e) {
            // If there's an exception locating the driver, send IT as the response
            response.getWriter().print(e.getMessage());
            e.printStackTrace();
        } finally {
            if (rset != null) {
                try {
                    rset.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}