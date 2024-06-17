
package com.sparta.mvm.service;

import com.sparta.mvm.entity.User;
import com.sparta.mvm.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testFindUserById() {
        // given
        User user = new User("testuser", "password");
        user.setId(1L); // setID 메서드를 사용하여 ID를 설정

        // Mockito를 사용하여 findById 메서드가 호출될 때 반환할 객체를 설정
        when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(user));

        // when
        User foundUser = userService.findById(1L);

        // then
        assertEquals("testuser", foundUser.getUsername());
    }
}