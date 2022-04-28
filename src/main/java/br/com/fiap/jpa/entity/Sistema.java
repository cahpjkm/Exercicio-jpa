package br.com.fiap.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_SISTEMA")
@SequenceGenerator(name="sistema", sequenceName = "SQ_TB_SISTEMA", allocationSize = 1)
public class Sistema {
	
	@Id
	@Column(name="cd_sistema")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sistema")
	private Integer codigo;
	
	//Relacionamento 1:N
	@OneToMany(mappedBy = "sistema", cascade = CascadeType.PERSIST)
	private List<Caso> casos = new ArrayList<Caso>();
	
	@Column(name="nm_sistema")
	private String nome;

	public Sistema() {
		
	}
	
	public Sistema(String nome) {
		this.nome = nome;
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

}
