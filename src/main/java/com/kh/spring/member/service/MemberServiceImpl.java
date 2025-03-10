package com.kh.spring.member.service;

import com.kh.spring.member.model.vo.Member;
import com.kh.spring.mappers.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper; // MemberMapper를 주입받음

    // 로그인 처리
    @Override
    @Transactional
    public Member loginMember(Member m) {
        return memberMapper.loginMember(m.getUserId()); // 로그인 메서드는 userId만 필요
    }

    // 아이디 중복 체크
    @Override
    @Transactional
    public int idCheck(String checkId) {
        return memberMapper.idCheck(checkId);
    }

    // 회원가입 처리
    @Override
    @Transactional
    public int insertMember(Member m) {
        System.out.println("m : " + m);
        return memberMapper.insertMember(m);
    }

    // 회원정보 수정 처리
    @Override
    @Transactional
    public int updateMember(Member m) {
        return memberMapper.updateMember(m);
    }

    // 회원 탈퇴 처리
    @Override
    @Transactional
    public int deleteMember(String userId) {
        return memberMapper.deleteMember(userId);
    }
}
