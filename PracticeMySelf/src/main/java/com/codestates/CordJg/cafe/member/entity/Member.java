package com.codestates.CordJg.cafe.member.entity;


import com.codestates.CordJg.cafe.member.status.MemberStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue
    private long memberId;
    private String email;
    private String name;
    private String phone;

    private MemberStatus status;

    public Member(String email) {
        this.email = email;
    }



}
