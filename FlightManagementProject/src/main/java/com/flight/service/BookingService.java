package com.flight.service;

import java.util.List;
import java.util.Optional;

import com.flight.entities.Booking;
import com.flight.exceptions.BookingNotFoundException;


public interface BookingService {
	
	public List<Booking> getBookings();
	public Booking addBooking(Booking booking);
	public Booking updateBooking(Booking booking);
	public List<Booking> getBookingPassenger();
	public Booking getId(int id)throws BookingNotFoundException;
	public List<Booking> GetRelatedBooking();
	public List<Booking> getRelatedDate();
	public void deleteBooking(int id);
}
