package com.mrk.springcloud.model;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mrk.springcloud.dto.Coupon;
import com.mrk.springcloud.repos.ProductRepo;

@RestController
@RequestMapping("/productapi")
@Tag(name = "Product APIs", description = "Product Microservice APIs")
public class ProductRestControllers {
	
	@Autowired
    private	ProductRepo repo;
	@Autowired
	private RestTemplate restTemplet;
	
	@Value("${couponservice.url}")
	private String couponServiceURL;
	
	
	@RequestMapping(value = "/products",method = RequestMethod.POST)
    @Operation(summary = "Create products ")
	public Product create(@RequestBody Product product ) {
		 Coupon cupon  =restTemplet.getForObject(couponServiceURL+product.getCouponCode(), Coupon.class);
		 product.setPrice(product.getPrice().subtract(cupon.getDiscount()));
		return repo.save(product);
	}

}
