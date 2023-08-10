package br.com.GMA.ProjetoGMA.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Jogador")
public class Jogador {
	@OneToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id")
	@Id
	private Integer id_usuario;
	
	@Column(name= "nick", length = 30, nullable = true)
	private String nick;
	
	@Column(name= "fichas", length = 30, nullable = true)
	private String fichas;
	
	@Column(name= "nick", length = 30, nullable = true)
	private String nick;
	
	@Column(name= "telefone", length = 15, nullable = true)
	private String telefone;
