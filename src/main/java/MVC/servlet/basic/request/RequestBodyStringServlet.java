package MVC.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name="RequestBodyStringServlet", urlPatterns="/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream(); //메시지 내용을 byte code로 받아냄
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);//변환할 byte와 encoding정보 -> String으로 변환

        System.out.println("messageBody = " + messageBody);
        response.getWriter().write("ok");
    }
}
