package org.Jeffry1Valverde1CasoEstudio1;

import controller.*;
import model.models.*;
import view.ConsoleView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ConsoleView consoleView = new ConsoleView();
        Validator validator = new Validator();

        int opcionPrincipal = 0;
        do {
            consoleView.menuPricipal();

            consoleView.showMessage("Digite la opción a utilizar: ");
            opcionPrincipal = validator.getInt();

            switch (opcionPrincipal){
                case 1:
                    EstudianteController estudianteController = new EstudianteController(consoleView);
                    int opcionSubEstudiantes = 0;

                    do {
                        consoleView.subMenuEstudiantes();
                        consoleView.showMessage("Digite la opción a utilizar: ");
                        opcionSubEstudiantes = validator.getInt();

                        switch (opcionSubEstudiantes){
                            case 1:
                                consoleView.showMessage("Digite el nombre del estudiante: ");
                                String nombreIn = validator.getString();
                                consoleView.showMessage("Digite la identificacion del estudiante: ");
                                int identificacionIn = validator.getInt();
                                consoleView.showMessage("Digite el correo electrónico del estudiante: ");
                                String emailIn = validator.getEmail();
                                consoleView.showMessage("Digite la fecha de nacimiento del estudiante Ej:2003-12-18: ");
                                Date fechaNacimientoIn = validator.getDate();
                                estudianteController.agregarEstudiante(nombreIn, identificacionIn, emailIn, fechaNacimientoIn);
                                break;
                            case 2:
                                consoleView.showMessage("Digite el id del estudiante: ");
                                int idAc = Integer.parseInt(in.readLine());
                                consoleView.showMessage("Digite el nombre del estudiante: ");
                                String nombreAc = in.readLine();
                                consoleView.showMessage("Digite la identificacion del estudiante: ");
                                int identificacionAc = Integer.parseInt(in.readLine());
                                consoleView.showMessage("Digite el correo electrónico del estudiante: ");
                                String emailAc = in.readLine();
                                consoleView.showMessage("Digite la fecha de nacimiento del estudiante Ej:2003-12-18: ");
                                Date fechaNacimientoAc = Date.valueOf(in.readLine());
                                estudianteController.actualizarEstudiante(idAc, nombreAc, identificacionAc, emailAc, fechaNacimientoAc);
                                break;
                            case 3:
                                consoleView.showMessage("Digite el id del estudiante que desea eliminar: ");
                                int idEl = Integer.parseInt(in.readLine());
                                estudianteController.eliminarEstudiante(idEl);
                                break;
                            case 4:
                                boolean hayUsuarios = false;
                                ArrayList<EstudiateModel> estudiantes =  estudianteController.consultaEstudiante();
                                if (estudiantes != null) {
                                    consoleView.showMessage("Estudiantes: ");
                                    for (var tempEstudiante : estudiantes){
                                        if (tempEstudiante.getEstado() == 1) {
                                            consoleView.showMessage("Id: " + tempEstudiante.getId() + ", Nombre: " + tempEstudiante.getNombre() + ", Identificación: " + tempEstudiante.getIdentificacion() + ", Correo electrónico: " + tempEstudiante.getEmail() + ", Fecha Nacimiento: " + tempEstudiante.getFechaNacimiento() + ", Estado: " + tempEstudiante.getEstado());
                                            hayUsuarios = true;
                                        }
                                    }
                                }

                                if (!hayUsuarios){
                                    consoleView.showMessage("No hay estudiantes registrados en el sistema!");
                                }
                                break;
                            case 5:
                                break;
                            default:
                                consoleView.showMessage("Opcion inválida.");
                                break;
                        }
                        consoleView.showMessage("Presione cualquier tecla para continuar...");
                        validator.readInputLine();
                    } while (opcionSubEstudiantes!=5);

                    break;
                case 2:
                    ProfesorController profesorController = new ProfesorController(consoleView);
                    int opcionSubProfesores = 0;

                    do {
                        consoleView.subMenuProfesores();
                        consoleView.showMessage("Digite la opción a utilizar: ");
                        opcionSubProfesores = validator.getInt();

                        switch (opcionSubProfesores){
                            case 1:
                                consoleView.showMessage("Digite el nombre del profesor: ");
                                String nombrePIn = in.readLine();
                                consoleView.showMessage("Digite la identificación del profesor: ");
                                int identificacionPIn = Integer.parseInt(in.readLine());
                                consoleView.showMessage("Digite el correo electrónico del profesor: ");
                                String emailPIn = in.readLine();
                                consoleView.showMessage("Digite el departamento del profesor: ");
                                String departamentoPIn = in.readLine();
                                profesorController.agregarProfesor(nombrePIn, identificacionPIn, emailPIn, departamentoPIn);
                                break;
                            case 2:
                                consoleView.showMessage("Digite el id del profesor que desea actualizar: ");
                                int idPAc = Integer.parseInt(in.readLine());
                                consoleView.showMessage("Digite el nombre del profesor: ");
                                String nombrePAc = in.readLine();
                                consoleView.showMessage("Digite la identificación del profesor: ");
                                int identificacionPAc = Integer.parseInt(in.readLine());
                                consoleView.showMessage("Digite el correo electrónico del profesor: ");
                                String emailPAc = in.readLine();
                                consoleView.showMessage("Digite el departamento del profesor: ");
                                String departamento = in.readLine();
                                profesorController.actulizarProfesor(idPAc, nombrePAc, identificacionPAc, emailPAc, departamento);
                                break;
                            case 3:
                                consoleView.showMessage("Digite el id del profesor que desea eliminar: ");
                                int idPEl = Integer.parseInt(in.readLine());
                                profesorController.eliminarProfesor(idPEl);
                                break;
                            case 4:
                                boolean hayUsuariosP = false;
                                ArrayList<ProfesorModel> profesores =  profesorController.consultaProfesor();
                                if (profesores != null) {
                                    consoleView.showMessage("Profesores: ");
                                    for (var tempProfesor : profesores){
                                        if (tempProfesor.getEstado() == 1) {
                                            consoleView.showMessage("Id: " + tempProfesor.getId() + ", Nombre: " + tempProfesor.getNombre() + ", Identificación: " + tempProfesor.getIdentificacion() + ", Correo electrónico: " + tempProfesor.getEmail() + ", Departamento: " + tempProfesor.getDepartamento() + ", Estado: " + tempProfesor.getEstado());
                                            hayUsuariosP = true;
                                        }
                                    }
                                }

                                if (!hayUsuariosP){
                                    consoleView.showMessage("No hay profesores registrados en el sistema!");
                                }
                                break;
                            case 5:
                                break;
                            default:
                                consoleView.showMessage("Opcion inválida.");
                                break;
                        }
                        consoleView.showMessage("Presione cualquier tecla para continuar...");
                        validator.readInputLine();
                    } while (opcionSubProfesores!=5);
                    break;
                case 3:
                    GrupoController grupoController = new GrupoController(consoleView);
                    int opcionSubGrupos = 0;

                    do {
                        consoleView.subMenuGrupos();
                        consoleView.showMessage("Digite la opción a utilizar: ");
                        opcionSubGrupos = validator.getInt();

                        switch (opcionSubGrupos){
                            case 1:
                                consoleView.showMessage("Digite el nombre del grupo: ");
                                String nombreGIn = validator.getString();
                                consoleView.showMessage("Digite la descripción del grupo: ");
                                String descripcionGIn = validator.getText();
                                grupoController.agregarGrupo(nombreGIn, descripcionGIn);
                                break;
                            case 2:
                                consoleView.showMessage("Digite el id del grupo que desea actualizar: ");
                                int idGAc = validator.getInt();
                                consoleView.showMessage("Digite el nombre del grupo: ");
                                String nombreGAc = validator.getString();
                                consoleView.showMessage("Digite la descripción del grupo: ");
                                String descripcionGAc = validator.getText();
                                grupoController.actualizarGrupo(idGAc, nombreGAc, descripcionGAc);
                                break;
                            case 3:
                                consoleView.showMessage("Digite el id del grupo que desea eliminar: ");
                                int idGEl = validator.getInt();
                                grupoController.eliminarGrupo(idGEl);
                                break;
                            case 4:
                                boolean hayUsuariosG = false;
                                ArrayList<GrupoModel> grupos =  grupoController.consultaGrupo();
                                if (grupos != null) {
                                    consoleView.showMessage("Grupos: ");
                                    for (var tempGrupo : grupos){
                                        if (tempGrupo.getEstado() == 1) {
                                            consoleView.showMessage("Id: " + tempGrupo.getId() + ", Nombre: " + tempGrupo.getNombre() + ", Descripción: " + tempGrupo.getDescripcion() + ", Estado: " + tempGrupo.getEstado());
                                            hayUsuariosG = true;
                                        }
                                    }
                                }

                                if (!hayUsuariosG){
                                    consoleView.showMessage("No hay grupos registrados en el sistema!");
                                }
                                break;
                            case 5:
                                break;
                            default:
                                consoleView.showMessage("Opcion inválida.");
                                break;
                        }
                        consoleView.showMessage("Presione cualquier tecla para continuar...");
                        validator.readInputLine();
                    } while (opcionSubGrupos!=5);
                    break;
                case 4:
                    CursoController cursoController = new CursoController(consoleView);
                    int opcionSubCursos = 0;


                    do {
                        consoleView.subMenuCursos();
                        consoleView.showMessage("Digite la opción a utilizar: ");
                        opcionSubCursos = validator.getInt();

                        switch (opcionSubCursos){
                            case 1:
                                consoleView.showMessage("Digite el nombre del curso: ");
                                String nombreCIn = validator.getString();
                                consoleView.showMessage("Digite la descripción del curso: ");
                                String descripcionCIn = validator.getText();
                                cursoController.agregarCurso(nombreCIn, descripcionCIn);
                                break;
                            case 2:
                                consoleView.showMessage("Digite el id del curso que desea actualizar: ");
                                int idCAc = validator.getInt();
                                consoleView.showMessage("Digite el nombre del curso: ");
                                String nombreCAc = validator.getString();
                                consoleView.showMessage("Digite la descripción del curso: ");
                                String descripcionCAc = validator.getText();
                                cursoController.actualizarCurso(idCAc, nombreCAc, descripcionCAc);
                                break;
                            case 3:
                                consoleView.showMessage("Digite el id del curso que desea eliminar: ");
                                int idCEl = validator.getInt();
                                cursoController.eliminarCurso(idCEl);
                                break;
                            case 4:
                                boolean hayUsuariosC = false;
                                ArrayList<CursoModel> cursos =  cursoController.consultaCurso();
                                if (cursos != null) {
                                    consoleView.showMessage("Cursos: ");
                                    for (var tempCurso : cursos){
                                        if (tempCurso.getEstado() == 1) {
                                            consoleView.showMessage("Id: " + tempCurso.getId() + ", Nombre: " + tempCurso.getNombre() + ", Descripción: " + tempCurso.getDescripcion() + ", Estado: " + tempCurso.getEstado());
                                            hayUsuariosC = true;
                                        }
                                    }
                                }

                                if (!hayUsuariosC){
                                    consoleView.showMessage("No hay cursos registrados en el sistema!");
                                }
                                break;
                            case 5:
                                break;
                            default:
                                consoleView.showMessage("Opcion inválida.");
                                break;
                        }
                        consoleView.showMessage("Presione cualquier tecla para continuar...");
                        validator.readInputLine();
                    } while (opcionSubCursos!=5);
                    break;
                case 5:
                    GrupoCursoController grupoCursoController = new GrupoCursoController(consoleView);
                    int opcionSubRelaciones = 0;


                    do {
                        consoleView.subMenuRelaciones();
                        consoleView.showMessage("Digite la opción a utilizar: ");
                        opcionSubRelaciones = validator.getInt();

                        switch (opcionSubRelaciones){
                            case 1:
                                consoleView.showMessage("Digite el id del curso: ");
                                int idCursoGCIn = validator.getInt();
                                consoleView.showMessage("Digite el id del grupo: ");
                                int idGrupoGCIn = validator.getInt();
                                grupoCursoController.agregarGrupoCurso(idGrupoGCIn, idCursoGCIn);
                                break;
                            case 2:
                                consoleView.showMessage("Digite el id de la relación grupo curso que desea actualizar: ");
                                int idRelacionGCAc = validator.getInt();
                                consoleView.showMessage("Digite el id del grupo: ");
                                int idGrupoGCAc = validator.getInt();
                                consoleView.showMessage("Digite el id del curso: ");
                                int idCursoGCAC = validator.getInt();
                                grupoCursoController.actualizarGrupoCurso(idRelacionGCAc, idGrupoGCAc, idCursoGCAC);
                                break;
                            case 3:
                                boolean hayGrupoCursoGC = false;
                                ArrayList<GrupoCursoModel> grupoCurso =  grupoCursoController.consultaGrupoCurso();
                                if (grupoCurso != null) {
                                    consoleView.showMessage("Grupos-cursos IDs: ");
                                    for (var tempGrupoCurso : grupoCurso){
                                        consoleView.showMessage("Id: " + tempGrupoCurso.getId() + ", Id Grupo: " + tempGrupoCurso.getGrupoId() + ", Id Curso: " + tempGrupoCurso.getCursoId());
                                        hayGrupoCursoGC = true;
                                    }
                                }

                                if (!hayGrupoCursoGC){
                                    consoleView.showMessage("No hay relaciones registradas en el sistema!");
                                }
                                break;
                            case 4:
                                boolean hayRelacionesGC = false;
                                ArrayList<GrupoCursoModel> grupoCursoR =  grupoCursoController.consultaGrupoCursoRelacionado();
                                if (grupoCursoR != null) {
                                    consoleView.showMessage("Relaciones: ");
                                    for (var tempGrupoCurso : grupoCursoR){
                                        consoleView.showMessage("## Relación " + tempGrupoCurso.getId() + ": " + tempGrupoCurso.getNombreCurso() + " con " + tempGrupoCurso.getNombreGrupo() + " ##");
                                        consoleView.showMessage("Id Curso: " + tempGrupoCurso.getCursoId() + ", Nombre curso: " + tempGrupoCurso.getNombreCurso() + ", Descripción curso: " + tempGrupoCurso.getDescripcionCurso() + ", Estado curso: " + tempGrupoCurso.getEstadoCurso());
                                        consoleView.showMessage("Id Grupo: " + tempGrupoCurso.getGrupoId() + ", Nombre grupo: " + tempGrupoCurso.getNombreGrupo() + ", Descripción grupo: " + tempGrupoCurso.getDescripcionGrupo() + ", Estado grupo: " + tempGrupoCurso.getEstadoGrupo());
                                        hayRelacionesGC = true;
                                    }
                                }

                                if (!hayRelacionesGC){
                                    consoleView.showMessage("No hay relaciones registradas en el sistema!");
                                }
                                break;
                            case 5:
                                break;
                            default:
                                consoleView.showMessage("Opcion inválida.");
                                break;
                        }
                        consoleView.showMessage("Presione cualquier tecla para continuar...");
                        validator.readInputLine();
                    } while (opcionSubRelaciones!=5);
                    break;
                case 6:
                    consoleView.showMessage("Gracias por su visita!!");
                    break;
                default:
                    consoleView.showMessage("Opcion inválida.");
                    break;
            }
        } while (opcionPrincipal != 6);
    }
}