package com.daelim.yourmind.emotion.domain;

import com.daelim.yourmind.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Emotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long Angry;

    @Column(nullable = false)
    private Long Disgusted;

    @Column(nullable = false)
    private Long Fearful;

    @Column(nullable = false)
    private Long Happy;

    @Column(nullable = false)
    private Long Neutral;

    @Column(nullable = false)
    private Long Sad;

    @Column(nullable = false)
    private Long Surprised;

    @ManyToOne
    private User child;
}
