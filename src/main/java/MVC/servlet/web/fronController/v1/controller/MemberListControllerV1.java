package MVC.servlet.web.fronController.v1.controller;

import MVC.servlet.domain.member.Member;
import MVC.servlet.domain.member.MemberRepository;
import MVC.servlet.web.fronController.v1.ControllerV1;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class MemberListControllerV1 implements ControllerV1 {
    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> memberList = memberRepository.findAll();

        //model에 담기
        //request.setAttribute(key, value)
        request.setAttribute("members",memberList);
        String viewPath = "/WEB-INF/views/members.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);
    }
}
