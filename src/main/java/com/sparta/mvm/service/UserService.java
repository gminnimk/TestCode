package com.sparta.mvm.service;

import com.sparta.mvm.dto.ResignDto;
import com.sparta.mvm.dto.SignupRequestDto;
import com.sparta.mvm.dto.SignupResponseDto;
import com.sparta.mvm.entity.User;
import com.sparta.mvm.entity.UserStatusEnum;
import com.sparta.mvm.exception.CustomException;
import com.sparta.mvm.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.sparta.mvm.exception.ErrorEnum.*;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SignupResponseDto signup(SignupRequestDto requestDto) {
        String username = requestDto.getUsername();
        String password = passwordEncoder.encode(requestDto.getPassword());
        String name = requestDto.getName();
        String lineIntro = requestDto.getLineIntro();
        UserStatusEnum userStatusEnum = UserStatusEnum.USER_NORMAL;

        // 회원 중복 확인
        Optional<User> checkUsername = userRepository.findByUsername(username);
        if (checkUsername.isPresent()) {
            throw new CustomException(BAD_DUPLICATE);
        }

        String email = requestDto.getEmail();

        // 사용자 등록
        User user = new User(username, password, name, email, lineIntro, userStatusEnum);
        userRepository.save(user);

        return new SignupResponseDto(user);
    }

    @Transactional
    public void resign(User user, ResignDto resignDto) {
        User userRep = userRepository.findByUsername(user.getUsername()).orElseThrow();
        if (!passwordEncoder.matches(resignDto.getPassword(), userRep.getPassword())) {
            throw new CustomException(BAD_PASSWORD);
        }
        if (userRep.getUserStatus().equals(UserStatusEnum.USER_RESIGN)) {
            throw new CustomException(BAD_RESIGN);
        }

        userRep.resignStatus();
    }


    @Transactional(readOnly = true)
    public User findById(Long id) {
        // userRepository.findById 메서드를 호출하여 사용자 조회
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null); // Optional에서 사용자 객체를 가져오거나, 없으면 null 반환
    }
}
