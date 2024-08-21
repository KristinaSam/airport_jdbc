package com.academy;

import com.academy.model.dao.AirplaneDao;
import com.academy.model.dao.RouteDao;
import com.academy.model.dao.TicketDao;
import com.academy.model.dao.UserDao;
import com.academy.model.dao.impl.AirplaneDaoImpl;
import com.academy.model.dao.impl.RouteDaoImpl;
import com.academy.model.dao.impl.TicketDaoImpl;
import com.academy.model.dao.impl.UserDaoImpl;
import com.academy.model.entity.Airplane;
import com.academy.model.entity.Route;
import com.academy.model.entity.Ticket;
import com.academy.model.entity.User;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        User user1 = new User();
        user1.setId(21);
        user1.setName("Emma");
        user1.setSurname("Stone");
        user1.setPhone("+14081235412");
        userDao.create(user1);
        User user2 = userDao.findById(5);
        user2.setName("Max");
        userDao.update(user2);
        userDao.delete(user1);
        System.out.println(userDao.findAll());
        System.out.println(userDao.findById(9));
        System.out.println(userDao.findByUserSurname("Clooney"));
        System.out.println(userDao.findByUsername("Nicole"));
        System.out.println(userDao.findByPhone("+14082475196"));


        TicketDao ticketDao = new TicketDaoImpl();
        Ticket ticket1 = new Ticket();
        ticket1.setId(41);
        ticket1.setStatus("sold");
        ticket1.setUser_id(19);
        ticket1.setAirplane_route_id(2);
        ticketDao.delete(ticket1);
        ticketDao.create(ticket1);
        Ticket ticket2 = ticketDao.findById(28);
        ticket2.setUser_id(17);
        ticketDao.update(ticket2);
        ticketDao.delete(ticket1);
        System.out.println(ticketDao.findById(9));
       System.out.println(ticketDao.findAllStatus("in stock"));
        System.out.println(ticketDao.findByAirplaneRoute(1));


        RouteDao routeDao = new RouteDaoImpl();
        Route route1 = new Route();
        route1.setId(16);
        route1.setDeparture("Minsk");
        route1.setArrival("Baku");
        routeDao.create(route1);
        routeDao.delete(route1);
        Route route2 = routeDao.findById(7);
        route2.setDeparture("Brest");
        route2.setArrival("Minsk");
        routeDao.update(route2);
        System.out.println(routeDao.findById(5));
        System.out.println(routeDao.findAll());
        System.out.println(routeDao.findByDeparture("New York"));
        System.out.println(routeDao.findByArrival("Geneva"));

        AirplaneDao airplaneDao = new AirplaneDaoImpl();
        Airplane airplane = new Airplane();
        airplane.setId(11);
        airplane.setModel("Boeing 777");
        airplaneDao.create(airplane);
        Airplane airplane2 = airplaneDao.findById(1);
        airplane2.setModel("Airbus A380");
        airplaneDao.update(airplane2);
        airplaneDao.delete(airplane);
        System.out.println(airplaneDao.findAll());
        System.out.println(airplaneDao.findById(5));
        System.out.println(airplaneDao.findByAirplaneModel("Boing 777"));
    }
}
