package sv.edu.udb.modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sv.edu.udb.javabeans.CategoriaBean;
import sv.edu.udb.javabeans.ProductoBean;
import sv.edu.udb.javabeans.ProveedorBean;
public class LlenarCombos {
Conexion con=new Conexion();
PreparedStatement ps=null;
ResultSet rs=null;
ArrayList<CategoriaBean> listacategoria=new ArrayList<CategoriaBean>();
ArrayList<ProveedorBean> listaproveedor=new ArrayList<ProveedorBean>();
ArrayList<ProductoBean> listaproducto=new ArrayList<ProductoBean>();

public ArrayList<CategoriaBean> llenearComboCategoria() {
String sql="Select * from categorias";
Connection cn=con.getConnection();
try {
ps=cn.prepareStatement(sql);
rs=ps.executeQuery();
while(rs.next()){
CategoriaBean cat=new CategoriaBean(rs.getString(1),rs.getString(2));
listacategoria.add(cat);
System.out.println(rs.getString(1) + " " +rs.getString(2));
}
con.cierraConexion(cn);
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
return listacategoria;
}

public ArrayList<ProveedorBean> llenearComboProveedor() {
String sql="Select * from proveedores";
Connection cn=con.getConnection();
try {
ps=cn.prepareStatement(sql);
rs=ps.executeQuery();
while(rs.next()){
ProveedorBean cat=new ProveedorBean(rs.getString(1),rs.getString(2));
listaproveedor.add(cat);
System.out.println(rs.getString(1) + " " +rs.getString(2));
}
con.cierraConexion(cn);
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
return listaproveedor;
}

public ArrayList<ProductoBean> llenearComboProducto() {
String sql="Select * from productos";
Connection cn=con.getConnection();
try {
ps=cn.prepareStatement(sql);
rs=ps.executeQuery();
while(rs.next()){
ProductoBean pro=new ProductoBean(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5),rs.getDouble(6));
listaproducto.add(pro);
System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getDouble(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getDouble(6));
}
con.cierraConexion(cn);
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
return listaproducto;
}

}