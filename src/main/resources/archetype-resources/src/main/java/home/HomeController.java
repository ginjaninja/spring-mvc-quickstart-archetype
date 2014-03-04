package ${package}.home;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value={"/","/home"})
public class HomeController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(Principal principal) {
		return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
	}
}
