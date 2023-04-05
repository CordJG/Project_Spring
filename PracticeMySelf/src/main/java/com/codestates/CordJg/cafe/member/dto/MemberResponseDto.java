package com.codestates.CordJg.cafe.member.dto;

import com.codestates.CordJg.cafe.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class MemberResponseDto {
    private long memberId;
    private String email;
    private String name;
    private String phone;
    private Member.MemberStatus status;

    public long getMemberStatus() {
        return status.getStatusNum();
    }

}
