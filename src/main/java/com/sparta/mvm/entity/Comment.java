package com.sparta.mvm.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "comments")
@NoArgsConstructor
public class Comment extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "COMMENTS", nullable = false)
    private String comments;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Comment(String comments, Post post) {
        this.comments = comments;
        this.post = post;
    }

    public void update(String comments) {
        this.comments = comments;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
