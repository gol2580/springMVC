package MVC.servlet.web.fronController.v1;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//servlet과 비슷한 모양의 컨트롤러 인터페이스
//-> 각 컨트롤러들이 이 인터페이스를 구현한다
//-> 로직의 일관성
public interface ControllerV1 {

    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
