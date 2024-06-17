package com.sparta.mvm.dto;

import com.sparta.mvm.entity.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserRequestDtoTest {

    @Test
    public void testToEntity() {
        // given
        UserRequestDto requestDto = new UserRequestDto("username", "password");

        // when
        User user = requestDto.toEntity();

        // then
        assertEquals("username", user.getUsername());
        assertEquals("password", user.getPassword());
    }
}