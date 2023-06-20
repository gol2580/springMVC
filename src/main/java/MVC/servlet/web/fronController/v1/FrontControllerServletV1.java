package MVC.servlet.web.fronController.v1;

import MVC.servlet.web.fronController.v1.controller.MemberFormControllerV1;
import MVC.servlet.web.fronController.v1.controller.MemberListControllerV1;
import MVC.servlet.web.fronController.v1.controller.MemberSaveControllerV1;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

    private Map<String, ControllerV1> controllerMap = new HashMap<>();

    public FrontControllerServletV1() {
        controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //요청된 uri를 받아 저장
        String requestURI = request.getRequestURI();
        //Map+생성자
        //key : /front-controller/v1/members  values : MemberListControllerV1 객체
        //인터페이스이자 부모인 ControllerV1으로 받음 -> 다형성 활용
        ControllerV1 controller = controllerMap.get(requestURI);

        //예외처리 : 없는 경우
        if(controller==null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //실제로 호출할 컨트롤러 실행
        controller.process(request,response);
    }
}
