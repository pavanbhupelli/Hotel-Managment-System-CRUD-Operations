package com.codegnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.codegnan.exceptions.HotelNotFoundException;

import com.codegnan.model.Hotel;
import com.codegnan.util.DBConnectionUtil;

public class HotelDaoImpl implements HotelDao{

	@Override
	public void save(Hotel hotel) {
		String sql = "insert into hotels values(?,?,?,?)";
		try (Connection con = DBConnectionUtil.getConnection(); 
				PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setInt(1, hotel.getRoomNo());
			pst.setString(2, hotel.getFloor());
			pst.setString(3, hotel.getType());
			pst.setDouble(4, hotel.getCost());

			pst.executeUpdate();
			System.out.println("Employee saved :" +hotel);

		} catch (SQLException e) {

			System.out.println("save failed :" + e.getMessage());
		}
		
		
	}

	@Override
	public List<Hotel> findAll() {
		String sql = "select *from hotels";
		List<Hotel> room = new ArrayList<>();
		try (Connection con = DBConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				room.add(new Hotel(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3),
						rs.getDouble(4)));

			}
		} catch (SQLException e) {

			System.out.println("Fetch all records failed :" + e.getMessage());

		}
		return room;
	}

	@Override
	public Hotel findById(int roomNo) throws HotelNotFoundException {
		String sql = "select *from hotels where roomNo=?";
		Hotel hm = null;
		try (Connection con = DBConnectionUtil.getConnection(); 
				PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setInt(1, roomNo);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return new Hotel(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3), 
						rs.getDouble(4));
			} else {
				throw new HotelNotFoundException(" ID not found " + roomNo);
			}
		} catch (SQLException e) {
			throw new HotelNotFoundException("Database Error :" + e.getMessage());
		}
	}

	@Override
	public void update(Hotel hotel) throws HotelNotFoundException {
		String sql = "update Hotels set floor=?,type=?,cost=? where roomNo=?";
		boolean notfound = true;
		List<Hotel> list = findAll();
		for (Hotel hm : list) {
			if (hm.getRoomNo() == hotel.getRoomNo()) {
				notfound = false;
				try (Connection con = DBConnectionUtil.getConnection();
						PreparedStatement pst = con.prepareStatement(sql)) {

					pst.setString(1, hotel.getFloor());
					pst.setString(2, hotel.getType());
					pst.setDouble(3, hotel.getCost());
					pst.setInt(4, hotel.getRoomNo());
					int rowsAffected=pst.executeUpdate();
					if(rowsAffected==0) {
						throw new HotelNotFoundException("ID Not Found for update "+hotel.getRoomNo());
					}else {
						System.out.println("updated :"+hotel);
					}
				} catch (SQLException e) {

					System.out.println("Update failed :" + e.getMessage());
				}

			}

		}
		
	}

	@Override
	public void deleteById(int roomNo) throws HotelNotFoundException {
	
		String sql = "delete from hotels where roomNo=?";
		
		try (Connection con = DBConnectionUtil.getConnection();
				PreparedStatement pst = con.prepareStatement(sql)){
			pst.setInt(1, roomNo);
			int rowsAffected=pst.executeUpdate();
			if(rowsAffected==0) {
				throw new HotelNotFoundException("ID Not Found for deletion"+roomNo);
			}else {
				System.out.println("Deleted ID"+roomNo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		
		
	}

}
