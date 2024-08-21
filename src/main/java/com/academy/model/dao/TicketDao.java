package com.academy.model.dao;

import com.academy.model.entity.Ticket;
import java.util.List;

public interface TicketDao extends DefaultDao<Ticket> {
    public List<Ticket> findByUserId(int userId);

    public List<Ticket> findAllStatus(String status);

    public List<Ticket> findByAirplaneRoute(int airplaneRouteId);
}
