package com.codestates.CordJg.cafe.member.mapper;

import com.codestates.CordJg.cafe.member.dto.MemberPatchDto;
import com.codestates.CordJg.cafe.member.dto.MemberPostDto;
import com.codestates.CordJg.cafe.member.dto.MemberResponseDto;
import com.codestates.CordJg.cafe.member.entity.Member;
import com.codestates.CordJg.cafe.member.status.MemberStatus;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-28T22:07:12+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.17 (Azul Systems, Inc.)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member memberPostDtoToMember(MemberPostDto memberPostDto) {
        if ( memberPostDto == null ) {
            return null;
        }

        Member member = new Member();

        member.setEmail( memberPostDto.getEmail() );
        member.setName( memberPostDto.getName() );
        member.setPhone( memberPostDto.getPhone() );

        return member;
    }

    @Override
    public Member memberPatchDtoToMember(MemberPatchDto memberPatchDto) {
        if ( memberPatchDto == null ) {
            return null;
        }

        Member member = new Member();

        member.setMemberId( memberPatchDto.getMemberId() );
        member.setName( memberPatchDto.getName() );
        member.setPhone( memberPatchDto.getPhone() );

        return member;
    }

    @Override
    public MemberResponseDto memberToMemberResponseDto(Member member) {
        if ( member == null ) {
            return null;
        }

        long memberId = 0L;
        String email = null;
        String name = null;
        String phone = null;
        MemberStatus status = null;

        memberId = member.getMemberId();
        email = member.getEmail();
        name = member.getName();
        phone = member.getPhone();
        status = member.getStatus();

        MemberResponseDto memberResponseDto = new MemberResponseDto( memberId, email, name, phone, status );

        return memberResponseDto;
    }
}
