package com.springboot.jasperreports;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jasperreports.entity.Products;
import com.springboot.jasperreports.repository.ProductsRepository;
import com.springboot.jasperreports.service.ReportService;

import net.sf.jasperreports.engine.JRException;

@SpringBootApplication
@RestController
public class JasperreportsApplication {
	Logger logger = Logger.getLogger(getClass().getName());
	
	private ProductsRepository repository;
	private ReportService service;
	
	public JasperreportsApplication(ProductsRepository repository, ReportService service) {
		this.repository = repository;
		this.service = service;
	}

	@GetMapping("/products")
	public List<Products> getAllProducts(){
		return repository.findAll();
	}
	
	@GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
        return service.exportReport(format);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(JasperreportsApplication.class, args);
	}
	
	@Bean
	CommandLineRunner commandLineRunner(ProductsRepository repository) {
		return args-> {
			Products samsungProduct = new Products();
			samsungProduct.setProductName("Samsung Galaxy S24");
			samsungProduct.setProductCategory("Mobile Phones");
			samsungProduct.setProductPrice(74999.50);
			repository.save(samsungProduct);
			
			Products iPhoneProducts = new Products();
			iPhoneProducts.setProductName("IPhone 13 Pro");
			iPhoneProducts.setProductCategory("Mobile Phones");
			iPhoneProducts.setProductPrice(94999.99);
			repository.save(iPhoneProducts);
			
			Products laptopDellProduct = new Products();
			laptopDellProduct.setProductName("Dell Inspiron 15.6Inch 3588");
			laptopDellProduct.setProductCategory("Laptops");
			laptopDellProduct.setProductPrice(52499.00);
			repository.save(laptopDellProduct);
			
			Products homeFurniture = new Products();
			homeFurniture.setProductName("Ikea Show Holder CupBorad");
			homeFurniture.setProductCategory("Home Furniture");
			homeFurniture.setProductPrice(27899.00);
			repository.save(homeFurniture);
		};
	}

}
