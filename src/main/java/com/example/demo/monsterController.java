package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Administrator on 2017-08-21.
 */
@RestController
public class monsterController {
    @Autowired
    DataSource dataSource;

    @RequestMapping("/")
    @ResponseBody
    public String testDb() throws SQLException {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT 1+1")) {
            rs.next();
            int two = rs.getInt(1);
            return "Database connectivity seems " + (two == 2 ? "OK." : "weird!");
        }
    }



}
