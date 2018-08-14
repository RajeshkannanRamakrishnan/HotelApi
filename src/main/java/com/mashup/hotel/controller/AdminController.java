package com.mashup.hotel.controller;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mashup.hotel.dao.GuestRepository;
import com.mashup.hotel.model.Guest;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	GuestRepository guestRepository;

	@RequestMapping(value="/allGuest",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Guest> getAllGuest(){
		List<Guest> allCheckedInGuest= new ArrayList<Guest>();
	    Iterator<Guest>	itr=guestRepository.findAll().iterator();
		while(itr.hasNext()) {
			allCheckedInGuest.add(itr.next());
		  }
			return allCheckedInGuest;
		}
	
	@RequestMapping(value="/guest",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Guest> getAllGuestCheckInTime( @RequestParam("firstName") String firstName,
			 @RequestParam("contact") String contact){
		//List<Guest> allCheckedInGuest= new ArrayList<Guest>();
//	    Iterator<Guest>	itr=guestRepository.findAll().iterator();
//		while(itr.hasNext()) {
//			allCheckedInGuest.add(itr.next());
//		  }
		
		return guestRepository.findAllByfirstNameAndcontact(firstName, contact);
		//	return allCheckedInGuest;
		}
	
	
}