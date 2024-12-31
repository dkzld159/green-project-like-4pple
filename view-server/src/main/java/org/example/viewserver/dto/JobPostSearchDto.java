package org.example.viewserver.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * packageName    : org.example.restserver.dto
 * fileName       : JobPostSearchDto
 * author         : 이동하
 * date           : 2024-12-30
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-12-30        이동하       최초 생성
 */

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class JobPostSearchDto {

    private String title;
    private String workCode;
    private LocalDateTime jobHistory;
    private String educationCode;
    private String jobRankCode;
    private String workTypeCode;
    private LocalDateTime endDate;

}
