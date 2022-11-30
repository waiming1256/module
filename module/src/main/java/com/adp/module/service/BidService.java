package com.adp.module.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adp.module.entities.Cars;
import com.adp.module.entities.CarsBidding;
import com.adp.module.repository.BidRepository;




@Service
@Transactional
public class BidService {
	@Autowired
	static
	BidRepository repo;

	@Autowired
    private BidRepository bidRepository;

	public CarsBidding save(CarsBidding carBiding) {		
        return repo.save(carBiding);	
	}

	public List<CarsBidding> listAll() {
		return (List<CarsBidding>) repo.findAll();
	}

	public static List<CarsBidding> listBidInfo(CarsService car) {
		return (List<CarsBidding>) repo.findByCarid(car);
	}

}
