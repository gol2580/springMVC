package MVC.servlet.web.fronController;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Setter @Getter
public class ModelView {
    private String viewName;
    private Map<String, Object> model = new HashMap<>();

    public ModelView(String viewName) {this.viewName=viewName;}

    public String getViewName() {
        return viewName;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }
}
