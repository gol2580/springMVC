package MVC.servlet.web.fronController.v4.controller;

import MVC.servlet.web.fronController.ModelView;
import MVC.servlet.web.fronController.v3.ControllerV3;
import MVC.servlet.web.fronController.v4.ControllerV4;

import java.util.Map;

public class MemberFormControllerV4 implements ControllerV4 {

    //model이 아닌 view의 논리이름만 반환
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        return "new-form";
    }
}
