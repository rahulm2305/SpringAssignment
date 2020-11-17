package controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Electricity;

@RestController
@RequestMapping("/bill")
public class ElectricityController {
	@RequestMapping(value="/{initialReading}/{thisMonthReading}", method=RequestMethod.GET)
	public String validateUser(@PathVariable double initialReading, @PathVariable double thisMonthReading) {
		Electricity electricity = new Electricity(initialReading, thisMonthReading);
		electricity.setTotalBill((electricity.getThisMonthReading()-electricity.getInitialReading())*Electricity.COST_PER_UNIT);
		return "Total Bill : "+electricity.getTotalBill();
	}
}
