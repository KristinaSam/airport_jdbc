package com.academy.model.dao.impl;

import com.academy.DataSource;
import com.academy.model.dao.TicketDao;
import com.academy.model.entity.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketDaoImpl implements TicketDao {
    @Override
    public void create(Ticket ticket) {
        try {
            Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into ticket (id, status, user_id, airplane_route_id) values (?,?,?,?)");
            preparedStatement.setInt(1, ticket.getId());
            preparedStatement.setString(2, ticket.getStatus());
            preparedStatement.setInt(3, ticket.getUser_id());
            preparedStatement.setInt(4, ticket.getAirplane_route_id());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Ticket ticket) {
        try {
            Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update ticket set status =?, user_id=?, airplane_route_id = ? where id = ?");
            preparedStatement.setInt(1, ticket.getId());
            preparedStatement.setString(2, ticket.getStatus());
            preparedStatement.setInt(3, ticket.getUser_id());
            preparedStatement.setInt(4, ticket.getAirplane_route_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Ticket ticket) {
        try {
            Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from ticket where id=?");
            preparedStatement.setInt(1, ticket.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Ticket findById(int id) {
        try {
            Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from ticket where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Ticket> tickets = new ArrayList<>();
            while (resultSet.next()) {
                Ticket ticket = new Ticket();
                ticket.setId(resultSet.getInt("id"));
                ticket.setStatus(resultSet.getString("status"));
                ticket.setUser_id(resultSet.getInt("user_id"));
                ticket.setAirplane_route_id(resultSet.getInt("airplane_route_id"));
                tickets.add(ticket);
            }
            return tickets.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Ticket> findByUserId(int userId) {
        try {
            Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from ticket where user_id = ?");
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Ticket> tickets = new ArrayList<>();
            while (resultSet.next()) {
                Ticket ticket = new Ticket();
                ticket.setId(resultSet.getInt("id"));
                ticket.setStatus(resultSet.getString("status"));
                ticket.setUser_id(resultSet.getInt("user_id"));
                ticket.setAirplane_route_id(resultSet.getInt("airplane_route_id"));
                tickets.add(ticket);
            }
            return tickets;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Ticket> findAll() {
        try {
            Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from ticket");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Ticket> tickets = new ArrayList<>();
            while (resultSet.next()) {
                Ticket ticket = new Ticket();
                ticket.setId(resultSet.getInt("id"));
                ticket.setStatus(resultSet.getString("status"));
                ticket.setUser_id(resultSet.getInt("user_id"));
                ticket.setAirplane_route_id(resultSet.getInt("airplane_route_id"));
                tickets.add(ticket);
            }
            return tickets;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Ticket> findAllStatus(String status) {
        try {
            Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from ticket where status = ?");
            preparedStatement.setString(1, status);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Ticket> tickets = new ArrayList<>();
            while (resultSet.next()) {
                Ticket ticket = new Ticket();
                ticket.setId(resultSet.getInt("id"));
                ticket.setStatus(resultSet.getString("status"));
                ticket.setUser_id(resultSet.getInt("user_id"));
                ticket.setAirplane_route_id(resultSet.getInt("airplane_route_id"));
                tickets.add(ticket);
            }
            return tickets;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Ticket> findByAirplaneRoute(int airplaneRouteId) {
        try {
            Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from ticket where airplane_route_id = ?");
            preparedStatement.setInt(1, airplaneRouteId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Ticket> tickets = new ArrayList<>();
            while (resultSet.next()) {
                Ticket ticket = new Ticket();
                ticket.setId(resultSet.getInt("id"));
                ticket.setStatus(resultSet.getString("status"));
                ticket.setUser_id(resultSet.getInt("user_id"));
                ticket.setAirplane_route_id(resultSet.getInt("airplane_route_id"));
                tickets.add(ticket);
            }
            return tickets;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
