package entidades;

public class Distribuidora {
	
	/*CodDistribuidora	int	NOT NULL	PRIMARY KEY auto_increment,
	RazonSocial			varchar(50)		NOT NULL,
	RUC					varchar(11)		NOT NULL,
	Tipo				varchar(50)		NOT NULL,
	Telefono			varchar(15)		NOT NULL,
	Email				varchar(100)	NULL,
	Direccion			varchar(150)	NOT NULL);*/
	
	private int idDistribuidora;
	private String raSocial, ruc, tipo, telefono, email, direccion;
	
	public int getIdDistribuidora() {
		return idDistribuidora;
	}
	public void setIdDistribuidora(int idDistribuidora) {
		this.idDistribuidora = idDistribuidora;
	}
	public String getRaSocial() {
		return raSocial;
	}
	public void setRaSocial(String raSocial) {
		this.raSocial = raSocial;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
