package com.empleado.controlador;

import com.empleado.dao.EmpleadoDAO;
import com.empleado.modelo.Empleado;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmpleadoControlador extends HttpServlet {

    private static final String EMPLEADO = "empleado";
    private static final String ERROR = "error";

    private final EmpleadoDAO empDao = new EmpleadoDAO();
    private final String pagListar = "/vista/listar.jsp";
    private final String pagNuevo = "/vista/nuevo.jsp";

    /**
     * Processes the incoming HTTP request and determines which action to
     * perform based on the "accion" parameter.
     *
     * @param request The HttpServletRequest object representing the client's
     * request.
     * @param response The HttpServletResponse object representing the server's
     * response.
     * @throws ServletException If a servlet-specific error occurs.
     * @throws IOException If an I/O error occurs.
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("\"text/html; charset=UTF-8\"\n");

        String accion = request.getParameter("accion");

        switch (accion) {
            case "listar":
                listar(request, response);
                break;
            case "nuevo":
                nuevo(request, response);
                break;
            case "guardar":
                guardar(request, response);
                break;
            case "editar":
                editar(request, response);
                break;
            case "eliminar":
                eliminar(request, response);
                break;
            default:
                throw new AssertionError();
        }

    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        int result = empDao.elminar(id);

        if (result > 0) {
            request.getSession().setAttribute("success", "Empleado con el Id " + id + " eliminado");
        } else {
            request.getSession().setAttribute(ERROR, "No se pudo eliminar el empleado");
        }
    }

    protected void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Empleado obj = empDao.buscarPorId(id);

        if (obj != null) {
            request.setAttribute(EMPLEADO, obj);
            request.getRequestDispatcher(pagNuevo).forward(request, response);
        } else {
            request.getSession().setAttribute(ERROR, "No se encontró al empleado con Id " + id);
            response.sendRedirect("EmpleadoControlador?accion=listar");
        }

    }

    private void guardar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8\"\n");
        Empleado obj = new Empleado();
        obj.setId(Integer.parseInt(request.getParameter("id")));
        obj.setNombres(request.getParameter("nombres"));
        obj.setApellidos(request.getParameter("apellidos"));
        obj.setFechaIngreso(request.getParameter("fechaIngreso"));
        obj.setSueldo(Double.parseDouble(request.getParameter("sueldo")));

        int result;

        if (obj.getId() == 0) {
            result = empDao.registrar(obj);
        } else {
            result = empDao.editar(obj);
        }

        if (result > 0) {
            request.getSession().setAttribute("success", "Datos guardados");
            response.sendRedirect("EmpleadoControlador?accion=listar");
            return; // evita IllegalStateException
        }
        request.getSession().setAttribute(ERROR, "No se pudieron guardar los datos");
        request.setAttribute(EMPLEADO, obj);
        request.getRequestDispatcher(pagNuevo).forward(request, response);
    }

    private void nuevo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute(EMPLEADO, new Empleado());
        request.getRequestDispatcher(pagNuevo).forward(request, response);
    }

    protected void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8\"\n");

        request.setAttribute("empleados", empDao.ListarTodos());
        request.getRequestDispatcher(pagListar).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
