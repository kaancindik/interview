package com.vodafone.interview.senior.repository;

import com.vodafone.interview.senior.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CarRepository extends JpaRepository<CarEntity, Integer> {

    Optional<CarEntity> getCarEntityById(Integer id);
}
