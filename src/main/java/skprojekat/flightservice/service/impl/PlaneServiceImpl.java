package skprojekat.flightservice.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import skprojekat.flightservice.dto.PlaneCreateDto;
import skprojekat.flightservice.dto.PlaneDto;
import skprojekat.flightservice.mapper.PlaneMapper;
import skprojekat.flightservice.repository.PlaneRepository;
import skprojekat.flightservice.service.PlaneService;

@Service
public class PlaneServiceImpl implements PlaneService{

	private PlaneRepository planeRepo;
	private PlaneMapper planeMapper;
	
	public PlaneServiceImpl(PlaneRepository planeRepo, PlaneMapper planeMapper) {
		this.planeMapper = planeMapper;
		this.planeRepo = planeRepo;
	}
	
	@Override
	public Page<PlaneDto> findAll(Pageable pageable) {
		return planeRepo.findAll(pageable).
				map(planeMapper::PlaneToPlaneDto);
	}

	@Override
	public PlaneDto findById(Integer id) {
		return planeRepo.findById(id).
				map(planeMapper::PlaneToPlaneDto).
				orElseThrow();
	}

	@Override
	public PlaneDto add(PlaneCreateDto planeCreateDto) {
		return planeMapper.PlaneToPlaneDto(planeRepo
				.save(planeMapper.PlaneCreateDtoToPlane(planeCreateDto)));
	}

	@Override
	public void deleteById(Integer id) {
		planeRepo.deleteById(id);
	}

}
