package com.adp.module.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.adp.module.entities.Cars;
import com.adp.module.entities.CarsBidding;
import com.adp.module.service.CarsService;

import java.util.List;



@Repository
public interface BidRepository extends JpaRepository<CarsBidding, Long> {

	@Query( "select b from CarBidding b where b.car in :carid" )
	List<CarsBidding> findByCarid(@Param("carid") CarsService car);
}
