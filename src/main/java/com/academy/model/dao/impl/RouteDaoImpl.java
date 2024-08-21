package com.academy.model.dao.impl;

import com.academy.DataSource;
import com.academy.model.dao.RouteDao;
import com.academy.model.entity.Airplane;
import com.academy.model.entity.Route;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouteDaoImpl implements RouteDao {
    @Override
    public void create(Route route) {
        try {
            Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into route (departure, arrival) values (?,?)");
            preparedStatement.setString(1, route.getDeparture());
            preparedStatement.setString(2, route.getArrival());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Route route) {
        try {
            Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update route set departure =?, arrival=? where id = ?");
            preparedStatement.setInt(1, route.getId());
            preparedStatement.setString(2, route.getDeparture());
            preparedStatement.setString(3, route.getArrival());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Route route) {
        try {
            Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from route where id=?");
            preparedStatement.setInt(1, route.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Route findById(int id) {
        try {
            Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from route where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Route> routes = new ArrayList<>();
            while (resultSet.next()) {
                Route route = new Route();
                route.setId(resultSet.getInt("id"));
                route.setDeparture(resultSet.getString("departure"));
                route.setArrival(resultSet.getString("arrival"));
                routes.add(route);
            }
            return routes.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Route> findAll() {
        try {
            Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from route");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Route> routes = new ArrayList<>();
            while (resultSet.next()) {
                Route route = new Route();
                route.setId(resultSet.getInt("id"));
                route.setDeparture(resultSet.getString("departure"));
                route.setArrival(resultSet.getString("arrival"));
                routes.add(route);
            }
            return routes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Route> findByDeparture(String departure) {
        try {
            Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from route where departure = ?");
            preparedStatement.setString(1, departure);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Route> routes = new ArrayList<>();
            while (resultSet.next()) {
                Route route = new Route();
                route.setId(resultSet.getInt("id"));
                route.setDeparture(resultSet.getString("departure"));
                route.setArrival(resultSet.getString("arrival"));
                routes.add(route);
            }
            return routes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Route> findByArrival(String arrival) {
        try {
            Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from route where arrival = ?");
            preparedStatement.setString(1, arrival);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Route> routes = new ArrayList<>();
            while (resultSet.next()) {
                Route route = new Route();
                route.setId(resultSet.getInt("id"));
                route.setDeparture(resultSet.getString("departure"));
                route.setArrival(resultSet.getString("arrival"));
                routes.add(route);
            }
            return routes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
