package com.D288.BackEnd.bootstrap;

import com.D288.BackEnd.dao.CustomerRepository;
import com.D288.BackEnd.dao.VacationRepository;
import com.D288.BackEnd.services.CustomerInventoryService;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Data
@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final VacationRepository vacationRepository;
    private final CustomerInventoryService customerInventoryService;

    public BootStrapData(CustomerRepository customerRepository, VacationRepository vacationRepository, CustomerInventoryService customerInventoryService) {
        this.customerRepository = customerRepository;
        this.vacationRepository = vacationRepository;
        this.customerInventoryService = customerInventoryService;
    }


    @Override
    public void run(String... args) throws Exception {

        customerInventoryService.initializeCustomers();

    }
}
