package view;

public class ConsoleView {
    public void showMessage(String message) {
        System.out.println(message);
    }

    public void errorMessage(String message) {
        System.err.println(message);
    }

    public void menuPricipal(){
        showMessage("=========== Menú Principal ===========");
        showMessage("1. Estudiantes.");
        showMessage("2. Profesores.");
        showMessage("3. Grupos.");
        showMessage("4. Cursos.");
        showMessage("5. Relacion: Grupo-Curso.");
        showMessage("6. Salir del sistema.");
        showMessage("======================================");
    }

    public void subMenuEstudiantes(){
        showMessage("============= Estudiantes ============");
        showMessage("1. Agregar estudiante.");
        showMessage("2. Actualizar estudiante.");
        showMessage("3. Eliminar estudiante.");
        showMessage("4. Consulta de estudiantes.");
        showMessage("5. Salir de estudiantes.");
        showMessage("======================================");
    }

    public void subMenuProfesores(){
        showMessage("============= Profesores =============");
        showMessage("1. Agregar profesor.");
        showMessage("2. Actualizar profesor.");
        showMessage("3. Eliminar profesor.");
        showMessage("4. Consulta de profesores.");
        showMessage("5. Salir de profesores.");
        showMessage("======================================");
    }

    public void subMenuGrupos(){
        showMessage("=============== Grupos ===============");
        showMessage("1. Agregar grupo.");
        showMessage("2. Actualizar grupo.");
        showMessage("3. Eliminar grupo.");
        showMessage("4. Consulta de grupos.");
        showMessage("5. Salir de grupos.");
        showMessage("======================================");
    }

    public void subMenuCursos(){
        showMessage("================ Cursos ==============");
        showMessage("1. Agregar curso.");
        showMessage("2. Actualizar curso.");
        showMessage("2. Eliminar curso.");
        showMessage("4. Consulta de cursos.");
        showMessage("5. Salir de cursos.");
        showMessage("======================================");
    }

    public void subMenuRelaciones(){
        showMessage("============= Relaciones =============");
        showMessage("1. Agregar curso a grupo.");
        showMessage("2. Actualizar grupo-curso IDs.");
        showMessage("3. Consulta de grupo-curso IDs.");
        showMessage("4. Consulta relaciones.");
        showMessage("5. Salir de relaciones.");
        showMessage("======================================");
    }
}
