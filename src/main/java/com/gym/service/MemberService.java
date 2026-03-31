package com.gym.service;

import com.gym.model.Member;
import com.gym.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository repository;

    // ✅ Save / Add Member with plan logic
    public Member saveMember(Member member) {

        LocalDate joinDate = member.getJoinDate();
        String plan = member.getPlan();

        LocalDate expiryDate = joinDate;

        // 🔥 Plan-based expiry calculation
        if (plan.equals("1 Month")) {
            expiryDate = joinDate.plusMonths(1);
        } else if (plan.equals("3 Months")) {
            expiryDate = joinDate.plusMonths(3);
        } else if (plan.equals("6 Months")) {
            expiryDate = joinDate.plusMonths(6);
        } else if (plan.equals("1 Year")) {
            expiryDate = joinDate.plusYears(1);
        }

        member.setExpiryDate(expiryDate);

        // 🔥 Status calculation
        if (expiryDate.isBefore(LocalDate.now())) {
            member.setStatus("EXPIRED");
        } else {
            member.setStatus("ACTIVE");
        }

        return repository.save(member);
    }

    // ✅ Get all members
    public List<Member> getMembers() {
        return repository.findAll();
    }

    // ✅ Delete member
    public void deleteMember(Long id) {
        repository.deleteById(id);
    }
}