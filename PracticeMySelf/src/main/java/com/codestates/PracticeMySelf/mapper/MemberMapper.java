package com.codestates.PracticeMySelf.mapper;

import com.codestates.PracticeMySelf.dto.MemberPatchDto;
import com.codestates.PracticeMySelf.dto.MemberPostDto;
import com.codestates.PracticeMySelf.dto.MemberResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtoToMember(MemberPostDto memberPostDto);
    Member memberPatchDtoToMember(MemberPatchDto memberPatchDto);


    MemberResponseDto memberToMemberResponseDto(Member member);
}
