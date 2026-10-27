import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class registration extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String enrollment = req.getParameter("enrollment");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        Integer semester = Integer.parseInt(req.getParameter("semester"));
        String contact = req.getParameter("contact");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(System.getenv("DB_URL"),System.getenv("DB_USER"),System.getenv("DB_PASSWORD"));
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO student VALUES (?, ?, ?, ?, ?)");
            pstmt.setString(1, enrollment);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setInt(4, semester);
            pstmt.setString(5, contact);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                res.getWriter().println("You are successfully registered");
            }
        }catch(Exception e){
            e.printStackTrace();
            res.getWriter().println(e);
        }

    }
}
