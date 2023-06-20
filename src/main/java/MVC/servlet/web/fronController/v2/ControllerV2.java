package MVC.servlet.web.fronController.v2;

import MVC.servlet.web.fronController.MyView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface ControllerV2 {

    //ControllerV1과 차이점 : MyView를 반환함
    MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
