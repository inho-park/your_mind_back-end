package com.daelim.yourmind.emotion.repo;

import com.daelim.yourmind.emotion.domain.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, Long> {

}
