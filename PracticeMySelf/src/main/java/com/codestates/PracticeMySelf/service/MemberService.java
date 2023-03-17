package com.codestates.PracticeMySelf.service;

import com.codestates.PracticeMySelf.mapper.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    //DTO 클래스는 API 계층에서만 데이터를 처리하는 역할을 하고 Entity 클래스는 서비스 계층에서만 데이터를 처리하는 역할을 해야 한다.
    public Member createMember(Member member) {
        Member createdMember = member;
        return createdMember;
    }

    public Member updateMember(Member member) {
        Member updatedMember = member;
        return updatedMember;
    }

    public Member findMember(long memberId) {
        Member member = new Member(memberId, "wjrmffldglem@gmail.com", "이재관", "010-5029-7716");
        return member;
    }

    public List<Member> findMembers() {

        List<Member> members = List.of(
                new Member(1l, "wjrmffldglem@gmail.com", "이재관", "010-5029-7716"),
                new Member(2l, "wjrmffldgl@naver.com", "이재관2", "010-1234-5678")
        );
        return members;
    }

    public void deleteMember(long memberId) {

    }
}
