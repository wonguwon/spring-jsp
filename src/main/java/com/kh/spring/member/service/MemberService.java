package com.kh.spring.member.service;

import com.kh.spring.member.model.vo.Member;

public interface MemberService {

    // 로그인
    Member loginMember(Member m);

    // id 중복 체크
    int idCheck(String checkId);

    // 회원가입
    int insertMember(Member m);

    // 회원정보 수정
    int updateMember(Member m);

    // 회원 탈퇴
    int deleteMember(String userId);
}
