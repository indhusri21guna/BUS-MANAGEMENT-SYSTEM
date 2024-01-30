package com.mkce.springbootbasics;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusService {

	@Autowired
	private BusRepository busRepository;
	
	public void addid(Bus s) {
		 busRepository.save(s);
	}
	public void del(long id)
	{
		busRepository.deleteById(id);
	}
	public Optional g(long id)
	{
	    return busRepository.findById(id);
	}
	public void upi(long id,Bus a)
	{
       Optional<Bus> m=busRepository.findById(id);
       if(m.isPresent())
       {
    	   Bus o=m.get();
    	   o.setdest_location(a.getdest_location());
    	   o.setBus_id(a.getBus_id());
    	   o.setsource_location(a.getsource_location());
    	   o.setbus_fare(a.getbus_fare());
    	   busRepository.save(o);
       }
	}
}  
