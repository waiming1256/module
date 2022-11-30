package com.adp.module.controller;



import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import com.adp.module.entities.Cars;
import com.adp.module.entities.CarsBidding;
import com.adp.module.service.BidService;
import com.adp.module.service.CarsService;
import com.adp.module.service.UserService;
import com.lithan.ac.springboot_car_portal_demo.controller.CarController;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Controller

public class Carcontroller {

	  private static Logger logger = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private CarsService carsService;

    
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String handleRootRequest(Model model) {
        return "redirect:cars";
    }

    @GetMapping("cars")
    public String viewCars(Model model) {
        List<CarsService> cars = carsService.getAllCars();
        if(!CollectionUtils.isEmpty(cars)) {
            model.addAttribute("cars", cars);
        }
        return "view_cars";
    }
//    
//    @GetMapping("api/cars")
//    @ResponseBody
//    public List<Car> getCars(){
//    	List<Car> cars= carService.getAllCars();
//    	return cars;
//    }
    
    @GetMapping("new_car")
	public String newUserForm(Map<String, Object> model) {
    	System.out.println("To show add new car page");
		Cars cars = new Cars();
		model.put("car", cars);
		return "new_car";
	}

    @PostMapping("cars")
    public String saveCar(Cars cars, Model model) {
    	
    	System.out.println("Save & Update new car");
        carsService.saveCar(cars);	       
        return "redirect:cars";
    }
    

    /* For Bidding */
    @GetMapping("car_detail")
	public ModelAndView viewCar(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("car_detail");
		CarsService car = carsService.get(id);
		mav.addObject("car", car);
		BidService carbidService = null;
		mav.addObject("bidinfo", BidService.listBidInfo((car)));
	return mav;
	}
    
    @PostMapping("car_detail")
	   public String saveBit(@RequestParam(value="id", required = false) Long id,
	                           @RequestParam("bitprice") String bitprice,
	                           Model model) {
		   
		  //To post the bid information into the database 
		  //Get User name
		   String uname="";
		   Object principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		   if(principal instanceof UserDetails) {
			    uname=((UserDetails) principal).getUsername();
			 
		   }
		   else {
			    uname=principal.toString();
		   }
		   
		   Long carid=id;
		   CarsService car = carsService.get(id);
		   User user=(User) userService.getUserByName(uname);
		   Date cur_time=new Date();
		   

	       CarsBidding carBitInfo = new CarsBidding();
	       carBitInfo.setBidderName(uname);
	       carBitInfo.setBidderPrice(bitprice);
	       carBitInfo.setCar(car);
	       carBitInfo.setUser(user);
	       carBitInfo.setBid_date_time(cur_time);
	      
	       logger.debug("Car Bidder Price:{}, Car ID: {}", carBitInfo.getBidderPrice(),carBitInfo.getId(),carBitInfo.getBidderName(),carBitInfo.getCar());
	       
	       try {
			try {
				CarsBidding savedCar = new CarsBidding();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	       model.addAttribute("car", car);		
	       model.addAttribute("bidinfo", BidService.listBidInfo(car));
	       
	       return "car_detail";
	 }
    /*End For Bidding*/
	
    @GetMapping("edit")
	public String editCarForm(@RequestParam long id, Model model) {
    	System.out.println("Update car controller method");
		CarsService car = carsService.get(id);
		model.addAttribute("car", car);
		return "new_car";
	}
    
	
	
	@RequestMapping("delete")
	public String deleteCar(@RequestParam long id) {
		carsService.delete(id);
		return "redirect:/cars";		
	}
	
	
	@RequestMapping("search")
	public ModelAndView search(@RequestParam String keyword) {
		List<CarsService> result = carsService.search(keyword);
		ModelAndView mav = new ModelAndView("search_car_results");
		mav.addObject("keyword", keyword);
		mav.addObject("search_cars", result);
		return mav;		
	}	

    
    
}
