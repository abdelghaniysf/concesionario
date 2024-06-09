package com.concesionario.service.impl;

import com.concesionario.entity.BookingEntity;
import com.concesionario.entity.CarEntity;
import com.concesionario.entity.user.UserEntity;
import com.concesionario.repository.BookingRepository;
import com.concesionario.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public void saveBooking(BookingEntity booking) {
        bookingRepository.save(booking);
    }

    public List<BookingEntity> getBookingsByUser(UserEntity user) {
        return bookingRepository.findAllByUser(user);
    }

    public void cancelBooking(Long bookingId) {
        BookingEntity booking = bookingRepository.findById(bookingId).orElseThrow(() -> new RuntimeException("Booking not found"));
        CarEntity car = booking.getCar();
        car.setAvailable(true);
        carRepository.save(car);
        bookingRepository.deleteById(bookingId);
    }
}
