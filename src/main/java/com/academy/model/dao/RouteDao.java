package com.academy.model.dao;

import com.academy.model.entity.Airplane;
import com.academy.model.entity.Route;
import java.util.List;

public interface RouteDao extends DefaultDao<Route> {
    public List<Route> findByDeparture(String departurePoint);

    public List<Route> findByArrival(String arrivalPoint);
}
