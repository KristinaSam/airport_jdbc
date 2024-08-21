package com.academy.model.dao;

import com.academy.model.entity.Airplane;
import java.util.List;

public interface AirplaneDao extends DefaultDao<Airplane> {
    public List<Airplane> findByAirplaneModel(String model);
}
