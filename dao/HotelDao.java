package com.codegnan.dao;

import java.util.List;

import com.codegnan.exceptions.HotelNotFoundException ;
import com.codegnan.model.Hotel;

public interface HotelDao {
	void save(Hotel hotel);

	List<Hotel> findAll();

	Hotel findById(int roomNo) throws HotelNotFoundException;

	void update(Hotel hotel) throws HotelNotFoundException;

	void deleteById(int roomNo) throws  HotelNotFoundException;

}
