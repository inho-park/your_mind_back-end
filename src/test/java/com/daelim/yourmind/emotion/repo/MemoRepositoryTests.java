package com.daelim.yourmind.emotion.repo;

import com.daelim.yourmind.emotion.domain.Emotion;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemoRepositoryTests {
    @Autowired
    private MemoRepository memoRepository;
    @Autowired
    private EmotionRepository emotionRepository;

    @Test
    public void 이모션에_작성한_메모_추가() {
        Emotion emotion = emotionRepository.getReferenceById(3l);
        Memo memo = Memo.builder()
                .emotion(emotion)
                .memo("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                        "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb" +
                        "ccccccccccccccccccccccccccccccccccccccccccccccccccc" +
                        "ddddddddddddddddddddddddddddddddddddddddddddddddddd")
                .build();

        memoRepository.save(memo);
    }
}
