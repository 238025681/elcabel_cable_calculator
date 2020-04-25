package bg.elkabel.calculator.controllers;

import bg.elkabel.calculator.models.bind.CoreBindModel;
import bg.elkabel.calculator.service.CoreService;
import com.google.gson.Gson;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Kalin
 */
@Controller
@RequestMapping("/calc/core")

public class CoreController {

	private final CoreService coreService;
        private final Gson gsonService;

	@Autowired
	public CoreController(CoreService coreService, Gson gsonService) {
		this.coreService = coreService;
                this.gsonService = gsonService;
	}

	@GetMapping("")
	public String getCorePage(@ModelAttribute("coreModel") CoreBindModel coreModel) {
		return "view/core";
	}

	@PostMapping("")
	public String getCore(@ModelAttribute("coreModel") CoreBindModel coreModel) {

		this.coreService.create(coreModel);

		return "redirect:/calc/core";
	}

        @GetMapping("/getCores")
	@ResponseBody
	public String getAllCores() throws IOException {

		return this.gsonService.toJson(this.coreService.findAll());
	}

	
}
