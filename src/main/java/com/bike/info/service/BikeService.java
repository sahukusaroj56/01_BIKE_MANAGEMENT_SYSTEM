package com.bike.info.service;

import com.bike.info.entity.Bike;
import com.bike.info.repository.BikeRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BikeService {

    @Autowired
    public BikeRepository bikeRepository;
    public List<Bike> getAllBikes(){
        return bikeRepository.findAll();
    }

    public Optional<Bike> getBikeById(Long id){
        return bikeRepository.findById(id);
    }

    public Bike addBike(Bike bike){
        return bikeRepository.save(bike);
    }

    public Bike updateBike(Long id,Bike updateBike){

        return bikeRepository.findById(id).map(bike -> {bike.setBrand(updateBike.getBrand());
                                                        bike.setModel(updateBike.getModel());
                                                        bike.setPrice(updateBike.getPrice());
                                                        return bikeRepository.save(bike);
        }).orElse(null);

    }
    public String deleteBike(Long id) {
        if (bikeRepository.existsById(id)) {
            bikeRepository.deleteById(id);
            return "Bike deleted successfully!";
        }
        return "Bike not found!";
    }

}
