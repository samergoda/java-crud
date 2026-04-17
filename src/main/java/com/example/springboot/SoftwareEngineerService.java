package com.example.springboot;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {
    final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return softwareEngineerRepository.findAll();
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.save(softwareEngineer);
    }

    public SoftwareEngineer findSoftwareEngineerById(Integer id) {
        return softwareEngineerRepository.findById(id).orElseThrow(() -> new IllegalStateException("no user found"));
    }

    public void deleteSoftwareEngineerById(Integer id) {
        softwareEngineerRepository.deleteById(id);
    }

    public void updateSoftwareEngineer(Integer id, SoftwareEngineer update) {
        SoftwareEngineer softwareEngineer = findSoftwareEngineerById(id);

        softwareEngineer.setName(update.getName());
        softwareEngineer.setTechStack(update.getTechStack());

        softwareEngineerRepository.save(softwareEngineer);
    }
}
