package com.jeony.helloworld;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jeony.helloworld.dao.UserDao;
import com.jeony.helloworld.model.User;

@Controller
public class HelloworldController {
private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	UserDao userDao;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/jeony", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("name", "Jeony!!" );
		
		List<User> userList = userDao.getUserList();
		for (User user : userList) {
			System.out.println( user.toString());
		}
		
		return "jeony/helloworld";
	}
}
