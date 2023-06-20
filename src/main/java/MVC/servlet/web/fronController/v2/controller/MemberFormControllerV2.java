package MVC.servlet.web.fronController.v2.controller;

import MVC.servlet.web.fronController.MyView;
import MVC.servlet.web.fronController.v2.ControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberFormControllerV2 implements ControllerV2 {
    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //V1에 비해 중복제거 : MyView 객체에 경로만 넣어서 반환하면 됨!
        return new MyView("/WEB-INF/views/new-form.jsp");
    }
}
