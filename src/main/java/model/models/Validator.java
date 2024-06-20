package model.models;

import view.ConsoleView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Validator {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    ConsoleView consoleView = new ConsoleView();

    public String getString() {
        String mensaje = "";
        boolean hayError = false;

        do {
            try {
                mensaje = in.readLine();
                if (mensaje.isEmpty()) {
                    throw new Exception("No se permiten campos vacios. Intentelo de nuevo!");
                }
                if (!mensaje.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                    throw new Exception("El campo debe contener solo letras. Intentelo de nuevo!");
                }
                hayError = false;
            }catch (Exception e){
                consoleView.errorMessage(e.getMessage());
                hayError = true;
            }
        } while (hayError);

        return mensaje;
    }

    public String getText() {
        String mensaje = "";
        boolean hayError = false;

        do {
            try {
                mensaje = in.readLine();
                if (mensaje.isEmpty()) {
                    throw new Exception("No se permiten campos vacios. Intentelo de nuevo!");
                }
                if (!mensaje.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s,]+$")) {
                    throw new Exception("El campo debe contener solo letras. Intentelo de nuevo!");
                }
                hayError = false;
            }catch (Exception e){
                consoleView.errorMessage(e.getMessage());
                hayError = true;
            }
        } while (hayError);

        return mensaje;
    }

    public int getInt() {
        int numero = 0;
        boolean hayError = false;

        do {
            try {
                String tempNumero = in.readLine();
                if (tempNumero == null) {
                    throw new Exception("No se permiten campos vacios. Intentelo de nuevo!.");
                }

                if (!tempNumero.matches("^[0-9]+$")) {
                    throw new Exception("El campo debe contener solo números.");
                }
                hayError = false;
                numero = Integer.parseInt(tempNumero);
            } catch (Exception e) {
                consoleView.errorMessage(e.getMessage());
                hayError = true;
            }

        } while (hayError);
        return numero;
    }

    public String getEmail() {
        String email = "";
        boolean hayError = false;

        do {
            try {
                email = in.readLine();
                if (email.isEmpty()) {
                    throw new Exception("No se permiten campos vacios. Intentelo de nuevo!");
                }
                if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
                    throw new Exception("El campo no tiene el formato de un correo electrónico válido.");
                }
                hayError = false;
            } catch (Exception e) {
                consoleView.errorMessage(e.getMessage());
                hayError = true;
            }
        } while (hayError);
        return email;
    }

    public java.sql.Date getDate() {
        java.sql.Date fecha = null;
        boolean hayError;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setLenient(false); // Para una validación estricta

        do {
            hayError = false;
            try {
                String fechaTemp = in.readLine();
                if (fechaTemp == null || fechaTemp.isEmpty()) {
                    throw new Exception("No se permiten campos vacíos. Inténtelo de nuevo.");
                }

                java.util.Date utilDate = formatter.parse(fechaTemp);
                fecha = new java.sql.Date(utilDate.getTime());
            } catch (ParseException e) {
                consoleView.errorMessage("Formato de fecha incorrecto. Use el formato yyyy-MM-dd.");
                hayError = true;
            } catch (Exception e) {
                consoleView.errorMessage(e.getMessage());
                hayError = true;
            }
        } while (hayError);

        return fecha;
    }

    public String readInputLine() {
        try {
            return in.readLine();
        } catch (IOException e) {
            consoleView.errorMessage(e.getMessage());
            return null;
        }
    }

}
