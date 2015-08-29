/**
 * 
 */
package com.cst6.msc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cst6.msc.dto.CommodityCategoryDTO;
import com.cst6.msc.dto.ContainerDTO;
import com.cst6.msc.dto.CustomerDTO;
import com.cst6.msc.dto.FrieghtPlanPortDTO;
import com.cst6.msc.dto.PortDTO;
import com.cst6.msc.dto.ShipDTO;
import com.cst6.msc.dto.ShippingCompanyDTO;
import com.cst6.msc.dto.SystemUserDTO;
import com.cst6.msc.service.CityService;
import com.cst6.msc.service.CommodityCategoryService;
import com.cst6.msc.service.ContainerService;
import com.cst6.msc.service.ContainerTypeService;
import com.cst6.msc.service.CountryService;
import com.cst6.msc.service.CustomerService;
import com.cst6.msc.service.FrieghtPlanPortService;
import com.cst6.msc.service.FrieghtPlanService;
import com.cst6.msc.service.PortService;
import com.cst6.msc.service.ShipCategoryService;
import com.cst6.msc.service.ShipService;
import com.cst6.msc.service.ShippingCompanyService;
import com.cst6.msc.service.SystemUserRoleService;
import com.cst6.msc.service.SystemUserService;
import com.cst6.msc.service.UserRoleAssignorService;
import com.cst6.msc.util.AuthenticationUtil;

