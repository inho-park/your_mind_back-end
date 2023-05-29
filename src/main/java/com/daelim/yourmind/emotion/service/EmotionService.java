package com.daelim.yourmind.emotion.service;

import com.daelim.yourmind.emotion.domain.Emotion;
import com.daelim.yourmind.emotion.dto.*;
import com.daelim.yourmind.user.domain.User;

import java.util.List;


public interface EmotionService {
    StatusDTO saveEmotion(EmotionDTO emotionDTO);
    EmotionDTO getEmotion(Long emotionId, String username);
    PageResultDTO<EmotionDTO, Object[]> getEmotions(PageRequestDTO pageRequestDTO);
    StatusDTO deleteEmotion(Long emotionId, String username);
    boolean isCounselor(String username);

    default Emotion dtoToEntity(EmotionDTO dto) {
        User child  = User.builder().username(dto.getChild()).build();
        User counselor = User.builder().username(dto.getCounselor()).build();
        Emotion emotion = Emotion.builder()
                .id(dto.getId())
                .angry(dto.getAngry())
                .disgusted(dto.getDisgusted())
                .fearful(dto.getFearful())
                .happy(dto.getHappy())
                .neutral(dto.getNeutral())
                .surprised(dto.getSurprised())
                .sad(dto.getSad())
                .child(child)
                .counselor(counselor)
                .build();
        return emotion;
    }

    default EmotionDTO entityToDTO(Emotion emotion, User child, User counselor) {
        EmotionDTO emotionDTO = EmotionDTO.builder()
                .id(emotion.getId())
                .angry(emotion.getAngry())
                .neutral(emotion.getNeutral())
                .fearful(emotion.getFearful())
                .sad(emotion.getSad())
                .disgusted(emotion.getDisgusted())
                .surprised(emotion.getSurprised())
                .happy(emotion.getHappy())
                .regDate(emotion.getRegDate())
                .modDate(emotion.getModDate())
                .child(child.getUsername())
                .counselor(counselor.getUsername())
                .build();

        return emotionDTO;
    }
}
