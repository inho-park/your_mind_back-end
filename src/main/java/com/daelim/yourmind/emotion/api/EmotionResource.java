package com.daelim.yourmind.emotion.api;

import com.daelim.yourmind.emotion.dto.EmotionDTO;
import com.daelim.yourmind.emotion.dto.PageRequestDTO;
import com.daelim.yourmind.emotion.service.EmotionService;
import com.daelim.yourmind.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/emotions")
public class EmotionResource {
    final private EmotionService emotionService;
    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getList(@RequestBody PageRequestDTO pageRequestDTO) {
        try {
            return new ResponseEntity<>(emotionService.getEmotions(pageRequestDTO), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody EmotionDTO dto) {
        try {
            return new ResponseEntity<>(emotionService.saveEmotion(dto), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity read(@PathVariable(value = "id") String id) {
        try {
            return new ResponseEntity<>(emotionService.getEmotion(Long.parseLong(id)), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") String id) {
        return null;
    }
}
