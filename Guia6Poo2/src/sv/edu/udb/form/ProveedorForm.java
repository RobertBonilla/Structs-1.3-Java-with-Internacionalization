package sv.edu.udb.form;

import org.apache.struts.action.ActionForm;

public class ProveedorForm extends ActionForm{
	
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String nombre;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
	
	
}
