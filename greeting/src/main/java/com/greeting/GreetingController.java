package com.greeting;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/greeting")
public class GreetingController {
	    @Autowired
	    private GreetingRepository greetingRepository;
	        
	    @GetMapping
	    public List<Greeting> findAllGreetings() {
	    	return (List<Greeting>) greetingRepository.findAll();
	    }
	 
	    @GetMapping("/{id}")
	    public ResponseEntity<Greeting> findGreetingById(@PathVariable(value = "id") int id) {
	    	Optional<Greeting> Greeting = greetingRepository.findById(id);
	    	if(Greeting.isPresent()) {
	            return ResponseEntity.ok().body(Greeting.get());
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	 
	    @PostMapping
	    public Greeting saveGreeting(@RequestBody Greeting greeting) {
	        return greetingRepository.save(greeting);
	    }
	}

