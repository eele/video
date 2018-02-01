package edu.zhku.jsj144.lzc.video.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeCtrl {
	@RequestMapping("/")
	public String showListPage() {
		return "index";
	}
}
