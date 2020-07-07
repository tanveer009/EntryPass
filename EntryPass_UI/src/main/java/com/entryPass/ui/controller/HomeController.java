package com.entryPass.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.entryPass.ui.model.RoleDto;
import com.entryPass.ui.model.UserDto;
import com.entryPass.ui.model.VisitorAddressDto;
import com.entryPass.ui.model.VisitorDto;

@Controller
@EnableWebMvc
public class HomeController implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/visitor").setViewName("visitor");
		registry.addViewController("/").setViewName("visitor");
		registry.addViewController("/admin").setViewName("admin");
	}

	@GetMapping({ "/visitor", "/" })
	public String visitorForm(Model model) {
		model.addAttribute("visitorDto", new VisitorDto());
		model.addAttribute("visitorAddressDto", new VisitorAddressDto());
		return "visitor";
	}

	@GetMapping("/admin")
	public String adminForm(Model model) {
		model.addAttribute("userDto", new UserDto());
		model.addAttribute("roleDto", new RoleDto());
		return "admin";
	}

	private static String[] CLASSPATH_RESOURCE_LOCATIONS = { "classpath:/static/" };

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
		WebMvcConfigurer.super.addResourceHandlers(registry);

	}
	/*
	 * @Override public void configureViewResolvers(ViewResolverRegistry registry) {
	 * InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	 * resolver.setPrefix("src/main/resources/webapp/WEB-INF/jsp/");
	 * resolver.setSuffix(".jsp"); resolver.setViewClass(JstlView.class);
	 * registry.viewResolver(resolver); }
	 */

}
