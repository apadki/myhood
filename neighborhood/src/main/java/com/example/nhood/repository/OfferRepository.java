package com.example.nhood.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.nhood.entities.OfferEntity;

public interface OfferRepository extends CrudRepository<OfferEntity, Integer>{

  List<OfferEntity> findByUserId(Integer id);
}
