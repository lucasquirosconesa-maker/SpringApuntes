package com.vedrunaSevilla.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vedrunaSevilla.product.persistance.model.Trainer;
import com.vedrunaSevilla.product.persistance.repository.TrainerRespository;

@Service
public class TrainerServiceImpl implements TrainerService {

    TrainerRespository trainerRespository;

    public TrainerServiceImpl(TrainerRespository trainerRespository) {
        this.trainerRespository = trainerRespository;
    }

    @Override
    public List<Trainer> getAllTrainers() {
        return trainerRespository.findAll();
    }

    @Override 
    public Trainer getTrainerById(Long id) {
        return trainerRespository.findById(id).orElseThrow(() -> new RuntimeException("Trainer not found with id: " + id));
    }

    @Override
    public Trainer createTrainer(Trainer trainer) {
        return trainerRespository.save(trainer);
    }
    @Override 
    public Trainer updateTrainer(Long id, Trainer trainer) {
        Trainer existingTrainer = trainerRespository.findById(id).orElseThrow(() -> new RuntimeException("Trainer not found with id: " + id));
        existingTrainer.setName(trainer.getName());
        existingTrainer.setHometown(trainer.getHometown());
        return trainerRespository.save(existingTrainer);
    }
    @Override 
    public void deleteTrainer(Long id) {
        Trainer existingTrainer = trainerRespository.findById(id).orElseThrow(() -> new RuntimeException("Trainer not found with id: " + id));
        trainerRespository.delete(existingTrainer);
    }
}
