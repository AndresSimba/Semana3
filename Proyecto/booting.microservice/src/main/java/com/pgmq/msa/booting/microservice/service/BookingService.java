package com.pgmq.msa.booting.microservice.service;

import com.pgmq.msa.booting.microservice.entity.Booking;
import com.pgmq.msa.booting.microservice.repository.BookingRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }
    private Booking
}
