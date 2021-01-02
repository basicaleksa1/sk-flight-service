package skprojekat.flightservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import skprojekat.flightservice.dto.PlaneCreateDto;
import skprojekat.flightservice.dto.PlaneDto;

@Service
public interface PlaneService {

	Page<PlaneDto> findAll(Pageable pageable);
	
	PlaneDto findById(Integer id);
	
	PlaneDto add(PlaneCreateDto planeCreateDto);
	
	void deleteById(Integer id);
}
