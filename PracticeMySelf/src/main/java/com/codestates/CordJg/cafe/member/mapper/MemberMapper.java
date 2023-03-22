package com.codestates.CordJg.cafe.member.mapper;

import com.codestates.CordJg.cafe.member.dto.MemberPatchDto;
import com.codestates.CordJg.cafe.member.dto.MemberPostDto;
import com.codestates.CordJg.cafe.member.dto.MemberResponseDto;
import com.codestates.CordJg.cafe.member.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtoToMember(MemberPostDto memberPostDto);
    Member memberPatchDtoToMember(MemberPatchDto memberPatchDto);

    MemberResponseDto memberToMemberResponseDto(Member member);
}
