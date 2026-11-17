package com.vedrunaSevilla.product.service;

import java.util.List;

import com.vedrunaSevilla.product.persistance.model.Trainer;

public interface TrainerService {
public List<Trainer> getAllTrainers();
    public Trainer getTrainerById(Long id);
    public Trainer createTrainer(Trainer Trainer);
    public Trainer updateTrainer(Long id, Trainer Trainer);
    public void deleteTrainer(Long id);
}
