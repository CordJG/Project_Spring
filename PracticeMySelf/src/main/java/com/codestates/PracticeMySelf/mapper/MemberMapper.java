package com.codestates.PracticeMySelf.mapper;

import com.codestates.PracticeMySelf.dto.MemberPatchDto;
import com.codestates.PracticeMySelf.dto.MemberPostDto;
import com.codestates.PracticeMySelf.dto.MemberResponseDto;
import com.codestates.PracticeMySelf.model.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtoToMember(MemberPostDto memberPostDto);
    Member memberPatchDtoToMember(MemberPatchDto memberPatchDto);
    MemberResponseDto memberToMemberResponseDto(Member member);
}
