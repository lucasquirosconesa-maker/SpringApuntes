package com.vedrunaSevilla.product.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vedrunaSevilla.product.persistance.model.Trainer;

public interface TrainerRespository extends JpaRepository<Trainer, Long> {

}