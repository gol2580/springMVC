package MVC.servlet.web.fronController.v3;

import MVC.servlet.web.fronController.ModelView;

import java.util.Map;

public interface ControllerV3 {

    //servlet에 종속X / 직접 만든 프레임워크에 종속됨
    ModelView process(Map<String, String> paramMap);
}
