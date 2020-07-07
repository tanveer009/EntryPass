package com.entryPass.ui.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.entryPass.ui.model.VisitorDto;
import com.entryPass.ui.service.VisitorUIService;

@RequestMapping("/rest/visitorui")
@RestController
public class VisitorUIController implements WebMvcConfigurer{

	@Autowired
	VisitorUIService visitorService;

	@RequestMapping("/find/{id}")
	public VisitorDto getVisitorById(@PathVariable Integer id) {
		return visitorService.getVisitorById(id);
	}

	@RequestMapping("/find/all")
	public List<VisitorDto> getAllVisitors() {
		return visitorService.getAllVisitors();
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void saveVisitor(@RequestParam Map<String, String> visitorDto, ModelMap modelMap) {
		visitorService.saveVisitor(visitorDto);
		modelMap.addAttribute("msg", "Saved Successfully");
		//return "visitor";
	}

}
