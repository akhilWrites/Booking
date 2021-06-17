package com.booking.Booking.Controller;

import com.booking.Booking.Exception.HotelsNotFoundException;
import com.booking.Booking.domain.Booking;
import com.booking.Booking.domain.User;
import com.booking.Booking.service.BookingService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/booking")
@CrossOrigin
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<?>  createHotel(@Valid @RequestBody Booking booking , BindingResult bindingResult){

        Validate.notNull(booking);

        if (booking.getCity().isEmpty() || booking.getHotelRating()<0 || booking.getRooms()<0){
            return new ResponseEntity("City name is must , Hotel rating and Rooms must be greater than zero", HttpStatus.BAD_REQUEST);
        }

        Booking booking1 = bookingService.save(booking);
        return new ResponseEntity<>(booking1,HttpStatus.CREATED);

    }

//    @PostMapping("/{id}/checkin")
//    public ResponseEntity<?>  checkIn(@Valid @RequestBody User user , @PathVariable Long id){
//
//        Optional<Booking> booking1 = bookingService.findById(id);
//        Booking booking2 = booking1.get();
//        if (booking2.getAvailableRooms()>0){
//            booking2.setAvailableRooms(booking2.getAvailableRooms()-1);
//        }else{
//            return new ResponseEntity("No available rooms in this hotel", HttpStatus.SERVICE_UNAVAILABLE);
//        }
//
//        if (booking2.getCity().isEmpty() || booking2.getHotelRating()<0 || booking2.getRooms()<0){
//            return new ResponseEntity("City name is must , Hotel rating and Rooms must be greater than zero", HttpStatus.BAD_REQUEST);
//        }
//
//        return new ResponseEntity<>( bookingService.save(booking2),HttpStatus.CREATED);
//
//    }

    @GetMapping("/all")
    public Iterable<Booking> getAllHotels(){
        return bookingService.findAllHotels();
    }

    @GetMapping("/{city_name}")
    public Iterable<Booking> getHotelsByCity(@PathVariable  String city_name){
        Iterable<Booking> booking = bookingService.findHotelsByCity(city_name);

        List<String> collection = new ArrayList<>();
        collection.add(booking.toString());
        if (collection.get(0).length()==0){
            throw new HotelsNotFoundException("No hotels available in this city"+city_name);
        }
        return booking;
    }





}
