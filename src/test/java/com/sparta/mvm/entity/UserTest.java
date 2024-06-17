package com.sparta.mvm.entity;

import com.sparta.mvm.dto.ProfileRequestDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    public void testUpdate() {
        // given : 사용자 객체 생성 및 초기화
        User user = new User("testuser", "password");


        // 프로필 업데이트 요청 DTO 생성 및 설정
        ProfileRequestDto requestDto = new ProfileRequestDto();
        requestDto.setName("Updated Name");
        requestDto.setLineIntro("Updated Intro");
        requestDto.setChangedPassword("newpassword");

        // when : 사용자 객체에 업데이트 요청 적용
        user.update(requestDto);

        // then : 업데이트된 정보가 설정되엇는지 검증작업.
        assertEquals("Updated Name", user.getName());
        assertEquals("Updated Intro", user.getLineIntro());
        assertEquals("newpassword", user.getPassword());
    }
}
