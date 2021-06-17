package com.booking.Booking.Controller;

import com.booking.Booking.domain.Booking;
import com.booking.Booking.domain.User;
import com.booking.Booking.service.BookingService;
import com.booking.Booking.service.UserService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookingService bookingService;

    @PostMapping("/{id}/checkin")
    public ResponseEntity<?> userCheckIn(@Valid @RequestBody User user , @PathVariable Long id ){

        Validate.notNull(user);

        Optional<Booking> booking1 = bookingService.findById(id);
        Booking booking2 = booking1.get();

        if (booking2.getId().equals(id) && booking2.getAvailableRooms()>0){
            user.setCheckInDate(new Date());
            user.setCreatedAt(new Date());
            booking2.setAvailableRooms(booking2.getAvailableRooms()-1);
        }else{
            return new ResponseEntity("No available rooms in this hotel or Hotel doesn't exists", HttpStatus.BAD_REQUEST);
        }

        user.setBookingInformation(booking2);
        return new ResponseEntity<>(user,HttpStatus.CREATED);

    }

//    rework this one
    @GetMapping("/{user_id}")
    public Optional<User> getUser(@PathVariable Long user_id ){
        Optional<User> user = userService.findById(user_id);
        return user;
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> editUser(@RequestBody User user ,@PathVariable Long id){
        userService.findById(id);

        return  new ResponseEntity<>(userService.edit(user),HttpStatus.OK);
    }
}