/**
 * @author SasankaN
 *
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	private SystemUserService systemUserService;

	@Autowired
	private CountryService countryService;

	@Autowired
	private CityService cityService;

	@Autowired
	private SystemUserRoleService systemUserRoleService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private UserRoleAssignorService userRoleAssignorService;

	@Autowired
	private ShipService shipService;

	@Autowired
	private FrieghtPlanService frieghtPlanService;
	
	@Autowired
	private FrieghtPlanPortService frieghtPlanPortService;

	@Autowired
	private PortService portService;

	@Autowired
	private CommodityCategoryService commodityCategoryService;

	@Autowired
	private ContainerService containerService;

	@Autowired
	private ContainerTypeService containerTypeService;

	@Autowired
	private ShippingCompanyService shippingCompanyService;

	@Autowired
	private ShipCategoryService shipCategoryService;

	/**
	 * Admin login
	 * 
	 * @param error
	 * @param logout
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}

		model.addObject("title", "AP | Login");
		model.setViewName("admin/login");

		return model;

	}

	/**
	 * for 403 access denied page
	 * 
	 * @return
	 */
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();

		// check if user is login
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addObject("username", userDetail.getUsername());
		}

		model.setViewName("admin/403");
		return model;

	}

	/**
	 * adminHome
	 * 
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String adminHome(Locale locale, Model model) {
		logger.info("ADMIN HOME! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		String title = "AP | Dashboard";

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("title", title);

		return "admin/dashboard";
	}

	/**
	 * addArticle
	 * 
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/article/add-article", method = RequestMethod.GET)
	public String addArticle(Locale locale, Model model) {
		logger.info("ADMIN - ADD NEW ARTICLE");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		String title = "AP | Add Article";

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("title", title);

		return "admin/new-article";
	}

	/**
	 * viewArticle
	 * 
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/article/view-articles", method = RequestMethod.GET)
	public String viewArticle(Locale locale, Model model) {
		logger.info("ADMIN - VIEW ARTICLES");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		String title = "AP | View Articles";

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("title", title);

		return "admin/view-articles";
	}

	/**
	 * approvedComment
	 * 
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/comments/approved-comments", method = RequestMethod.GET)
	public String approvedComment(Locale locale, Model model) {
		logger.info("ADMIN - APPROVED COMMENTS");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		String title = "AP | Approved Comments";

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("title", title);

		return "admin/approved-comments";
	}

	/**
	 * unapprovedComment
	 * 
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/comments/unapproved-comments", method = RequestMethod.GET)
	public String unapprovedComment(Locale locale, Model model) {
		logger.info("ADMIN - UN-APPROVED COMMENTS");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		String title = "AP | Un-approved Comments";

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("title", title);

		return "admin/unapproved-comments";
	}

	/**
	 * manageTag
	 * 
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/tags", method = RequestMethod.GET)
	public String manageTag(Locale locale, Model model) {
		logger.info("ADMIN - TAGS");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		String title = "AP | Tags";

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("title", title);

		return "admin/tags";
	}

	/**
	 * manageSystemUsers
	 * 
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/users/system-users", method = RequestMethod.GET)
	public ModelAndView manageSystemUsers(Locale locale, Model model) {
		logger.info("ADMIN - SYSTEM USERS");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		String title = "AP | System-users";

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("title", title);

		ModelMap map = new ModelMap();
		map.put("systemUserList", systemUserService.getAllSystemUsers(true));
		map.put("nonActiveSystemUserList",
				systemUserService.getAllSystemUsers(false));
		// map.put("systemUserRoleList",
		// systemUserRoleService.getAllSystemUserRoles());
		map.put("systemUserRoleList", userRoleAssignorService
				.getAssigneesByAssignerId(AuthenticationUtil
						.getUserDetailsAdaptor().getSystemUserRoleId()));
		map.put("searchSystemUserList",
				systemUserService.searchAllSystemUsers("f"));
		if (systemUserService.searchAllSystemUsers("f").isEmpty())
			System.out.println("Hello  1111111111 "
					+ systemUserService.searchAllSystemUsers("f"));
		map.put("countryList", countryService.getAllCountries());
		map.put("systemUserDTO", new SystemUserDTO());

		return new ModelAndView("admin/system-users", map);
	}

	/**
	 * registerSystemUser
	 * 
	 * @param model
	 * @param request
	 * @param systemUserDTO
	 * @return
	 */
	@RequestMapping(value = "/users/addSystemUser", method = RequestMethod.POST)
	public String registerSystemUser(Model model, HttpServletRequest request,
			@ModelAttribute("systemUserDTO") SystemUserDTO systemUserDTO) {
		logger.info("SystemUser Registration!");

		systemUserService.saveSystemUser(systemUserDTO);

		return "redirect:/admin/users/system-users";
	}

	/**
	 * removeSystemUser
	 * 
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "/users/removeSystemUser/{id}", method = RequestMethod.GET)
	public ModelAndView removeSystemUser(@PathVariable Integer id) {

		systemUserService.deleteSystemUser(id);

		return new ModelAndView("redirect:/admin/users/system-users");
	}

	/**
	 * 
	 * @param systemUserDTO
	 * @return
	 */
	@RequestMapping(value = "/users/searchSystemUser", method = RequestMethod.GET)
	public ModelAndView serarchystemUser(
			@ModelAttribute("systemUserDTO") SystemUserDTO systemUserDTO) {

		systemUserService.searchAllSystemUsers("f");

		return new ModelAndView("redirect:/admin/users/system-users");
	}

	/**
	 * manageCustomers
	 * 
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/users/customers", method = RequestMethod.GET)
	public String manageCustomers(Locale locale, Model model) {
		logger.info("ADMIN - CUSTOMERS");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		String title = "AP | Customer";

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("title", title);

		ModelMap map = new ModelMap();
		map.put("cityList", cityService.getAllCities());
		map.put("countryList", countryService.getAllCountries());

		return "admin/customers";
	}

	/**
	 * registerCustomer
	 * 
	 * @param model
	 * @param request
	 * @param customerDTO
	 * @return
	 */
	@RequestMapping(value = "/users/addCustomer", method = RequestMethod.POST)
	public String registerCustomer(Model model, HttpServletRequest request,
			@ModelAttribute("customerDTO") CustomerDTO customerDTO) {
		logger.info("SystemUser Registration!");

		customerService.saveCustomer(customerDTO);

		return "redirect:/admin/users/customers";
	}

	/**
	 * 
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/shipping-route", method = RequestMethod.GET)
	public ModelAndView manageShippingRoute(Locale locale, Model model) {
		logger.info("ADMIN - MAP");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		String title = "AP | Ship Route";

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("title", title);

		ModelMap map = new ModelMap();
		map.put("shipList", shipService.getAllShips());
		map.put("portList", portService.getAllPorts());
		map.put("friegtPlanList",
				frieghtPlanService.getAllFriegtPlansAssignedToShip(1));
		map.put("frieghtPlanPortDTO", new FrieghtPlanPortDTO());

		return new ModelAndView("admin/shipping-route", map);
	}

	/**
	 * addShippingRoute
	 * 
	 * @param model
	 * @param request
	 * @param frieghtPlanPortDTO
	 * @return
	 */
	@RequestMapping(value = "/users/addShippingRoute", method = RequestMethod.POST)
	public String addShippingRoute(
			Model model,
			HttpServletRequest request,
			@ModelAttribute("frieghtPlanPortDTO") FrieghtPlanPortDTO frieghtPlanPortDTO) {
		logger.info("SystemUser Registration!");

		frieghtPlanPortService.savFrieghtPlanPort(frieghtPlanPortDTO);

		return "redirect:/admin/shipping-route";
	}

	/**
	 * manageCommodityCategories
	 * 
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/general/commodity-categories", method = RequestMethod.GET)
	public ModelAndView manageCommodityCategories(Locale locale, Model model) {
		logger.info("ADMIN - COMMODITY CATEGORIES");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		String title = "AP | Commodity-categories";

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("title", title);

		ModelMap map = new ModelMap();
		map.put("commodityCategoryList",
				commodityCategoryService.getAllCommodityCategories(true));
		map.put("nonActiveCommodityCategoryList",
				commodityCategoryService.getAllCommodityCategories(false));
		map.put("commodityCategoryDTO", new CommodityCategoryDTO());
		map.put("searchCommodityCategoryList",
				commodityCategoryService.searchAllCommodityCategories("a"));

		return new ModelAndView("admin/commodity-categories", map);
	}

	/**
	 * addCommodityCategory
	 * 
	 * @param model
	 * @param request
	 * @param commodityCategoryDTO
	 * @return
	 */
	@RequestMapping(value = "/general/addCommodityCategory", method = RequestMethod.POST)
	public String addCommodityCategory(
			Model model,
			HttpServletRequest request,
			@ModelAttribute("commodityCategoryDTO") CommodityCategoryDTO commodityCategoryDTO) {
		logger.info("SystemUser Registration!");

		commodityCategoryService.saveCommodityCategory(commodityCategoryDTO);

		return "redirect:/admin/general/commodity-categories";
	}

	/**
	 * removeCommodityCategory
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/general/removeCommodityCategory/{id}", method = RequestMethod.GET)
	public ModelAndView removeCommodityCategory(@PathVariable Integer id) {

		commodityCategoryService.deleteCommodityCategory(id);
		;

		return new ModelAndView("redirect:/admin/general/commodity-categories");
	}

	/**
	 * manageContainers
	 * 
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/general/containers", method = RequestMethod.GET)
	public ModelAndView manageContainers(Locale locale, Model model) {
		logger.info("ADMIN - CONTAINERS");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		String title = "AP | Containers";

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("title", title);

		ModelMap map = new ModelMap();
		map.put("containerList", containerService.getAllContainers(true));
		map.put("nonActiveContainerList",
				containerService.getAllContainers((false)));
		map.put("containerDTO", new ContainerDTO());
		map.put("searchContainerList",
				containerService.searchAllContainers("a"));
		map.put("containerTypeList",
				containerTypeService.getAllContainerTypes());
		map.put("shippingCompanyList",
				shippingCompanyService.getAllShippingCompanies(true));

		return new ModelAndView("admin/containers", map);
	}

	/**
	 * addContainer
	 * 
	 * @param model
	 * @param request
	 * @param containerDTO
	 * @return
	 */
	@RequestMapping(value = "/general/addContainer", method = RequestMethod.POST)
	public String addContainer(Model model, HttpServletRequest request,
			@ModelAttribute("containerDTO") ContainerDTO containerDTO) {
		logger.info("ADMIN PANEL | Add Container!");

		containerService.saveContainer(containerDTO);

		return "redirect:/admin/general/containers";
	}

	/**
	 * removeContainer
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/general/removeContainer/{id}", method = RequestMethod.GET)
	public ModelAndView removeContainer(@PathVariable Integer id) {
		logger.info("ADMIN PANEL | Remove Container!");

		containerService.deleteContainer(id);

		return new ModelAndView("redirect:/admin/general/containers");
	}

	/**
	 * managePorts
	 * 
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/general/ports", method = RequestMethod.GET)
	public ModelAndView managePorts(Locale locale, Model model) {
		logger.info("ADMIN - PORTS");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		String title = "AP | Ports";

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("title", title);

		ModelMap map = new ModelMap();
		map.put("portDTO", new PortDTO());
		map.put("cityList", cityService.getAllCities());
		map.put("portList", portService.getAllPorts(true));
		map.put("nonActivePortList", portService.getAllPorts(false));
		map.put("searchPortList", portService.searchAllPorts("a"));

		return new ModelAndView("admin/ports", map);
	}

	/**
	 * addPort
	 * 
	 * @param model
	 * @param request
	 * @param portDTO
	 * @return
	 */
	@RequestMapping(value = "/general/addPort", method = RequestMethod.POST)
	public String addPort(Model model, HttpServletRequest request,
			@ModelAttribute("portDTO") PortDTO portDTO) {
		logger.info("ADMIN PANEL | Add Port!");

		portService.savePort(portDTO);

		return "redirect:/admin/general/ports";
	}

	/**
	 * removePort
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/general/removePort/{id}", method = RequestMethod.GET)
	public ModelAndView removePort(@PathVariable Integer id) {
		logger.info("ADMIN PANEL | Remove Port!");

		portService.deletePort(id);

		return new ModelAndView("redirect:/admin/general/ports");
	}

	/**
	 * manageShips
	 * 
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/general/ships", method = RequestMethod.GET)
	public ModelAndView manageShips(Locale locale, Model model) {
		logger.info("ADMIN - SHIPS");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		String title = "AP | Ships";

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("title", title);

		ModelMap map = new ModelMap();
		map.put("shipDTO", new ShipDTO());
		map.put("shipList", shipService.getAllShips(true));
		map.put("nonActiveShipList", shipService.getAllShips(false));
		map.put("searchShipList", shipService.searchAllShips("a"));
		map.put("shippingCompanyList",
				shippingCompanyService.getAllShippingCompanies(true));
		map.put("shipCategoryList", shipCategoryService.getAllShipCategories());

		return new ModelAndView("admin/ships", map);
	}
	
	/**
	 * addShip
	 * 
	 * @param model
	 * @param request
	 * @param portDTO
	 * @return
	 */
	@RequestMapping(value = "/general/addShip", method = RequestMethod.POST)
	public String addShip(Model model, HttpServletRequest request,
			@ModelAttribute("shipDTO") ShipDTO shipDTO) {
		logger.info("ADMIN PANEL | Add Ship!");

		shipService.saveShip(shipDTO);

		return "redirect:/admin/general/ships";
	}

	/**
	 * removeShip
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/general/removeShip/{id}", method = RequestMethod.GET)
	public ModelAndView removeShip(@PathVariable Integer id) {
		logger.info("ADMIN PANEL | Remove Ship!");

		shipService.deleteShip(id);

		return new ModelAndView("redirect:/admin/general/ships");
	}
	
	/**
	 * manageShippingCompanies
	 * 
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/general/shippingCompanies", method = RequestMethod.GET)
	public ModelAndView manageShippingCompanies(Locale locale, Model model) {
		logger.info("ADMIN - SHIPPING COMPANIES");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		String title = "AP | Shipping Companies";

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("title", title);

		ModelMap map = new ModelMap();
		map.put("shippingCompanyDTO", new ShippingCompanyDTO());
		map.put("cityList", cityService.getAllCities());
		map.put("shippingCompanyList", shippingCompanyService.getAllShippingCompanies(true));
		map.put("nonActiveShippingCompanyList", shippingCompanyService.getAllShippingCompanies(false));
		map.put("searchShippingCompanyList", shippingCompanyService.searchAllShippingCompanies("a"));

		return new ModelAndView("admin/shipping-companies", map);
	}
	
	/**
	 * addShippingCompany
	 * 
	 * @param model
	 * @param request
	 * @param shipDTO
	 * @return
	 */
	@RequestMapping(value = "/general/addShippingCompany", method = RequestMethod.POST)
	public String addShippingCompany(Model model, HttpServletRequest request,
			@ModelAttribute("shippingCompanyDTO") ShippingCompanyDTO shippingCompanyDTO) {
		logger.info("ADMIN PANEL | Add Shipping Comapny!");

		shippingCompanyService.saveShippingCompany(shippingCompanyDTO);

		return "redirect:/admin/general/shippingCompanies";
	}

	/**
	 * removeShippingCompany
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/general/removeShippingCompany/{id}", method = RequestMethod.GET)
	public ModelAndView removeShippingCompany(@PathVariable Integer id) {
		logger.info("ADMIN PANEL | Remove Shipping Company!");

		shippingCompanyService.deleteShippingCompany(id);

		return new ModelAndView("redirect:/admin/general/shippingCompanies");
	}

}
