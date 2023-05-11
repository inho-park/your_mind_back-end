package com.daelim.yourmind.emotion.service;

import com.daelim.yourmind.emotion.domain.Emotion;

import java.util.List;

public interface EmotionService {
    Emotion saveEmotion(Emotion emotion);
    Emotion getEmotion(Long childId);
    List<Emotion> getEmotions();
}
