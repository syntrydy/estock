package com.gasmyr.it.controller.location;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gasmyr.it.model.Location;
import com.gasmyr.it.service.location.LocationService;
import com.gasmyr.it.service.shop.ShopService;

@Controller
public class LocationController {

	@Autowired
	LocationService locationService;
	@Autowired
	ShopService shopService;

	@RequestMapping(value = "/LocationListPage", method = RequestMethod.GET)
	public String goToLocationListPage(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "9") int size, Model model, Pageable pageable) {
		pageable = new PageRequest(page, size, new Sort("id"));
		Page<Location> locations = locationService.findAllByPage(pageable);
		model.addAttribute("locations", locations);
		int currentpage = page + 1;
		int totalpage = locations.getTotalPages();
		model.addAttribute("currentpage", currentpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("url", "/LocationListPage");
		return "/LocationListPage";
	}

	@RequestMapping(value = "/LocationAddPage", method = RequestMethod.GET)
	public String goToLocationAddPage(Model model) {
		model.addAttribute("location", new Location());
		model.addAttribute("shops", shopService.findAll());
		return "/LocationAddPage";
	}

	@RequestMapping(value = "/updatelocation", method = RequestMethod.GET)
	public String goToLocationUpdatePage(@RequestParam long id, Model model) {
		model.addAttribute("location", locationService.findById(id));
		model.addAttribute("shops", shopService.findAll());
		return "/LocationUpdatePage";
	}

	@RequestMapping(value = "/locationdetail", method = RequestMethod.GET)
	public String goToLocationDetailPage(@RequestParam long id, Model model) {
		model.addAttribute("location", locationService.findById(id));
		return "/LocationDetailPage";
	}

	@RequestMapping(value = "/location/create", method = RequestMethod.POST)
	public String saveLocation(@Valid Location location, BindingResult bindingResult) {
		locationService.add(location);
		return "redirect:/LocationListPage";
	}

	@RequestMapping(value = "/location/{id}/update", method = { RequestMethod.POST, RequestMethod.PUT,
			RequestMethod.PATCH })
	public String updateShop(@PathVariable Long id, @Valid Location location, Model model,
			BindingResult bindingResult) {
		locationService.update(id, location);
		return "redirect:/LocationListPage";
	}
	
	@RequestMapping(value = "/location/{id}/delete")
	public String deleteLocation(@PathVariable Long id) {
		locationService.deleteById(id);
		return "redirect:/LocationListPage";
	}

}
