package com.concesionario.service.impl;

import com.concesionario.entity.BookingEntity;
import com.concesionario.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public void saveBooking(BookingEntity booking) {
        bookingRepository.save(booking);
    }
}
