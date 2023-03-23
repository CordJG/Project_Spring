package com.codestates.CordJg.cafe.member.service;

import com.codestates.CordJg.cafe.exception.BusinessLogicException;
import com.codestates.CordJg.cafe.exception.ExceptionCode;
import com.codestates.CordJg.cafe.member.entity.Member;
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

        throw new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND);
    }

    public List<Member> findMembers() {

        List<Member> members = List.of(
                new Member()
        );
        return members;
    }

    public void deleteMember(long memberId) {

        throw new BusinessLogicException(ExceptionCode.INTERNAL_SERVER_ERROR);

    }
}
