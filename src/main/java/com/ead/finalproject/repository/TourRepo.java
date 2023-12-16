package com.ead.finalproject.repository;

import com.ead.finalproject.model.Tour;
import com.ead.finalproject.model.TourType;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TourRepo extends JpaRepository<Tour, Long> {

}
