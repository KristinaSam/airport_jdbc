package com.academy.model.dao.impl;

import com.academy.DataSource;
import com.academy.model.dao.AirplaneDao;
import com.academy.model.entity.Airplane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirplaneDaoImpl implements AirplaneDao {
    @Override
    public void create(Airplane airplane) {
        try {
            Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into airplane (model) values (?)");
            preparedStatement.setString(1, airplane.getModel());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Airplane airplane) {
        try {
            Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update airplane set model = ? where id = ?");
            preparedStatement.setInt(1, airplane.getId());
            preparedStatement.setString(2, airplane.getModel());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Airplane airplane) {
        try {
            Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from airplane where id=?");
            preparedStatement.setInt(1, airplane.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Airplane findById(int id) {
        try {
            Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from airplane where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Airplane> airplanes = new ArrayList<>();
            while (resultSet.next()) {
                Airplane airplane = new Airplane();
                airplane.setId(resultSet.getInt("id"));
                airplane.setModel(resultSet.getString("model"));
                airplanes.add(airplane);
            }
            return airplanes.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Airplane> findAll() {
        try {
            Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from airplane");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Airplane> airplanes = new ArrayList<>();
            while (resultSet.next()) {
                Airplane airplane = new Airplane();
                airplane.setId(resultSet.getInt("id"));
                airplane.setModel(resultSet.getString("model"));
                airplanes.add(airplane);
            }
            return airplanes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Airplane> findByAirplaneModel(String model) {
        try {
            Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from airplane where model = ?");
            preparedStatement.setString(1, model);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Airplane> airplanes = new ArrayList<>();
            while (resultSet.next()) {
                Airplane airplane = new Airplane();
                airplane.setId(resultSet.getInt("id"));
                airplane.setModel(resultSet.getString("model"));
                airplanes.add(airplane);
            }
            return airplanes.stream().toList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
