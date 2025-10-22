package com.codegnan.service;

import java.util.List;

import com.codegnan.dao.HotelDao;
import com.codegnan.dao.HotelDaoImpl;
import com.codegnan.exceptions.HotelNotFoundException;
import com.codegnan.model.Hotel;

public class HotelServiceImpl implements HotelService{
	HotelDaoImpl dao=new HotelDaoImpl();

	@Override
	public void addHotel(Hotel hotel) {
		dao.save(hotel);
		
	}

	@Override
	public List<Hotel> getAllHotel() {
		return dao.findAll();
	}

	@Override
	public Hotel getHotelDyId(int roomNo) throws HotelNotFoundException {
		return dao.findById(roomNo);
	}

	@Override
	public void updateHotel(Hotel hotel) throws HotelNotFoundException {
		dao.update(hotel);
		
	}

	@Override
	public void deleteHotelId(int roomNo) throws HotelNotFoundException {
		dao.deleteById(roomNo);
		
	}

	

	

}
