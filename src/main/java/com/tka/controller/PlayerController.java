package com.tka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.Player;
import com.tka.service.PlayerService;

@Controller
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@PostMapping("/create-player")
	public String createPlayer(@RequestBody Player player) {
		 Player dbPlayer = playerService.createPlayer(player);
		return null;
	}

	@GetMapping("/get-player/{id}")
	public String getPlayerById(@PathVariable Long id) {
		 Player playerById = playerService.getPlayerById(id);
		return null;
		 
	}

	@GetMapping("/all-player")
	public String getAllPlayers(Model model) {
		List<Player> allPlayers = playerService.getAllPlayers();

		model.addAttribute("players", allPlayers);
		return "player";

	}
}
