package com.tka.controller;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tka.entity.Team;
import com.tka.service.TeamService;

@Controller
public class TeamController {

	@Autowired
	private TeamService teamService;

	@PostMapping("/create-team")
	public String createTeam(@RequestBody Team team) {
		Team dbTeam = teamService.createTeam(team);
		return null;
	}

	@GetMapping("/get-team/{id}")
	public String getTeamById(@PathVariable Long id) {
		Team teamById = teamService.getTeamById(id);
		return null;
	}

	@GetMapping("/all-team")
	public String getAllTeams(Model model) {
		List<Team> allTeams = teamService.getAllTeams();
		System.out.println(allTeams);
		model.addAttribute("teams", allTeams);
		return "team";
	}

//	
//	@GetMapping("/edit-Team/{id}")
//public String editTeamById  (@PathVariable long id ) {
//		Session session = sess
//		return null;
//		
//		
//	}
//	
//	
	
}
