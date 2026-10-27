import java.io.*;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class allStudents extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(System.getenv("DB_URL"),System.getenv("DB_USER"),System.getenv("DB_PASSWORD"));
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM student");
                        out.println("<table border='1' cellpadding='5'>");
            out.println("<tr><th>Enrollment</th><th>First Name</th><th>Last Name</th><th>Semester</th><th>Contact</th></tr>");

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getString("enrollment") + "</td>");
                out.println("<td>" + rs.getString("firstName") + "</td>");
                out.println("<td>" + rs.getString("lastName") + "</td>");
                out.println("<td>" + rs.getInt("semester") + "</td>");
                out.println("<td>" + rs.getString("contact") + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");

        }catch(Exception e){
            e.printStackTrace();
            res.getWriter().println(e);
        }
    }
}
