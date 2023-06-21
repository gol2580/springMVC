package MVC.servlet.web.fronController.v4.controller;

import MVC.servlet.domain.member.Member;
import MVC.servlet.domain.member.MemberRepository;

import MVC.servlet.web.fronController.v4.ControllerV4;

import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));
        Member member = new Member(username,age);
        memberRepository.save(member);

        //ModelView mv = new ModelView("save-reuslt");
        //mv.getModel().put("member",member);
        //return mv;
        //이 과정 전부 생략
        model.put("member",member);
        return "save-result";
    }
}
