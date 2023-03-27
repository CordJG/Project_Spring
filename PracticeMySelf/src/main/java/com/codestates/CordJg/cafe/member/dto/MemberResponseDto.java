package com.codestates.CordJg.cafe.member.dto;

import com.codestates.CordJg.cafe.member.status.MemberStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class MemberResponseDto {
    private long memberId;
    private String email;
    private String name;
    private String phone;
    private MemberStatus status;

}
