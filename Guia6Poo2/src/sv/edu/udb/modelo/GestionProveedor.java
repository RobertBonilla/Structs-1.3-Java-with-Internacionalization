package sv.edu.udb.modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import sv.edu.udb.form.ProveedorForm;

public class GestionProveedor {
	Conexion con=new Conexion();
	public boolean ingresoProveedor(ProveedorForm prv){
	boolean estado=false;
	Connection cn=con.getConnection();
	try {
	PreparedStatement pt=null;
	String query ="insert into proveedores values(?,?)";
	pt=cn.prepareStatement(query);
	pt.setString(1, prv.getCodigo());
	pt.setString(2,prv.getNombre());
	pt.executeUpdate();
	estado=true;
	} catch (Exception e) {
	System.out.println(e);
	}
	finally{
		con.cierraConexion(cn);
	}
	return estado;
	}
	public int actualizarProveedor(ProveedorForm prv){
	int estado=0;
	Connection cn=con.getConnection();
	try {
	PreparedStatement pt=null;
	String query ="update proveedores set Nombreproveedor= ? where	Idproveedor=?";
	pt=cn.prepareStatement(query);
	pt.setString(1, prv.getNombre());
	pt.setString(2,prv.getCodigo());
	estado=pt.executeUpdate();
	//executeUpdate devuelve 1 si inserta, elimina o actualiza
	//devuelve 0 si no pudo realizar ninguna de las anteriores
	System.out.println(estado);
	} catch (Exception e) {
	System.out.println(e);
	}
	finally{
		con.cierraConexion(cn);
	}
	return estado;
	}
	public int eliminarProveedor(ProveedorForm prv){
	int estado=0;
	Connection cn=con.getConnection();
	try {
	PreparedStatement pt=null;
	String query ="delete from proveedores where Idproveedor=?";
	pt=cn.prepareStatement(query);
	pt.setString(1, prv.getCodigo());
	estado=pt.executeUpdate();
	//executeUpdate devuelve 1 si inserta, elimina o actualiza
	//devuelve 0 si no pudo realizar ninguna de las anteriores
	System.out.println(estado);
	} catch (Exception e) {
	System.out.println(e);
	}
	finally{
	con.cierraConexion(cn);
	}
	return estado;
	}
}
