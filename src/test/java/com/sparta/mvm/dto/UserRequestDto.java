package com.sparta.mvm.dto;

import com.sparta.mvm.entity.User;

public class UserRequestDto {

    private String username;
    private String password;

    // 사용자명과 비밀번호를 받는 생성자
    public UserRequestDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // 사용자명 Getter
    public String getUsername() {
        return username;
    }

    // 사용자명 Setter
    public void setUsername(String username) {
        this.username = username;
    }

    // 비밀번호 Getter
    public String getPassword() {
        return password;
    }

    // 비밀번호 Setter
    public void setPassword(String password) {
        this.password = password;
    }


    // User 엔티티로 변환하는 메서드
    public User toEntity() {

        return new User(username, password); // 입력받은 사용자명과 비밀번호로 User 엔티티를 생성하여 반환함
    }
}
