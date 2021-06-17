package com.booking.Booking.Repositories;

import com.booking.Booking.domain.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<Booking , Long> {

    Iterable<Booking> findHotelsByCity(String city);

    Iterable<Booking> findHotelsInCitiByRooms(String rooms);

}
