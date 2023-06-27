package MVC.servlet.web.fronController;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

//JSP경로로 렌더링 하는 과정을 따로 분리
//Controller -> JSP : X
//Controller -> MyView -> JSP : O
public class MyView {

    private String viewPath;
    //컨트롤러쪽에서 MyView 생성 시 viewPath를 이미 주입함
    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }

    // 주입 받았던 viewPath로 렌더링
    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);
    }
    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getModelToRequestAttribute(model, request);
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);
    }

    private void getModelToRequestAttribute(Map<String, Object> model, HttpServletRequest request) {
        model.forEach((key, value)-> request.setAttribute(key,value));
    }
}
