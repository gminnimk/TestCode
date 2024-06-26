package com.sparta.mvm.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ErrorEnum {
    // user
    BAD_RESIGN(400, "이미 탈퇴한 회원입니다."),
    BAD_DUPLICATE(400, "중복되거나 탈퇴한 사용자가 존재합니다."),
    // post
    BAD_POSTID(400, "게시글 ID를 찾을 수 없습니다."),
    BAD_AUTH_PUT(400, "작성자만 수정할 수 있습니다."),
    BAD_AUTH_DELETE(400, "작성자만 삭제할 수 있습니다."),
    // comment
    BAD_COMMENTID(400, "댓글 ID를 찾을 수 없습니다."),
    // authorization
    NOT_VALID_TOKEN(400, "유효하지 않은 토큰입니다"),
    EXPIRED_REFRESH_TOKEN_VALUE(403, "리프레시 토큰이 만료되었습니다, 재로그인이 필요합니다"),
    EXPIRED_TOKEN_VALUE(403, "토큰이 만료되었습니다, 재발급이 필요합니다"),
    // profile
    USER_NOT_FOUND(400, "등록되지 않은 사용자입니다."),
    BAD_PASSWORD(400, "비밀번호를 확인해주세요"),
    SAME_PASSWORD(400, "입력이 기존과 동일합니다."),
    // like
    BAD_AUTH_LIKE(400, "본인의 게시물이나 댓글에 좋아요를 남길 수 없습니다."),
    DUPLICATE_LIKE(400, "이미 좋아요를 눌렀습니다."),
    CANNOT_LIKE_OWN_POST(400, "본인의 게시글에는 좋아요를 누를 수 없습니다."),
    CANNOT_LIKE_OWN_COMMENT(400, "본인의 댓글에는 좋아요를 누를 수 없습니다."),
    LIKE_NOT_FOUND(400, "좋아요를 찾을 수 없습니다.");

    int statusCode;
    String msg; // 출력 메시지
}
