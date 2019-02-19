package org.recro.hotels.service;

import java.util.List;
import org.recro.hotels.dao.HotelDAO;
import org.recro.hotels.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("hotelService")
public class HotelService {

	@Autowired
	HotelDAO hotelDao;
	
	@Transactional
	public List<Hotel> getAllHotels() {
		return hotelDao.getAllHotels();
	}

	@Transactional
	public Hotel getHotel(int id) {
		return hotelDao.getHotel(id);
	}

	@Transactional
	public void addHotel(Hotel hotel) {
		hotelDao.addHotel(hotel);
	}

	@Transactional
	public void updateHotel(Hotel hotel) {
		hotelDao.updateHotel(hotel);

	}

	@Transactional
	public void deleteHotel(int id) {
		hotelDao.deleteHotel(id);
	}
}
