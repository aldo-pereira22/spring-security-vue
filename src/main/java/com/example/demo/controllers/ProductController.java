package com.example.demo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entities.Product;
import com.example.demo.services.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins ="*" )
public class ProductController {

	@Autowired
	private ProductService service;
	
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	
	@CrossOrigin
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<?> findById(@PathVariable Long id){
		Product list = service.findById(id);
		return ResponseEntity.ok().body(list);
	}
	

	@PostMapping
	public ResponseEntity<Product> save(@RequestBody Product product ){
		product = service.save(product);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{/id}")
				.buildAndExpand(product.getId()).toUri();
		
		return ResponseEntity.created(uri).body(product);
	}
	
	
	@RequestMapping(path  = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Product> update(@RequestBody Product product , @PathVariable Long id){
		product = service.update(product, id);
		return ResponseEntity.ok().body(product);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}









