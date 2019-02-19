package org.interview.manohar.controller;

import java.util.List;
import org.interview.manohar.model.Hotel;
import org.interview.manohar.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {
	
	@Autowired
	HotelService hotelService;
	
	@RequestMapping(value = "/getAllHotels", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Hotel> getHotels() {
		
		List<Hotel> listOfHotels = hotelService.getAllHotels();
		return listOfHotels;
	}

	@RequestMapping(value = "/getHotel/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Hotel getHotelById(@PathVariable int id) {
		return hotelService.getHotel(id);
	}

	@RequestMapping(value = "/addHotel", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addHotel(@RequestBody Hotel hotel) {	
		hotelService.addHotel(hotel);
		
	}

	@RequestMapping(value = "/updateHotel", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateHotel(@RequestBody Hotel hotel) {
		hotelService.updateHotel(hotel);
	}

	@RequestMapping(value = "/deleteHotel/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteHotel(@PathVariable("id") int id) {
		hotelService.deleteHotel(id);		
	}	
}
