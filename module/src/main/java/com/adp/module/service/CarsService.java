package com.adp.module.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.core.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adp.module.controller.Carcontroller;
import com.adp.module.entities.Cars;
import com.adp.module.repository.CarsRepository;

@Service
@Transactional
public class CarsService {
  
	private static final Logger logger = (Logger) LoggerFactory.getLogger(Carcontroller.class);

    @Autowired
    private CarsRepository carsRepository;

 

    public List<CarsService> getAllCars() {
        try {
			return carsRepository.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
    
    //used for both update and Save Car
    public Cars saveCar(Cars cars) {
      return CarsRepository.saveAll(cars);
    }
    
	public CarsService get(Long id) {
		return carsRepository.findById(id).get();
	}

	
	public void delete(Long id) {
		carsRepository.deleteById(id);
	}
	
	public List<CarsService> search(String keyword) {
		return carsRepository.search(keyword);
		
		}

	public void updateCar(Cars cars) {
		// TODO Auto-generated method stub
		
	}

	public CarsService findCarById(long id) {
		// TODO Auto-generated method stub
		return get(id);
	}

	public void save(Cars updateCar) {
		// TODO Auto-generated method stub
		
	}

}