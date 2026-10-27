import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class DateTime extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy h:mm:ss a");
        String now = fmt.format(new Date());

        out.println("<h2>Current Date & Time: "+now+"</h2>");
        out.close();
    }
}