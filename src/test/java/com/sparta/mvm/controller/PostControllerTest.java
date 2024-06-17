package com.sparta.mvm.controller;

import com.sparta.mvm.dto.PostRequestDto;
import com.sparta.mvm.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PostController.class)
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    @Test
    public void testCreatePost() throws Exception {
        // given : 테스트할 데이터를 생성
        PostRequestDto requestDto = new PostRequestDto();
        requestDto.setTitle("Test Post");
        requestDto.setContent("This is a test post.");

        // when-then : Http post 요청을 보내고 응답을 검증함
        mockMvc.perform(MockMvcRequestBuilders.post("/api/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"title\": \"Test Post\", \"content\": \"This is a test post.\" }"))
                .andExpect(status().isOk()); // 기대한 상태 코드가 반환되는지 검증
    }
}