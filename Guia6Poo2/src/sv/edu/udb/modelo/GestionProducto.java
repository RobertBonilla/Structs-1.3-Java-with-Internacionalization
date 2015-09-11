package sv.edu.udb.modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sv.edu.udb.form.ProductosForm;
import sv.edu.udb.javabeans.ProductoBean;

public class GestionProducto {
	Conexion con=new Conexion();
	public boolean ingresoProducto(ProductosForm pro){
	boolean estado=false;
	Connection cn=con.getConnection();
	try {
	PreparedStatement pt=null;
	String query ="insert into productos (idproducto,Nombreproducto,idproveedor,idcategoria,existencias,precio) ";
	query += " values (?,?,?, ?,?,?);";
	pt=cn.prepareStatement(query);
	pt.setString(1, pro.getCodigo());
	pt.setString(2,pro.getNombreproducto());
	pt.setString(3,pro.getProvee());
	pt.setString(4,pro.getCat());
	pt.setDouble(5,pro.getExistencia());
	pt.setString(6,pro.getPrecio());
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
	public int actualizarProducto(ProductosForm pro){
	int estado=0;
	Connection cn=con.getConnection();
	try {
	PreparedStatement pt=null;
	String query ="update productos set Nombreproducto=?,idproveedor=?,idcategoria=?,Existencias=?,Precio=? where idproducto = ?";
	pt=cn.prepareStatement(query);	
	pt.setString(1,pro.getNombreproducto());
	pt.setString(2,pro.getProvee());
	pt.setString(3,pro.getCat());
	pt.setDouble(4,pro.getExistencia());
	pt.setString(5,pro.getPrecio());
	pt.setString(6, pro.getCodigo());
	estado=pt.executeUpdate();
	System.out.println(estado);
	} catch (Exception e) {
	System.out.println(e);
	}
	finally{
		con.cierraConexion(cn);
	}
	return estado;
	}
	public int eliminarProducto(ProductosForm pro){
	int estado=0;
	Connection cn=con.getConnection();
	try {
	PreparedStatement pt=null;
	String query ="delete from productos where Idproducto=?";
	pt=cn.prepareStatement(query);
	pt.setString(1, pro.getCodigo());
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
	
	public ActionForward mostrar(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
			/*
			Instrucciones para el tratamiento de la petición
			*/
			LlenarCombos llenar=new LlenarCombos();
			ArrayList<ProductoBean>
			listacategoria=llenar.llenearComboProducto();
			request.setAttribute("producto", listacategoria);
			return mapping.findForward("inicio");
			}
}
