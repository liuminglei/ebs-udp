package com.ebs.common.jdbcspy;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws Exception {
        String url = "spy:mysql:127.0.0.1:3306:jypt";
        Class.forName("com.mysql.jdbc.Driver");

        Driver driver = DriverManager.getDriver(url);
        System.setProperty("user", "root");
        System.setProperty("password", "123456");

        tt(url, driver);
        tt(url, driver);
    }

    private static void tt(String url, Driver driver) throws SQLException {
        Connection conn = driver.connect(url, System.getProperties());
        conn.setAutoCommit(true);
        PreparedStatement statement = conn.prepareStatement("select t.* from gg_xtgn t order by id");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next());
        statement = conn.prepareStatement("select t.* from gg_xtgn t order by id");
    }
}
