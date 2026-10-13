package com.example.fullstack1;
import com.example.fullstack1.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.Arrays;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {

	private static final Logger logger =
			LoggerFactory.getLogger(CardatabaseApplication.class);

	private final CarRepository repository;
	private final OwnerRepository orepository;
	private final AppUserRepository urepository;
	private final PasswordEncoder passwordEncoder;

	public CardatabaseApplication(CarRepository repository,
                                  OwnerRepository orepository, AppUserRepository urepository, PasswordEncoder passwordEncoder) {
		this.repository = repository;
		this.orepository = orepository;
		this.urepository = urepository;
        this.passwordEncoder = passwordEncoder;
	}

	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Owner owner1 = new Owner("John", "Johnson");
		Owner owner2 = new Owner("Mary", "Robinson");
		orepository.saveAll(Arrays.asList(owner1, owner2));

		repository.save(new Car("Ford", "Mustang", "Red",
				"ADF-1121", 2023, 59000, owner1));
		repository.save(new Car("Nissan", "Leaf", "White",
				"SSJ-3002", 2020, 29000, owner2));
		repository.save(new Car("Toyota", "Prius", "Silver",
				"KKO-0212", 2022, 39000, owner2));

		for (Car car : repository.findAll()) {
			logger.info("brand: {}, model: {}", car.getBrand(), car.getModel());
		}
		// Username: user, password: user
		urepository.save(new AppUser("user", passwordEncoder.encode("user"), "USER"));
		// Username: admin, password: admin
		urepository.save(new AppUser("admin",passwordEncoder.encode("admin"), "ADMIN"));
	}

}