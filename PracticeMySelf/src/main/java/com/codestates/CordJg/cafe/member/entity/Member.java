package com.codestates.CordJg.cafe.member.entity;


import com.codestates.CordJg.cafe.member.status.MemberStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Member {
    @Id
    private long memberId;
    private String email;
    private String name;
    private String phone;

    private MemberStatus status;



}
