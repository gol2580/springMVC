package MVC.servlet.web.fronController.v5;

import MVC.servlet.web.fronController.ModelView;
import MVC.servlet.web.fronController.MyView;
import MVC.servlet.web.fronController.v3.ControllerV3;
import MVC.servlet.web.fronController.v3.controller.MemberFormControllerV3;
import MVC.servlet.web.fronController.v3.controller.MemberListControllerV3;
import MVC.servlet.web.fronController.v3.controller.MemberSaveControllerV3;
import MVC.servlet.web.fronController.v5.adapter.ControllerV3HandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name="frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {

    //private Map<String, ControllerV4> controllerMap = new HashMap<>();
    //특정 controller가 아닌 확장성 있게 받을 수 있도록 Object타입 사용
    private final Map<String,Object> handlerMappingMap = new HashMap<>();
    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontControllerServletV5() {
        initHandlerMappingMap();
        initHandlerAdapters();
    }

    private void initHandlerAdapters() {
        handlerAdapters.add(new ControllerV3HandlerAdapter());
    }

    private void initHandlerMappingMap() {
        handlerMappingMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. request -> 핸들러 찾아옴
        // MemberFormControllerV3
        Object handler = getHandler(request);
        if(handler==null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // 2. 핸들러 -> 핸들러 어댑터 찾아옴
        MyHandlerAdapter adapter = getHandlerAdapter(handler);
        // 3. 핸들러 어댑터 -> 핸들(컨트롤러 호출)
        ModelView mv = adapter.handle(request, response, handler);


        String viewName = mv.getViewName();
        MyView view = viewResolver(viewName);

        view.render(mv.getModel(),request,response);
    }

    private MyHandlerAdapter getHandlerAdapter(Object handler) {
        //MemberFormControllerV3
        for(MyHandlerAdapter adapter : handlerAdapters ) {
            if(adapter.supports(handler)) {
                return adapter;
            }
        }
        throw new IllegalArgumentException("handler adapter를 찾을 수 없습니다.");
    }

    private Object getHandler(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        Object handler = handlerMappingMap.get(requestURI);
        return handler;
    }

    private MyView viewResolver(String viewName) {
        return new MyView("WEB-INF/views/" + viewName+".jsp");
    }
}
