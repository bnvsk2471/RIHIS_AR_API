package com.rhode.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rhode.app.Entity.CitizenApplication;



@Repository
public interface CitizenApplicationRepo extends JpaRepository<CitizenApplication, Integer>{

}
