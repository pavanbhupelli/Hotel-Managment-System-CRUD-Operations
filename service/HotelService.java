package com.codegnan.service;

import java.util.List;

import com.codegnan.exceptions.HotelNotFoundException;
import com.codegnan.model.Hotel;

public interface HotelService {

	void addHotel(Hotel hotel);

	List<Hotel> getAllHotel();

	Hotel getHotelDyId(int roomNo) throws HotelNotFoundException;

	void updateHotel(Hotel hotel) throws HotelNotFoundException;

	void deleteHotelId(int roomNo) throws HotelNotFoundException;
}
