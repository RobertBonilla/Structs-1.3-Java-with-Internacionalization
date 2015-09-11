package sv.edu.udb.javabeans;

public class ProductoBean {
	private String idproducto;
	private String Nombreproducto;
	private double precio;
	private String idproveedor;
	private String idcategoria;
	private double Existencias;
	public ProductoBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductoBean(String idproducto, String nombreproducto, double precio, String idproveedor, String idcategoria,
		double existencias) {
		this.idproducto = idproducto;
		Nombreproducto = nombreproducto;
		this.precio = precio;
		this.idproveedor = idproveedor;
		this.idcategoria = idcategoria;
		Existencias = existencias;
	}
	public String getIdproducto() {
		return idproducto;
	}
	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}
	public String getNombreproducto() {
		return Nombreproducto;
	}
	public void setNombreproducto(String nombreproducto) {
		Nombreproducto = nombreproducto;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getIdproveedor() {
		return idproveedor;
	}
	public void setIdproveedor(String idproveedor) {
		this.idproveedor = idproveedor;
	}
	public String getIdcategoria() {
		return idcategoria;
	}
	public void setIdcategoria(String idcategoria) {
		this.idcategoria = idcategoria;
	}
	public double getExistencias() {
		return Existencias;
	}
	public void setExistencias(double existencias) {
		Existencias = existencias;
	}	
	
	
}
