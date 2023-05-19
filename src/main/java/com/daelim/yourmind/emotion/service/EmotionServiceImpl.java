package com.daelim.yourmind.emotion.service;

import com.daelim.yourmind.emotion.domain.Emotion;
import com.daelim.yourmind.emotion.domain.EmotionRepository;
import com.daelim.yourmind.emotion.dto.EmotionDTO;
import com.daelim.yourmind.emotion.dto.PageRequestDTO;
import com.daelim.yourmind.emotion.dto.PageResultDTO;
import com.daelim.yourmind.emotion.dto.ResponseIdDTO;
import com.daelim.yourmind.user.domain.User;
import com.daelim.yourmind.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;


@Log4j2
@Service
@RequiredArgsConstructor
public class EmotionServiceImpl implements EmotionService {

    private final EmotionRepository emotionRepository;
    private final UserRepository userRepository;

    @Override
    public ResponseIdDTO saveEmotion(EmotionDTO emotionDTO) {
        User child = userRepository.findByUsername(emotionDTO.getChild());
        User counselor = userRepository.findByUsername(emotionDTO.getCounselor());
        Emotion emotion = Emotion.builder()
                .happy(emotionDTO.getHappy())
                .fearful(emotionDTO.getFearful())
                .disgusted(emotionDTO.getDisgusted())
                .angry(emotionDTO.getAngry())
                .neutral(emotionDTO.getNeutral())
                .sad(emotionDTO.getSad())
                .surprised(emotionDTO.getSurprised())
                .child(child)
                .counselor(counselor)
                .build();

        ResponseIdDTO response = ResponseIdDTO.builder().id(emotionRepository.save(emotion).getId()).build();
        return response;
    }

    @Override
    public EmotionDTO getEmotion(Long id) {
        Emotion emotion = emotionRepository.findById(id).get();
        User child = emotion.getChild();
        User counselor = emotion.getCounselor();
        return entityToDTO(emotion, child, counselor);
    }

    @Override
    @Transactional
    public PageResultDTO<EmotionDTO, Object[]> getEmotions(PageRequestDTO pageRequestDTO) {
        log.info(pageRequestDTO);
        Function<Object[], EmotionDTO> fn = (
                entity -> entityToDTO((Emotion)entity[0],
                        (User)entity[1],
                        (User)entity[2])
        );
        Page<Object[]> result;
        if (isCounselor(pageRequestDTO.getUsername())) {
            result = emotionRepository.getEmotionAndChildAndCounselorByCounselor(
                pageRequestDTO.getPageable(Sort.by("id").descending()),
                userRepository.findByUsername(pageRequestDTO.getUsername()).getId()
            );
        }

        else {
            result = emotionRepository.getEmotionAndChildAndCounselorByChild(
                pageRequestDTO.getPageable(Sort.by("id").descending()),
                userRepository.findByUsername(pageRequestDTO.getUsername()).getId()
            );
        }
        return new PageResultDTO<>(result, fn);
    }

    public boolean isCounselor(String username) {
        User user = userRepository.findByUsername(username);
        return user.isCounselor();
    };
}
