package MVC.servlet.web.fronController.v3.controller;

import MVC.servlet.web.fronController.ModelView;
import MVC.servlet.web.fronController.v3.ControllerV3;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {
    @Override
    public ModelView process(Map<String, String> paramMap) {
        //전체 경로가 아닌 논리적 이름만 넣음
        return new ModelView("new-form");
    }
}
