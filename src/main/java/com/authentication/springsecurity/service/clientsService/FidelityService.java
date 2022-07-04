package com.authentication.springsecurity.service.clientsService;

import com.authentication.springsecurity.entity.entityClients.FidelityCard;
import com.authentication.springsecurity.repository.FidelityRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:3000")
@Service
@AllArgsConstructor
public class FidelityService {
    @Autowired
    FidelityRepository fidelityRepository;
    public  FidelityCard SaveFidelity(FidelityCard fidelity) {
        return fidelityRepository.save(fidelity);
    }
}
