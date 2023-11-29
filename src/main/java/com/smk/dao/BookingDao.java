package com.smk.dao;

import com.smk.model.Booking;

import java.sql.Connection;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

public class BookingDao implements Dao<Booking, Integer> {
    private final Optional<Connection> connection;
    public BookingDao(){
        connection = JdbcConnection.getConnection();
    }

    @Override
    public Optional<Booking> get(int id) {
        return Optional.empty();
    }

    @Override
    public Collection<Booking> getAll() {
        return null;
    }

    @Override
    public Optional<Integer> save(Booking booking) {
        Booking nonNullBooking = Objects.requireNonNull(booking);
        String sql = "INSERT INTO booking (schedule_id, name, price) " + "VALUES(?,?,?";
        return Optional.empty();
    }

    @Override
    public void update(Booking booking) {

    }

    @Override
    public void delete(Booking booking) {

    }

    @Override
    public Collection<Booking> search(String keyword) {
        return null;
    }

    public Collection<Booking> searchBooking(String searchTerm) {
        return null;
    }
}

