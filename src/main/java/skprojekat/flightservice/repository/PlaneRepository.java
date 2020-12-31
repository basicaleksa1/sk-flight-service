package skprojekat.flightservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import skprojekat.flightservice.model.Plane;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, Integer>{

//	void deleteByIdWhereFlightIdIsNull(Integer id);
	void deleteById(Integer id);
}
