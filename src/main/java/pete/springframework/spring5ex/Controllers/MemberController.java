package pete.springframework.spring5ex.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pete.springframework.spring5ex.Repositories.MemberRepository;

@Controller
public class MemberController {


    private MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @RequestMapping("/members")
    public String getMembers(Model model){
        model.addAttribute("members", memberRepository.findAll());

        return "members";
    }
}
