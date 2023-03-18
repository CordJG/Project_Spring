package com.codestates.PracticeMySelf.member.mapper;

import com.codestates.PracticeMySelf.member.dto.MemberPatchDto;
import com.codestates.PracticeMySelf.member.dto.MemberPostDto;
import com.codestates.PracticeMySelf.member.dto.MemberResponseDto;
import com.codestates.PracticeMySelf.member.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtoToMember(MemberPostDto memberPostDto);
    Member memberPatchDtoToMember(MemberPatchDto memberPatchDto);

    MemberResponseDto memberToMemberResponseDto(Member member);
}
