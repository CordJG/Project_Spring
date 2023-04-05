package com.codestates.CordJg.cafe.member.service;

import com.codestates.CordJg.cafe.exception.BusinessLogicException;
import com.codestates.CordJg.cafe.exception.ExceptionCode;
import com.codestates.CordJg.cafe.member.entity.Member;
import com.codestates.CordJg.cafe.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //DTO 클래스는 API 계층에서만 데이터를 처리하는 역할을 하고 Entity 클래스는 서비스 계층에서만 데이터를 처리하는 역할을 해야 한다.
    public Member createMember(Member member) {
        verifyExistsEmail(member.getEmail());

        member.setStatus(Member.MemberStatus.활동중);

        return memberRepository.save(member);
    }

    public Member updateMember(Member member) {
        Member findMember = findVerifiedMember(member.getMemberId());

        Optional.ofNullable(member.getName())
                .ifPresent(name -> findMember.setName(name));
        Optional.ofNullable(member.getPhone())
                .ifPresent(phone -> findMember.setPhone(phone));
        Optional.ofNullable(member.getStatus())
                .ifPresent(memberStatus -> findMember.setStatus(memberStatus));

        findMember.setModifiedAt(LocalDateTime.now());


        return memberRepository.save(findMember);
    }

    public Member findMember(long memberId) {

        return findVerifiedMember(memberId);
    }

    public Page<Member> findMembers(int page, int size) {

        return memberRepository.findAll(PageRequest.of(page, size, Sort.by("memberId").descending()));
    }

    public Member deleteMember(long memberId) {

        Member findMember = findVerifiedMember(memberId);

        if(findMember.getStatus().getStatusNum()!=3 ){

            findMember.setStatus(Member.MemberStatus.탈퇴);
        }

        return memberRepository.save(findMember);
    }

    public Member findVerifiedMember(long memberId) {
        Optional<Member> optionalMember =
                memberRepository.findById(memberId);
        Member findMember =
                optionalMember.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        return findMember;
    }

    private void verifyExistsEmail(String email) {
        Optional<Member> member = memberRepository.findByEmail(email);
        if (member.isPresent())
            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);

    }
}
