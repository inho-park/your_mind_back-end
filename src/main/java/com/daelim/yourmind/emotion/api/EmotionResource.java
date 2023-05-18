package com.daelim.yourmind.emotion.api;

import com.daelim.yourmind.emotion.dto.EmotionDTO;
import com.daelim.yourmind.emotion.dto.PageRequestDTO;
import com.daelim.yourmind.emotion.service.EmotionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/emotions")
public class EmotionResource {
    final private EmotionService service;

    @GetMapping()
    public ResponseEntity getList(PageRequestDTO pageRequestDTO) {
        try {
            return new ResponseEntity<>(service.getEmotions(pageRequestDTO), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping()
    public ResponseEntity create(EmotionDTO dto) {
        return new ResponseEntity<>(service.saveEmotion(dto), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity read(@PathVariable(value = "id") String id) {
        return new ResponseEntity<>(service.getEmotion(Long.parseLong(id)), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") String id) {
        return null;
    }
}
