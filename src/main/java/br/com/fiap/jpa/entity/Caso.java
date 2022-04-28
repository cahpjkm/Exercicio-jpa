package br.com.fiap.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_CASO_TESTE")
@SequenceGenerator(name="caso", sequenceName="SQ_TB_CASO", allocationSize = 1)
public class Caso {
	
	@Id
	@Column(name="cd_caso")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "caso")
	private Integer codigo;
	
	//Relacionamento N:1 (SISTEMA)
	@ManyToOne
	@JoinColumn(name="cd_sistema", nullable = false)
	private Sistema sistema;
	
	@Column(name="nm_caso")
	private String nome;
	
	@Column(name="ds_caso")
	private String descricao;
	
	public Caso(Sistema sistema, String nome, String descricao) {
		this.sistema = sistema;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
