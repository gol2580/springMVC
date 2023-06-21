package MVC.servlet.web.fronController.v2;

import MVC.servlet.web.fronController.MyView;
import MVC.servlet.web.fronController.v2.controller.MemberFormControllerV2;
import MVC.servlet.web.fronController.v2.controller.MemberListControllerV2;
import MVC.servlet.web.fronController.v2.controller.MemberSaveControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

    private Map<String, ControllerV2> controllerMap = new HashMap<>();

    public FrontControllerServletV2() {
        controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //요청된 uri를 받아 저장
        String requestURI = request.getRequestURI();
        //Map+생성자
        //key : /front-controller/v2/members  values : MemberListControllerV1 객체
        //인터페이스이자 부모인 ControllerV1으로 받음 -> 다형성 활용
        ControllerV2 controller = controllerMap.get(requestURI);

        //예외처리 : 없는 경우
        if(controller==null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //실제로 호출할 컨트롤러 실행
        MyView view = controller.process(request, response);
        view.render(request,response);
    }
}
