package com.gasmyr.it.controller.shop;

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

import com.gasmyr.it.model.Shop;
import com.gasmyr.it.service.shop.ShopService;
import com.gasmyr.it.utils.notification.NotificationService;

@Controller
public class ShopController {

	@Autowired
	ShopService shopService;

	@Autowired
	NotificationService notificationService;

	@RequestMapping(value = "/ShopListPage", method = RequestMethod.GET)
	public String list(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "9") int size,
			Model model, Pageable pageable) {
		pageable = new PageRequest(page, size, new Sort("id"));
		Page<Shop> shops = shopService.findAllByPage(pageable);
		model.addAttribute("shopinfo", shops);
		int currentpage = page + 1;
		int totalpage = shops.getTotalPages();
		model.addAttribute("currentpage", currentpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("url", "/ShopListPage");
		return "/ShopListPage";
	}

	@RequestMapping(value = "/ShopAddPage", method = RequestMethod.GET)
	public String goToShopAddPage(Model model) {
		model.addAttribute("shop", new Shop());
		return "/ShopAddPage";
	}

	@RequestMapping(value = "/updateshop", method = RequestMethod.GET)
	public String goToShopUpdatePage(@RequestParam long id, Model model) {
		model.addAttribute("shop", shopService.findById(id));
		return "/ShopUpdatePage";
	}

	@RequestMapping(value = "/shopdetail", method = RequestMethod.GET)
	public String goToShopDetailPage(@RequestParam long id, Model model) {
		model.addAttribute("shop", shopService.findById(id));
		return "/ShopDetailPage";
	}

	@RequestMapping(value = "/shop/create", method = RequestMethod.POST)
	public String saveShop(@Valid Shop shop, BindingResult bindingResult) {
		shopService.add(shop);
		notificationService.addNotificationSuccessMessage("Your change has been succefully save");
		return "redirect:/ShopListPage";
	}

	@RequestMapping(value = "/shop/{id}/update", method = { RequestMethod.POST, RequestMethod.PUT,
			RequestMethod.PATCH })
	public String updateShop(@PathVariable Long id, @Valid Shop shop, Model model, BindingResult bindingResult) {
		shopService.update(id, shop);
		notificationService.addNotificationSuccessMessage("Shop has been succefully update");
		return "redirect:/ShopListPage";
	}

	@RequestMapping(value = "/shop/{id}/delete")
	public String deleteShop(@PathVariable Long id) {
		shopService.deleteById(id);
		notificationService.addNotificationSuccessMessage("Shop has been succefully delete");
		return "redirect:/ShopListPage";
	}
}
