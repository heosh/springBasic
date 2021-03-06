package hello.core;

import hello.core.member.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
        //MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());

        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();
        /*
        AppConfig class에 있는 Bean들을 스프링 컨테이너에서 다 관리해줌
        */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member=" + member.getName());
        System.out.println("find member=" + findMember.getName());

    }
}
