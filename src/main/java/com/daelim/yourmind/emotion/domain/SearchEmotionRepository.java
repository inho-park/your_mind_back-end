package com.daelim.yourmind.emotion.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SearchEmotionRepository {
    Page<Object[]> searchPage(String type, String keyword, Pageable pageable);
}
