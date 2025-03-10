package com.kh.spring.mappers;

import com.kh.spring.member.model.vo.Member;
import org.apache.ibatis.annotations.*;

@Mapper
public interface MemberMapper {

    // 로그인
    @Select("""
        SELECT USER_ID, USER_PWD, USER_NAME, EMAIL, GENDER, AGE, PHONE, ADDRESS, 
               ENROLL_DATE, MODIFY_DATE, STATUS 
        FROM MEMBER 
        WHERE USER_ID = #{userId} 
        AND STATUS = 'Y'
    """)
    @Results(id = "memberResult", value = {
            @Result(column = "USER_ID", property = "userId"),
            @Result(column = "USER_PWD", property = "userPwd"),
            @Result(column = "USER_NAME", property = "userName"),
            @Result(column = "EMAIL", property = "email"),
            @Result(column = "AGE", property = "age"),
            @Result(column = "GENDER", property = "gender"),
            @Result(column = "PHONE", property = "phone"),
            @Result(column = "ADDRESS", property = "address"),
            @Result(column = "ENROLL_DATE", property = "enrollDate"),
            @Result(column = "MODIFY_DATE", property = "modifyDate"),
            @Result(column = "STATUS", property = "status")
    })
    Member loginMember(String userId);

    // 아이디 중복 체크
    @Select("SELECT COUNT(*) FROM MEMBER WHERE USER_ID = #{checkId}")
    int idCheck(String checkId);

    // 회원가입
    @Insert("""
        INSERT INTO MEMBER (USER_ID, USER_PWD, USER_NAME, EMAIL, GENDER, AGE, PHONE, ADDRESS)
        VALUES (#{userId}, #{userPwd}, #{userName}, #{email}, #{gender}, #{age}, #{phone}, #{address})
    """)
    int insertMember(Member member);

    // 회원정보 수정
    @Update("""
        UPDATE MEMBER
        SET USER_NAME = #{userName}, EMAIL = #{email}, GENDER = #{gender}, AGE = #{age},
            PHONE = #{phone}, ADDRESS = #{address}, MODIFY_DATE = NOW()
        WHERE USER_ID = #{userId}
    """)
    int updateMember(Member member);

    // 회원 탈퇴 (STATUS 변경)
    @Update("UPDATE MEMBER SET STATUS = 'N' WHERE USER_ID = #{userId}")
    int deleteMember(String userId);
}
