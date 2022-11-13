package com.ms.tweet.dao.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comments")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String content;

    @Column(name = "is_viewed")
    boolean viewed;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    PostEntity post;



}
