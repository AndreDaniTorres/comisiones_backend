package com.udea.comisiones.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "tipo_identificacion")
	private String tipoIdentificacion;

	private Integer idetificacion;
	private String nombre;
	private String apellido;
	private String email;

	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;

	@ManyToOne(fetch = FetchType.LAZY)
	private Rol rol;

	@ManyToOne(fetch = FetchType.LAZY)
	private Departamento departamento;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Comision> comisiones;

	//

	public Usuario() {
		this.comisiones = new ArrayList<>();

	}

	@PrePersist
	public void prePersist() {
		createAt = new Date();
	}

	//

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public Integer getIdetificacion() {
		return idetificacion;
	}

	public void setIdetificacion(Integer idetificacion) {
		this.idetificacion = idetificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public List<Comision> getComisiones() {
		return comisiones;
	}

	public void setComisiones(List<Comision> comisiones) {
		this.comisiones = comisiones;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	private static final long serialVersionUID = 1L;

}
