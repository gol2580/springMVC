package MVC.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="helloServlet", urlPatterns = "/hello")
public class helloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //HTTP request, response 가져오기
        System.out.println("req = " + req);
        System.out.println("resp = " + resp);
        //queryParam 가져오기
        String username = req.getParameter("username");
        System.out.println("username = " + username);

        //HTTPresponse의 header에 들어감
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
        //HTTPresponse의 body에 들어감
        resp.getWriter().write("hello");
    }
}
