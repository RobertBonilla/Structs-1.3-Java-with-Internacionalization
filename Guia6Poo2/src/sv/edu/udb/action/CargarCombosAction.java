package sv.edu.udb.action;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import sv.edu.udb.javabeans.CategoriaBean;
import sv.edu.udb.javabeans.ProveedorBean;
import sv.edu.udb.modelo.LlenarCombos;
public class CargarCombosAction extends DispatchAction{
public ActionForward llenar(ActionMapping mapping,
ActionForm form,
HttpServletRequest request,
HttpServletResponse response)
throws Exception {
/*
Instrucciones para el tratamiento de la petición
*/
LlenarCombos llenar=new LlenarCombos();
//Obtiene el arraylist con los datos de la categoria
ArrayList<CategoriaBean> listacategoria=llenar.llenearComboCategoria();
request.setAttribute("categoria", listacategoria);
//Obtiene el arraylist con los datos de proveedor
ArrayList<ProveedorBean> listaproveedor=llenar.llenearComboProveedor();
request.setAttribute("proveedor", listaproveedor);
return mapping.findForward("ingresado");
}
}