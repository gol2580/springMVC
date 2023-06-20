package MVC.servlet.web.fronController.v3.controller;

import MVC.servlet.domain.member.Member;
import MVC.servlet.domain.member.MemberRepository;
import MVC.servlet.web.fronController.ModelView;
import MVC.servlet.web.fronController.v3.ControllerV3;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {
    MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public ModelView process(Map<String, String> paramMap) {
        //paramMap에 필요한 데이터 다 담아옴
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));
        Member member = new Member(username,age);
        memberRepository.save(member);

        ModelView mv = new ModelView("save-reuslt");
        mv.getModel().put("member",member);
        return mv;
    }
}
