package com.flight.service;

import java.util.List;

import java.util.Optional;

//import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.dao.FlightDAO;
import com.flight.entities.Flight;
import com.flight.exceptions.FlightNotFoundException;
@Service
public class FlightServiceImpl implements FlightService {
	
	@Autowired
	private FlightDAO flightdao;
	
	
//	private EntityManager em;

	@Override
	public List<Flight> getAllFlightBookings() {
		return flightdao.getByBookingFlights();
	}

	@Override
	public List<Flight> getAllFlights() {
		return flightdao.findAll();
	}

	@Override
	public Flight addFlights(Flight flight) {
		flightdao.save(flight);
		return flight;
	}

	@Override
	public Flight updateFlights(Flight flight) {
		// TODO Auto-generated method stub
		flightdao.save(flight);
		return flight;
	}

	

	@Override
	public List<Flight> getRelatedFlight() {
		// TODO Auto-generated method stub
		return flightdao.GetFlights();
	}
	@Override
	public Flight getId(int id)throws FlightNotFoundException {
		Flight f;
		if(flightdao.findById(id).isEmpty()) {
			throw new FlightNotFoundException();
		}
		else {
			f=flightdao.findById(id).get();
		}
		return f;
	}
	@Override
	public void deleteFlight(int id) {
		Flight f=flightdao.getById(id);
		flightdao.delete(f);
	}

	

	

	

}