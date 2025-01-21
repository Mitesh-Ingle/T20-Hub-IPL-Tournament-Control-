package com.tka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.Matches;
import com.tka.service.MatchService;

@Controller

public class MatchController {

	@Autowired
	private MatchService matchService;

	@PostMapping("/add-match")
	public String createMatch(@RequestBody Matches matches) {
		Matches match = matchService.createMatch(matches);
		return null;
	}

	@GetMapping("/get-match/{id}")
	public String getMatchById(@PathVariable Long id) {
		System.err.println("In get-match controller :" + id);
		Matches matchById = matchService.getMatchById(id);
		return null;
	}

	@GetMapping("delete-match/{id}")
	public String deleteMatch(@PathVariable long id, Model model) {
		System.err.println("In delete-Match Controller=" + id);
		boolean isDeleted = matchService.deleteMatchById(id);
		if (isDeleted) {
			List<Matches> allMatches = matchService.getAllMatches();
			model.addAttribute("matches", allMatches);
			model.addAttribute("message", "Match Deleted Successfully");
			return "match";
		} else {
			model.addAttribute("message", "Something Went Wrong");
			return "match";
		}
	}

	@GetMapping("/all-matches")
	public String getAllMatches(Model model) {
		System.err.println("in All-matches controller");
		List<Matches> allMatches = matchService.getAllMatches();
		model.addAttribute("matches", allMatches);
		return "match";
	}

	@GetMapping("/edit-match/{id}")
	public String getMatchDetails(@PathVariable("id") long id, Model model) {
		Matches match = matchService.getMatchById(id); // Service to fetch match by ID
		model.addAttribute("match", match); // Pass the match object to the view
		return "edit-match"; // JSP view name
	}

	@PostMapping("/update-match")
	public String updateMatch(@ModelAttribute Matches matches) {
		System.err.println("In Update-Match controller:" + matches);
		return "update-match";

	}

}
