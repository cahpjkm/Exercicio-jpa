package br.com.fiap.jpa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_ITEM")
@SequenceGenerator(name="item", sequenceName = "SQ_TB_ITEM", allocationSize = 1)
public class Item {

	@Id
	@Column(name="cd_item")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item")
	private Integer codigo;
	
	//Relacionamento N:1 (CASO)
	@ManyToOne
	@JoinColumn(name="cd_caso", nullable = false)
	private Caso caso;
	
	//Relacionamento M:N (USUARIO)
	@ManyToMany(mappedBy = "itens")
	private List<Usuario> usuarios;
	
	
	@Column(name="nm_item")
	private String nome;
	
	public Item() {
		
	}

	public Item(Caso caso, String nome) {
		this.caso = caso;
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
