package com.gym.controller;

import com.gym.model.Member;
import com.gym.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
@CrossOrigin(origins = "http://localhost:3000")
public class MemberController {

    @Autowired
    private MemberService service;

    // ✅ Add Member
    @PostMapping
    public Member addMember(@RequestBody Member member) {
        return service.saveMember(member);
    }

    // ✅ Get All Members
    @GetMapping
    public List<Member> getMembers() {
        return service.getMembers();
    }

    // ✅ Update Member
    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Long id, @RequestBody Member member) {
        member.setId(id);
        return service.saveMember(member);
    }

    // ✅ Delete Member
    @DeleteMapping("/{id}")
    public String deleteMember(@PathVariable Long id) {
        service.deleteMember(id);
        return "Member deleted successfully";
    }
}
