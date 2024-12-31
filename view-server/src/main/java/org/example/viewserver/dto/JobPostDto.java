package org.example.viewserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

/**
 * packageName    : org.example.restserver.dto
 * fileName       : JobPostDto
 * author         : 박미정
 * date           : 24. 12. 26.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 26.        박미정      최초 생성
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostDto {

    private int jobPostNo;
    private String username;
    private String title;
    private String workCode;
    private Integer jobHistory; // 클라이언트에서 정수로 전송해야 함
    private Integer jobSalary;  // 클라이언트에서 정수로 전송해야 함
    private String educationCode;
    private String jobRankCode;
    private String workTypeCode;
    private LocalDate startDate;
    private LocalDate endDate;
    private String content;
    private String workCondition;
    private Integer process; // 클라이언트에서 정수로 전송해야 함
    private String method;
    private String addNotice;
    private String managerName;
    private String managerPhone;
    private String managerEmail;
    private Character endYn;
 //   private String fileName;
    private String benefit;
    private String skillCode;



}
