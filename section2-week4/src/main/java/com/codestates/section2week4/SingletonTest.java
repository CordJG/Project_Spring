package com.codestates.section2week4;

import com.codestates.section2week4.member.MemberRepository;
import com.codestates.section2week4.member.MemberService;
import com.codestates.section2week4.member.MemberTest;
import com.codestates.section2week4.singleton.SingletonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    static AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(DependencyConfig.class);
    //static SingletonService singletonService1 = SingletonService.getInstance();
    static MemberService memberService1 = ac.getBean("memberService", MemberService.class);
    static MemberService memberService2 = ac.getBean("memberService", MemberService.class);
    //static SingletonService singletonService2 = SingletonService.getInstance();

    public static void main(String[] args) {
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 : " + memberService2);
    }
}
