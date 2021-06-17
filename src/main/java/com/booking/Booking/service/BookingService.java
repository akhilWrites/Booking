package com.booking.Booking.service;

import com.booking.Booking.Repositories.BookingRepository;
import com.booking.Booking.domain.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

//find all hotels
    public Iterable<Booking> findAllHotels(){
        return bookingRepository.findAll();
    }

    public Optional<Booking> findById(Long id){
        return bookingRepository.findById(id);
    }

    public Booking save(Booking booking){
        return bookingRepository.save(booking);
    }

    public Iterable<Booking> findHotelsByCity(String city){
        return bookingRepository.findHotelsByCity(city);
    }

//    public Iterable<Booking> findHotelsByRoomsInCity(String city, String rooms){
//
//        Iterable<Booking> booking1 = bookingRepository.findHotelsByCity(city);
//        Iterable<Booking> bookings2 = bookingRepository.findHotelsInCitiByRooms(rooms);
//
//        if (booking1.equals(bookings2))

//        return bookingRepository.findHotelsByRooms(city,rooms);


//    }

}
