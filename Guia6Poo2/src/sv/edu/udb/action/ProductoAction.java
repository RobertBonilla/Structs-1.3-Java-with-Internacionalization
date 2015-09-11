package sv.edu.udb.action;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import sv.edu.udb.form.CategoriaForm;
import sv.edu.udb.form.ProductosForm;
import sv.edu.udb.javabeans.CategoriaBean;
import sv.edu.udb.javabeans.ProductoBean;
import sv.edu.udb.javabeans.ProveedorBean;
import sv.edu.udb.modelo.GestionCategoria;
import sv.edu.udb.modelo.GestionProducto;
import sv.edu.udb.modelo.LlenarCombos;

public class ProductoAction extends DispatchAction{
	
	public ActionForward agregar(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
			throws Exception {
			/*
			Instrucciones para el tratamiento de la petici�n
			*/
			ProductosForm pro=(ProductosForm) form;
			GestionProducto gest=new GestionProducto();
			LlenarCombos llenar=new LlenarCombos();
			
			ArrayList<CategoriaBean> listacategoria=llenar.llenearComboCategoria();
			request.setAttribute("categoria", listacategoria);
			ArrayList<ProveedorBean> listaproveedor=llenar.llenearComboProveedor();
			request.setAttribute("proveedor", listaproveedor);
			if(gest.ingresoProducto(pro)){
			request.setAttribute("mensaje", "Exito");
			ArrayList<ProductoBean>
			listaproducto=llenar.llenearComboProducto();
			request.setAttribute("producto", listaproducto);
			return mapping.findForward("inicio");
			}
			else{
			request.setAttribute("mensaje", "Fracaso");
			return mapping.findForward("inicio");
			}
			}
	public ActionForward actualizar(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
			ProductosForm pro=(ProductosForm) form;
			GestionProducto gest=new GestionProducto();
			LlenarCombos llenar=new LlenarCombos();
			
			ArrayList<CategoriaBean> listacategoria=llenar.llenearComboCategoria();
			request.setAttribute("categoria", listacategoria);
			ArrayList<ProveedorBean> listaproveedor=llenar.llenearComboProveedor();
			request.setAttribute("proveedor", listaproveedor);
			if(gest.actualizarProducto(pro)==1){
			request.setAttribute("update", "Exito");
			ArrayList<ProductoBean>
			listaproducto=llenar.llenearComboProducto();
			request.setAttribute("producto", listaproducto);
			return mapping.findForward("inicio");
			}
			else{
			request.setAttribute("update", "Fracaso");
			return mapping.findForward("inicio");
			}
			}
	
	public ActionForward eliminar(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
			/*
			Instrucciones para el tratamiento de la petición
			*/
			ProductosForm pro=(ProductosForm) form;
			GestionProducto gest=new GestionProducto();
			LlenarCombos llenar=new LlenarCombos();
			
			ArrayList<CategoriaBean> listacategoria=llenar.llenearComboCategoria();
			request.setAttribute("categoria", listacategoria);
			ArrayList<ProveedorBean> listaproveedor=llenar.llenearComboProveedor();
			request.setAttribute("proveedor", listaproveedor);
			if(gest.eliminarProducto(pro)==1){
			request.setAttribute("delete", "Exito");
			ArrayList<ProductoBean>
			listaproducto=llenar.llenearComboProducto();
			request.setAttribute("producto", listaproducto);
			return mapping.findForward("inicio");
			}
			else{
			request.setAttribute("delete", "Fracaso");
			return mapping.findForward("inicio");
			}
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
			listaproducto=llenar.llenearComboProducto();
			request.setAttribute("producto", listaproducto);
			ArrayList<CategoriaBean> listacategoria=llenar.llenearComboCategoria();
			request.setAttribute("categoria", listacategoria);
			ArrayList<ProveedorBean> listaproveedor=llenar.llenearComboProveedor();
			request.setAttribute("proveedor", listaproveedor);
			return mapping.findForward("inicio");
			}
	
	public ActionForward llenar(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		LlenarCombos llenar=new LlenarCombos();
		//Obtiene el arraylist con los datos de la categoria
		ArrayList<CategoriaBean> listacategoria=llenar.llenearComboCategoria();
		request.setAttribute("categoria", listacategoria);
		//Obtiene el arraylist con los datos de proveedor
		ArrayList<ProveedorBean> listaproveedor=llenar.llenearComboProveedor();
		request.setAttribute("proveedor", listaproveedor);
        return mapping.findForward("ingresado");
	}
	
	private void mostrarCombos(){
		
	}

}
