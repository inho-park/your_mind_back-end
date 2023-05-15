package com.daelim.yourmind.emotion.service;

import com.daelim.yourmind.emotion.domain.Emotion;
import com.daelim.yourmind.emotion.domain.EmotionRepository;
import com.daelim.yourmind.emotion.dto.EmotionDTO;
import com.daelim.yourmind.emotion.dto.PageRequestDTO;
import com.daelim.yourmind.emotion.dto.PageResultDTO;
import com.daelim.yourmind.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;


@Log4j2
@Service
@RequiredArgsConstructor
public class EmotionServiceImpl implements EmotionService {

    private final EmotionRepository emotionRepository;

    @Override
    public Emotion saveEmotion(Emotion emotion) {
        return null;
    }

    @Override
    public Emotion getEmotion(Long childId) {
        return null;
    }

    @Override
    public PageResultDTO<EmotionDTO, Object[]> getEmotions(PageRequestDTO pageRequestDTO) {
        log.info(pageRequestDTO);
        Function<Object[], EmotionDTO> fn = (
                entity -> entityToDTO((Emotion)entity[0],
                        (User)entity[1],
                        (User)entity[2])
        );

        Page<Object[]> result = emotionRepository.getEmotionAndChildAndCounselor(
            pageRequestDTO.getPageable(Sort.by("id").descending())
        );

        return new PageResultDTO<>(result, fn);
    }
}
