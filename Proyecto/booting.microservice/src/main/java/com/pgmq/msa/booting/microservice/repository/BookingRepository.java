package com.pgmq.msa.booting.microservice.repository;

import com.pgmq.msa.booting.microservice.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
