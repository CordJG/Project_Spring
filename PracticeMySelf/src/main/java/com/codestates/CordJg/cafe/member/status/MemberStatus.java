package com.codestates.CordJg.cafe.member.status;

import lombok.Getter;
@Getter
public enum MemberStatus {
    활동중(1),휴면(2),탈퇴(3);

    @Getter
    private int statusNum;

    MemberStatus(int statusNum) {
        this.statusNum = statusNum;

    }
}
