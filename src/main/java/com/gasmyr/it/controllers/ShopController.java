package com.gasmyr.it.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gasmyr.it.model.Shop;
import com.gasmyr.it.service.interfaces.ShopRepository;

@Controller
public class ShopController {

	@Autowired
	ShopRepository shopRepository;

	@RequestMapping(value = "/shopinfo", method = RequestMethod.GET)
	public String list(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			Model model, Pageable pageable) {
		pageable = new PageRequest(page, size, new Sort("id"));
		Page<Shop> shops = shopRepository.findAll(pageable);
		model.addAttribute("shopinfo", shops);
		int currentpage = page+1;
		int totalpage = shops.getTotalPages();
		model.addAttribute("currentpage", currentpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("url", "/shopinfo");
		System.out.println(
				"let go :" + shops.getNumber() + " " + shops.getNumberOfElements() + " " + shops.getTotalPages());
		System.out.println("let go :" + shops.getTotalElements() + " " + shops.getSize());
		return "/shopinfo";
	}

	@RequestMapping("/shop/{id}/delete")
	public String deleteShop(@PathVariable Long id) {
		if (id != null) {
			shopRepository.delete(id);
		}
		return "redirect:/shopinfo";
	}

	@RequestMapping("/shop/{id}/update")
	public String updateShop(@PathVariable Long id, Model model) {
		if (id != null) {
			model.addAttribute("shop", shopRepository.findOne(id));
		}
		return "redirect:/shopinfo";
	}

}
