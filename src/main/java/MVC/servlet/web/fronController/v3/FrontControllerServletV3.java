package MVC.servlet.web.fronController.v3;

import MVC.servlet.web.fronController.ModelView;
import MVC.servlet.web.fronController.MyView;

import MVC.servlet.web.fronController.v3.controller.MemberFormControllerV3;
import MVC.servlet.web.fronController.v3.controller.MemberListControllerV3;
import MVC.servlet.web.fronController.v3.controller.MemberSaveControllerV3;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerMap = new HashMap<>();

    public FrontControllerServletV3() {
        controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //요청된 uri를 받아 저장
        String requestURI = request.getRequestURI();
        //Map+생성자
        //key : /front-controller/v2/members  values : MemberListControllerV1 객체
        //인터페이스이자 부모인 ControllerV1으로 받음 -> 다형성 활용
        ControllerV3 controller = controllerMap.get(requestURI);

        //예외처리 : 없는 경우
        if(controller==null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //HTTP request parameter들을 Map으로 변환
        Map<String, String> paramMap = createParamMap(request);
        //논리뷰 경로 얻어옴
        ModelView mv = controller.process(paramMap);

        String viewName = mv.getViewName();
        MyView view = viewResolver(viewName);

        view.render(mv.getModel(),request,response);
    }

    // 논리뷰 -> 실제 물리뷰 MyView 객체
    private MyView viewResolver(String viewName) {
        return new MyView("WEB-INF/views/" + viewName+".jsp");
    }

    // HTTPServletRequest에서 param을 꺼내 Map으로 변환하는 메소드
    private Map<String,String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName ->
                        paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
