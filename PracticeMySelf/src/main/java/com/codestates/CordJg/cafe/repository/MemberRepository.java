package com.codestates.CordJg.cafe.repository;

import com.codestates.CordJg.cafe.member.entity.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, Long> {

    Optional<Member> findByEmail(String email);
}
