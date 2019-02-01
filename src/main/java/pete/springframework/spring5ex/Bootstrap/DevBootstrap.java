package pete.springframework.spring5ex.Bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pete.springframework.spring5ex.Model.Crue;
import pete.springframework.spring5ex.Model.Member;
import pete.springframework.spring5ex.Repositories.CrueRepository;
import pete.springframework.spring5ex.Repositories.MemberRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    MemberRepository memberRepository;
    CrueRepository crueRepository;

    public DevBootstrap(MemberRepository memberRepository, CrueRepository crueRepository) {
        this.memberRepository = memberRepository;
        this.crueRepository = crueRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        //Rock 'N'Roll
        Crue rock = new Crue("ILoveRock", "Music", true);
        Member slash = new Member("Saul", "Hudson", 53);
        //rock.getMembers().add(slash);
        slash.getCrues().add(rock);

        crueRepository.save(rock);
        memberRepository.save(slash);


        //Way of the peaceful Warrior
        Crue peacefulWarriors = new Crue("Way of the peaceful warrior", "Movie/Book", false);
        Member danMillman = new Member("Dan", "Millman", 60);
        peacefulWarriors.getMembers().add(danMillman);

        crueRepository.save(peacefulWarriors);
        memberRepository.save(danMillman);



    }
}
