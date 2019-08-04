package com.stackroute.muzixapp.repository;

import com.stackroute.muzixapp.domain.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends MongoRepository<Track,Integer> {
/*
    @Query("SELECT t FROM Track t WHERE t.name = ?1")
    List<Track> getTrackbyName(String name);*/
}