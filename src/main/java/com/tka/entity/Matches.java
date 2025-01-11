package com.tka.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Matches {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String matchDate;

	@Column(nullable = false)
	private String location;

	@ManyToOne
	@JoinColumn(name = "team1_id", nullable = false)
	private Team team1;

	@ManyToOne
	@JoinColumn(name = "team2_id", nullable = false)
	private Team team2;

}
