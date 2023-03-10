package com.codestates.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v2/members")
public class MemberController {
    @PostMapping
    public ResponseEntity postMember(@RequestParam(value="email", required = false) String email,
                                     @RequestParam(value="name" , required = false) String name,
                                     @RequestParam(value="phone", required = false) String phone) {

        Map<String, String> map = new HashMap<>();
        map.put("email", "wjrmffldglem@gmail.com");
        map.put("name", name);
        map.put("phone", phone);

        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") long memberId) {
        System.out.println("# memberId: " + memberId);

        // not implementation
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMembers() {
        System.out.println("# get Members");

        // not implmentation
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
