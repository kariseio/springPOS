package com.example.springpos.service;

import com.example.springpos.RegisterRequest;
import com.example.springpos.dao.MemberDao;
import com.example.springpos.entity.Member;

public class MemberService {
    private MemberDao memberDao;

    public MemberService(MemberDao memberDao) {
        this.memberDao= memberDao;
    }

    public String regist(RegisterRequest req) throws Exception {
        Member member= memberDao.selectByEmail(req.getEmail());
        if (member != null) {
            throw new Exception("DuplicateMemberException");
        }
        Member newMember= new Member(req.getId(), req.getPassword(), req.getName(), req.getEmail());
        memberDao.insert(newMember);
        return newMember.getId();
    }

    public Member getMemberById(String id) {
        Member member = memberDao.selectById(id);

        return member;
    }

    public String getPassword(String id) {
        Member member = memberDao.selectById(id);

        if(member != null) {
            return member.getPassword();
        } else {
            return null;
        }
    }

    public void changePW(String id, String newPassword) {
        Member member = memberDao.selectById(id);
        if (member != null) {
            member.setPassword(newPassword);
            memberDao.update(member);
        } else {
            // 멤버를 찾을 수 없는 경우에 대한 처리
        }
    }
}
