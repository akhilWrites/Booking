package com.booking.Booking.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hotelName;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank
    private Date checkAvailability;

    @NotBlank
    private Integer rooms;

    private Integer accomodation;

    @NotBlank
    private Integer hotelRating;

    private Double costOfStay;

    private Boolean isWifi;

    private Boolean isAc;

    private Boolean isMeals;
    private Boolean isRestaurant;
    private Integer totalRooms=10;
    private Integer availableRooms=10;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date updatedAt;

    public Integer getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(Integer availableRooms) {
        this.availableRooms = availableRooms;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Integer getTotalRooms() {
        return totalRooms;
    }

    public void setTotalRooms(Integer totalRooms) {
        this.totalRooms = totalRooms;
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updatedAt=new Date();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getHotelRating() {
        return hotelRating;
    }

    public void setHotelRating(Integer hotelRating) {
        this.hotelRating = hotelRating;
    }

    public Integer getAccomodation() {
        return accomodation;
    }

    public void setAccomodation(Integer accomodation) {
        this.accomodation = accomodation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getCheckAvailability() {
        return checkAvailability;
    }


    public void setCheckAvailability(Date checkAvailability) {
        this.checkAvailability = checkAvailability;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }



    public Double getCostOfStay() {
        return costOfStay;
    }

    public void setCostOfStay(Double costOfStay) {
        this.costOfStay = costOfStay;
    }

    public Boolean getWifi() {
        return isWifi;
    }

    public void setWifi(Boolean wifi) {
        isWifi = wifi;
    }

    public Boolean getAc() {
        return isAc;
    }

    public void setAc(Boolean ac) {
        isAc = ac;
    }

    public Boolean getMeals() {
        return isMeals;
    }

    public void setMeals(Boolean meals) {
        isMeals = meals;
    }

    public Boolean getRestaurant() {
        return isRestaurant;
    }

    public void setRestaurant(Boolean restaurant) {
        isRestaurant = restaurant;
    }

}
