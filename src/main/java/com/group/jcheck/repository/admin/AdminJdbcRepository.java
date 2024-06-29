//package com.group.jcheck.repository.admin;
//
//import com.group.jcheck.domain.admin.Admin;
//import com.group.jcheck.dto.admin.response.AdminsResponse;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import java.util.List;
//
//public class AdminJdbcRepository {
//    private final JdbcTemplate jdbcTemplate;
//
//    public AdminJdbcRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public void createAdmin(String adminId, String adminName, String adminPassword, Boolean adminAuthority) {
//        String insertSql = "insert into admin (adminId, adminName, adminPassword, adminAuthority) values (?, ?, ?, ?)";
//        jdbcTemplate.update(insertSql, adminId, adminName, adminPassword, adminAuthority);
//    }
//
//    public List<AdminsResponse> readAdmin() {
//        String selectSql = "select * from admin where ?";
//        return jdbcTemplate.query(selectSql , (rs, roNum) -> {
//            Admin admin = new Admin();
//            admin.setId(rs.getLong("id"));
//            admin.setAdminId(rs.getString("adminId"));
//            admin.setAdminAuthority(rs.getBoolean("adminAuthority"));
//            return new AdminsResponse(admin);
//        });
//    }
//
//    public void updateAdmin(String adminPw, Long id) {
//        String updateSql = "update admin set adminPassword = ? where adminId = ?";
//        jdbcTemplate.update(updateSql, adminPw, id);
//    }
//
//    public void deleteAdmin(String adminId) {
//        String deleteSql = "delete from admin where adminId = ?";
//        jdbcTemplate.update(deleteSql, adminId);
//    }
//}
