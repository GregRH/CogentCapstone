package com.cogent.config;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.cogent.bo.Category;
import com.cogent.bo.Order;
import com.cogent.bo.Product;
@Component
public class ExposeEntityIdRestMvcConfiguration implements RepositoryRestConfigurer {
    @Override
	    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
	        config.exposeIdsFor(Product.class);
	        config.exposeIdsFor(Category.class);
	        config.exposeIdsFor(Order.class);
	    }
	}
