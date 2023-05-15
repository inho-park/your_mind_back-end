package com.daelim.yourmind.emotion.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmotionRepository extends JpaRepository<Emotion, Long>{
    @Query(
            "SELECT child, counselor, e " +
            "FROM Emotion e " +
            "LEFT JOIN e.child child " + "LEFT JOIN e.counselor counselor"
    )
    Page<Object[]> getEmotionAndChildAndCounselor(Pageable pageable);
}
