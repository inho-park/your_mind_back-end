package com.daelim.yourmind.emotion.api;

import com.daelim.yourmind.emotion.dto.PageRequestDTO;
import com.daelim.yourmind.emotion.service.EmotionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/emotion")
public class EmotionResource {
    final private EmotionService service;

    @GetMapping({"/list", "/"})
    public ResponseEntity getList(@RequestBody PageRequestDTO pageRequestDTO) {
        try {
            return new ResponseEntity<>(service.getEmotions(pageRequestDTO), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
