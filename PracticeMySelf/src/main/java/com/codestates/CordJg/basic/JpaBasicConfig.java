package com.codestates.CordJg.basic;

import com.codestates.CordJg.cafe.member.entity.Member;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Configuration
public class JpaBasicConfig {
    private EntityManager em;

    @Bean
    public CommandLineRunner testJpaBasicRunner(EntityManagerFactory emFactory) {
        this.em = emFactory.createEntityManager();

        return args -> {
            example01();
        };
    }

    private void example01() {
        Member member = new Member("wjrmffldglem@gmail.com");

        em.persist(member);

        Member resultMember = em.find(Member.class, 1L);
        System.out.println("Id: " +resultMember.getMemberId() + ", email: "+
                resultMember.getEmail());
    }
}
