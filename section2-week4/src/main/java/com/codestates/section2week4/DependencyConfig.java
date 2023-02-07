package com.codestates.section2week4;

import com.codestates.section2week4.coffee.CoffeeRepository;
import com.codestates.section2week4.coffee.CoffeeService;
import com.codestates.section2week4.member.MemberRepository;
import com.codestates.section2week4.member.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan  //Bean으로 직접 하나하나 넣어줄 필요 없이 component로 필요한 클래스를 지정하고 인터페이스같은 역할을 하는 임의의 클래스에 conponentScan을 지정해줘서 불러주면 된다.
public class DependencyConfig {
//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository());
//    }
//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemberRepository();
//    }
//    @Bean
//    public CoffeeService coffeeService() {
//        return new CoffeeService(coffeeRepository());
//    }
//    @Bean
//    public CoffeeRepository coffeeRepository() {
//        return new CoffeeRepository();
//    }
}
