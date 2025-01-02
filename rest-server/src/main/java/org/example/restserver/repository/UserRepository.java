package org.example.restserver.repository;

import org.apache.ibatis.annotations.Param;
import org.example.restserver.dto.CompanySearchDto;
import org.example.restserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * packageName    : org.example.restserver.repository
 * fileName       : UserRepository
 * author         : 황승현
 * date           : 2024-12-27
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-12-27        황승현       최초 생성
 */
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);

    Optional<User> findByUsernameAndRoleInAndDeleteYn(
            String username,
            List<String> roles,
            String deleteYn
    );

    Optional<User> findByUsernameAndRoleAndDeleteYn(
            String username,
            String role,
            String deleteYn
    );

//    @Query("SELECT new org.example.restserver.dto.CompanySearchDto(" +
//            "u.name, c.address, c.birth, COALESCE(AVG(cs.score), 0)) " +
//            "FROM User u " +
//            "LEFT JOIN Company c ON u.username = c.username " +
//            "LEFT JOIN CompanyScore cs ON cs.id.companyId = u.username " +
//            "WHERE u.role = 'ROLE_COMPANY' AND u.deleteYn = 'N' AND u.name LIKE %:keyword% " +
//            "GROUP BY u.name, c.address, c.birth")
//    List<CompanySearchDto> findCompanyByKeyword(@Param("keyword") String keyword);

    @Query(value = """
                WITH RECURSIVE date_range AS (
                    SELECT CURDATE() - INTERVAL 6 DAY AS date
                    UNION ALL
                    SELECT date + INTERVAL 1 DAY
                    FROM date_range
                    WHERE date < CURDATE()
                )
                SELECT dr.date as date,
                       COALESCE(SUM(CASE WHEN us.role = 'ROLE_JOB_SEEKER' THEN 1 END), 0) AS job_seekers,
                       COALESCE(SUM(CASE WHEN us.role = 'ROLE_COMPANY' THEN 1 END), 0) AS companies
                FROM date_range dr
                LEFT JOIN tbl_user us ON DATE(us.create_date) = dr.date
                GROUP BY dr.date
                ORDER BY dr.date;
            """, nativeQuery = true)
    List<Object[]> getWeeklyUserData();
}
