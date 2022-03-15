package com.project.workflow.controller;

import com.project.core.entities.Customer;
import com.project.workflow.entities.Cards;
import com.project.workflow.repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {
	
	@Autowired
	private CardsRepository cardsRepository;
	
	@PostMapping("/myCards")
	public List<Cards> getCardDetails(@RequestBody Customer customer) {
		List<Cards> cards = cardsRepository.findByEmail(customer.getEmail());
		if (cards != null ) {
			return cards;
		}else {
			return null;
		}
	}

}
