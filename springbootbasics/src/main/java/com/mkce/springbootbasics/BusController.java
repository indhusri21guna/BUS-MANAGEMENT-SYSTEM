package com.mkce.springbootbasics;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bus")
public class BusController {

	@Autowired
	private BusService busService;
	//@RequestMapping(method = RequestMethod.POST, value = "/addStudent")
	@PostMapping("/addbus")
	public String add(@RequestBody Bus s) {
		busService.addbus(s);
		return "Item Added Successfully";
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable long id)
	{
		busService.del(id);
		return "deleted";
	}
	@GetMapping("/get/{id}")
	public Optional get(@PathVariable long id)
	{
		return busService.g(id);
	}
	@PutMapping("/updatebus/{id}")
	public void updatebus(@PathVariable long id,@RequestBody Bus a)
	{
	    busService.upi(id,a);
	}
}
