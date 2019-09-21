package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.*;

@RestController
@RequestMapping("/shardingSpwhere")
public class ShardingSpwhereController {
    private final Logger logger = LoggerFactory.getLogger(ShardingSpwhereController.class);

    @Resource
    private DataSource shardingDataSource;

    @RequestMapping("selectAll")
    public int selectAll() {
        String sql = "select * from t_order";
        try (Connection connection = shardingDataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                logger.info(resultSet.getString(1));
            }
        } catch (SQLException e) {
            logger.error("error", e);
        }
        return 1;
    }

    @RequestMapping("insertOne")
    public long insertOne(int userId) {
        String sql = "insert into t_order(user_id,status) values(?,?)";
        try (Connection connection = shardingDataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, userId);
            preparedStatement.setString(2, "INSERT");
            preparedStatement.executeUpdate();
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    return resultSet.getLong(1);
                }
            }
        } catch (SQLException e) {
            logger.error("error", e);
        }
        return 1L;
    }

    @RequestMapping("fetchData")
    public String fetchData() {
        String sql = "select * from t_order";
        StringBuffer sb = new StringBuffer();
        try (Connection connection = shardingDataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                sb.append(resultSet.getString("order_id"));
                sb.append("\r\n");
            }
        } catch (SQLException e) {
            logger.error("error", e);
        }
        return sb.toString();
    }


    @RequestMapping("createTable")
    public int createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS t_order (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status VARCHAR(50), PRIMARY KEY (order_id))";
        try (Connection connection = shardingDataSource.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (final SQLException ignored) {
            logger.error("createTable error", ignored);
        }
        return 1;
    }
}
