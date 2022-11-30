package com.adp.module.repository;





import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.adp.module.entities.Cars;
import com.adp.module.service.CarsService;





@Repository
public interface CarsRepository extends JpaRepository<CarsService, Long> {
	
    
    @Query(value = "SELECT c FROM Car c WHERE c.make LIKE '%' || :keyword || '%'"
			+ " OR c.model LIKE '%' || :keyword || '%'"
			+ " OR c.price LIKE '%' || :keyword || '%'")
	public List<CarsService> search(@Param("keyword") String keyword);

	public static Cars saveAll(Cars cars) {
		// TODO Auto-generated method stub
		return null;
	}


}
