package com.databasecontrol.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SQLOperate extends ConnectDatabase {

    private final Connection connection;
    private PreparedStatement prepareStatement;
    private ResultSet rs;

    public SQLOperate() {
        connection = ConnectDatabase.getInstance();
    }

    public ResultSet Query(String sql) {
        try {
            prepareStatement = connection.prepareStatement(sql);
            rs = prepareStatement.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet Query(String sql, List<String> list) {
        try {
            prepareStatement = connection.prepareStatement(sql);
            for (int i = 0; i < list.size(); i++) {
                prepareStatement.setString(i + 1, list.get(i));
            }
            rs = prepareStatement.executeQuery();
        } catch (SQLException e) {

        }
        return rs;
    }

    public ResultSet Query(String sql, String value) {
        try {
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, value);
            rs = prepareStatement.executeQuery();
        } catch (SQLException e) {

        }
        return rs;
    }

    public int Insert(String table, List<String> values) {
        StringBuilder sql = new StringBuilder("");
        StringBuilder plus = new StringBuilder("");
        int result;
        if (values.size() > 0) {
            for (int i = 0; i < values.size() - 1; i++) {
                plus.append("?,");
            }
        } else {
            return -1;								//如果List不大于0
        }
        plus.append("?");
        //insert into ?table values (?,?,?,?);
        sql.append("insert into ");
        sql.append(table);
        sql.append(" values (");
        sql.append(plus);
        sql.append(");");
        System.out.println(sql);
        try {
            prepareStatement = connection.prepareStatement(sql.toString());
            for (int i = 0; i < values.size(); i++) {
                prepareStatement.setString(i + 1, values.get(i));
            }
            result = prepareStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return -500;
        }
        return result;
    }

    public int Insert(String table, List<String> columns, List<String> values) {
        StringBuilder sql = new StringBuilder("");
        StringBuilder col = new StringBuilder("");
        StringBuilder plus = new StringBuilder("");
        int result;
        if (values.size() > 0 && columns.size() == values.size()) {
            for (int i = 0; i < values.size() - 1; i++) {
                col.append(columns.get(i) + ",");
                plus.append("?,");
            }
        } else {
            return -1;								//如果List不大于0
        }
        col.append(columns.get(columns.size() - 1));
        plus.append("?");
        //insert into ?table values (?,?,?,?);
        sql.append("insert into ");
        sql.append(table);
        sql.append("(");
        sql.append(col);
        sql.append(") values (");
        sql.append(plus);
        sql.append(");");
        System.out.println(sql);
        try {
            prepareStatement = connection.prepareStatement(sql.toString());
            for (int i = 0; i < values.size(); i++) {
                System.out.println(values.get(i));
                prepareStatement.setString(i + 1, values.get(i));
            }
            result = prepareStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return -500;
        }
        return result;
    }

}
