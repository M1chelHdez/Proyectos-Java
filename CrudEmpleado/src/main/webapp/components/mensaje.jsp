<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${sessionScope.error != null}">
    <div id="alerta" class="alert alert-danger mt-1" role="alert">
        ${sessionScope.error}
    </div>
        <c:remove var="error" scope="session"/>
</c:if>

<c:if test="${sessionScope.success != null}">
    <div id="alerta" class="alert alert-success mt-1" role="alert">
        ${sessionScope.success}
    </div>
        <c:remove var="success" scope="session"/>
</c:if>

<!-- Script para ocultar automáticamente las alertas -->
<script>
    setTimeout(function() {
        const alerta = document.getElementById('alerta');
        if (alerta) {
            alerta.classList.add('fade');
            alerta.classList.add('show'); // para animación de fade de Bootstrap
            alerta.style.transition = "opacity 0.5s ease-out";
            alerta.style.opacity = 0;
            setTimeout(() => alerta.remove(), 600); // elimina del DOM después de la animación
        }
    }, 3000); // espera 3 segundos
</script>