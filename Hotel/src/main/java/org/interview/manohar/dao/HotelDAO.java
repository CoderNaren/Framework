package org.interview.manohar.dao;

import java.util.List;

import org.interview.manohar.model.Hotel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HotelDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Hotel> getAllHotels() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Hotel> hotelList = session.createQuery("from Hotel").list();
		return hotelList;
	}

	public Hotel getHotel(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Hotel hotel = (Hotel) session.load(Hotel.class, new Integer(id));
		return hotel;
	}

	public Hotel addHotel(Hotel hotel) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(hotel);
		return hotel;
	}

	public void updateHotel(Hotel hotel) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(hotel);
	}

	public void deleteHotel(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Hotel p = (Hotel) session.load(Hotel.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	}	
}
