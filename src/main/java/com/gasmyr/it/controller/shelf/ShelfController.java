package com.gasmyr.it.controller.shelf;

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

import com.gasmyr.it.model.Shelf;
import com.gasmyr.it.service.location.LocationService;
import com.gasmyr.it.service.shelf.ShelfService;

@Controller
public class ShelfController {
	@Autowired
	ShelfService shelfService;
	@Autowired
	LocationService locationService;

	@RequestMapping(value = "/ShelfListPage", method = RequestMethod.GET)
	public String goToShelfListPage(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "9") int size, Model model, Pageable pageable) {
		pageable = new PageRequest(page, size, new Sort("id"));
		Page<Shelf> shelves = shelfService.findAllByPage(pageable);
		model.addAttribute("shelves", shelves);
		int currentpage = page + 1;
		int totalpage = shelves.getTotalPages();
		model.addAttribute("currentpage", currentpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("url", "/ShelfListPage");
		return "/ShelfListPage";
	}

	@RequestMapping(value = "/ShelfAddPage", method = RequestMethod.GET)
	public String goToShelfAddPage(Model model) {
		model.addAttribute("shelf", new Shelf());
		model.addAttribute("locations", locationService.findAll());
		return "/ShelfAddPage";
	}

	@RequestMapping(value = "/updateshelf", method = RequestMethod.GET)
	public String goToShelfUpdatePage(@RequestParam long id, Model model) {
		model.addAttribute("shelf", shelfService.findById(id));
		model.addAttribute("locations", locationService.findAll());
		return "/ShelfUpdatePage";
	}

	@RequestMapping(value = "/shelfdetail", method = RequestMethod.GET)
	public String goToShelfDetailPage(@RequestParam long id, Model model) {
		model.addAttribute("shelf", shelfService.findById(id));
		return "/ShelfDetailPage";
	}

//	@RequestMapping(value = "/location/create", method = RequestMethod.POST)
//	public String saveShelf(@Valid Shelf shelf, BindingResult bindingResult) {
//		shelfService.add(shelf);
//		return "redirect:/ShelfListPage";
//	}

	@RequestMapping(value = "/shelf/{id}/update", method = { RequestMethod.POST, RequestMethod.PUT,
			RequestMethod.PATCH })
	public String updateShelf(@PathVariable Long id, @Valid Shelf shelf, Model model, BindingResult bindingResult) {
		shelfService.update(id, shelf);
		return "redirect:/ShelfListPage";
	}

	@RequestMapping(value = "/shelf/{id}/delete")
	public String deleteShelf(@PathVariable Long id) {
		shelfService.deleteById(id);
		return "redirect:/ShelfListPage";
	}

}
