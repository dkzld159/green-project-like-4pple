package org.example.restserver.repository;

import org.example.restserver.dto.ResumeResponseDto;
import org.example.restserver.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * packageName    : org.example.restserver.repository
 * fileName       : ResumeRepository
 * author         : 김재홍
 * date           : 24. 12. 30.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 30.        김재홍       최초 생성
 */
public interface ResumeRepository extends JpaRepository<Resume, Integer> {

    List<Resume> findAllByUsername(String username);

}
