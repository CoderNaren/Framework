package org.recro.hotels.controller;


import java.util.List;

import org.recro.hotels.model.Hotel;
import org.recro.hotels.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HotelController {
	
	@Autowired
	HotelService hotelService;
	
	@RequestMapping(value = "/getAllHotels", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getCountries(Model model) {
		
		List<Hotel> listOfHotels = hotelService.getAllHotels();
		model.addAttribute("hotel", new Hotel());
		model.addAttribute("listOfHotels", listOfHotels);
		return "hotelDetails";
	}

	@RequestMapping(value = "/getHotel/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Hotel getHotelById(@PathVariable int id) {
		return hotelService.getHotel(id);
	}

	@RequestMapping(value = "/addHotel", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addHotel(@ModelAttribute("hotel") Hotel hotel) {	
		if(hotel.getId()==0)
		{
			hotelService.addHotel(hotel);
		}
		else
		{	
			hotelService.updateHotel(hotel);
		}
		
		return "redirect:/getAllHotels";
	}

	@RequestMapping(value = "/updateHotel/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateHotel(@PathVariable("id") int id,Model model) {
		 model.addAttribute("hotel", this.hotelService.getHotel(id));
	     model.addAttribute("listOfHotels", this.hotelService.getAllHotels());
	     return "hotelDetails";
	}

	@RequestMapping(value = "/deleteHotel/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteHotel(@PathVariable("id") int id) {
		hotelService.deleteHotel(id);
		return "redirect:/getAllHotels";

	}	
}
