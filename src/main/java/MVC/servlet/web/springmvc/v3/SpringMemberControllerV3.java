package MVC.servlet.web.springmvc.v3;

import MVC.servlet.domain.member.Member;
import MVC.servlet.domain.member.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    //POST로 요청온 것만 매핑됨
    //@RequestMapping(value="/new-form", method= RequestMethod.GET)
    @GetMapping("/new-form")
    public String newForm() {
        //논리뷰 이름을 넣은 ModelAndView -> viewResolver가 처리
        return "new-form";
    }

    @RequestMapping(method= RequestMethod.GET)
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members",members);
        return "members";
    }

    @RequestMapping(value="/save",method= RequestMethod.POST)
    public String save(
            @RequestParam("username") String username,
            @RequestParam("age") int age,
            Model model) {
        //paramMap에 필요한 데이터 다 담아옴
        Member member = new Member(username,age);
        memberRepository.save(member);

        model.addAttribute("member",member);
        return "save-result";
    }

}
