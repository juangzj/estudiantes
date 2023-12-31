
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Juan Goyes
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        //funcion que permite leer la opcion del usuario
        Scanner lector = new Scanner(System.in);

        //bandera que permite terminar el programa
        boolean activo = true;

        //array para guardar los estudiantes registrados
        ArrayList<Estudiante> listadoEstudiantes = new ArrayList<Estudiante>();

        do {

            //llamado al metodo mostrar menú
            mostrarOpcionesMenu();

            //leer opcion del usuario 
            int opcion = lector.nextInt();

            //opcioes con switch
            switch (opcion) {
                case 1:
                    System.out.println("=========Sección ========");
                    System.out.println("Agregar estudiante");
                    agregarEstudiante(listadoEstudiantes, lector);
                    break;

                //System.out.println("se agrego un nuevo estudiante con los sifuientes datos  \n Nombre: " + a.getNombre() + "\n Apellido: " + a.getApellido() + "\n Cedula: " + a.getCedula() + "\n Semestre: " + a.getSemestre() + "\n Correo: " +a.getCorreo() + "\n Celular: " + a.getCelular());
                case 2:
                    System.out.println("=========Sección ========");
                    System.out.println("Eliminar Estudiante");
                    eliminarEstudiante(listadoEstudiantes, lector);
                    break;
                case 3:
                    System.out.println("=========Sección ========");
                    System.out.println("Modificar estudiante ");
                    modificarEstudiante(listadoEstudiantes, lector);
                    break;

                case 4:
                    System.out.println("=========Sección ========");
                    System.out.println("Consultar  total de estudiantes estudiantes");
                    System.out.println("");
                    mostrarEstudiantes(listadoEstudiantes);
                    break;

                case 5:
                    System.out.println("=========Sección ========");
                    System.out.println("Consultar estudiantes por semestre");
                    consultaEstudiantesSemestre(listadoEstudiantes, lector);
                    break;
                case 6:
                    //try {
                    leerArchivo(listadoEstudiantes);
                    //} catch (Exception e) {
                    //System.err.println("No se encontro archivo");
                    //}
                    break;

                case 7:
                    System.out.println("El programa ha finalizado");
                    activo = false;
                    break;
                default:
                    System.out.println("Debe seleccionar una de las opciones del menú");
            }

        } while (activo);
        lector.close();

    }

    /**
     * Metodo para mostrar el menu de opciones
     */
    public static void mostrarOpcionesMenu() {

        System.out.println("=============== Menu de opciones ============");
        System.out.println("1: Insertar Estudiante");
        System.out.println("2: Eliminar Estudiante");
        System.out.println("3: Modificar Estudiante");
        System.out.println("4: Consultar Todos Los Estudiantes");
        System.out.println("5: Consultar Estudiantes Por Semestre");
        System.out.println("6: Leer archivo de txt");
        System.out.println("7: Terminar programa");

    }

    /**
     * Metodo para agregar estudiante
     *
     * @param registroEstudiantes
     * @param lector
     */
    public static void agregarEstudiante(ArrayList<Estudiante> registroEstudiantes, Scanner lector) {
        //Crear un nuevo estudainte desde la clase Estudiante
        Estudiante registroNuevoEstudiante = new Estudiante();

        //Lectura de la cedula del estudiante
        System.out.println("Ingrese la cedula del estudiante");
        registroNuevoEstudiante.setCedula(lector.next());

        //lectura el nombre del estudiante
        System.out.println("Ingrese el nombre del estudiante");
        registroNuevoEstudiante.setNombre(lector.next());

        //lectura del apellido del estudiante
        System.out.println("Ingrese el apellido del estudiante");
        registroNuevoEstudiante.setApellido(lector.next().trim());

        //lectura del semestre del estudiante
        System.out.println("Ingrese el semestre del estudiante");
        registroNuevoEstudiante.setSemestre(lector.nextInt());

        //lectura del correo del estudiante
        System.out.println("Ingrese el correo del estudiante");
        registroNuevoEstudiante.setCorreo(lector.next().trim());

        //lectura del numero de celular del estudiante
        System.out.println("Ingrese el numero del estudiante");
        registroNuevoEstudiante.setCelular(lector.next());

        //agregar estudiante al array 
        registroEstudiantes.add(registroNuevoEstudiante);

    }

    /**
     * metodo para modificar alumno
     */
    public static void modificarEstudiante(ArrayList<Estudiante> listadoEstudiantes, Scanner lector) {
        System.out.println("Ingrese el numero de cedula del estudiante para modificación de datos");
        String modificacion = lector.next();

        boolean cambio = false;
        for (Estudiante estudiante : listadoEstudiantes) {
            if (estudiante.getCedula().equals(modificacion)) {
                System.out.println("El estudiante que modificara es " + estudiante.getNombre() + " " + estudiante.getApellido());
            }
            //Lectura del nombre modificado 
            System.out.println("Ingrese el nuevo nombre del estudiante");
            String nombreModificado = lector.next().trim();
            estudiante.setNombre(nombreModificado);

            //lectura del apellido modificado
            System.out.println("Ingrese el nuevo apellido del estudiante");
            String apelldioModificado = lector.next().trim();
            estudiante.setApellido(apelldioModificado);

            //lectura del apellido modificado
            System.out.println("Ingrese el nuevo apellido del estudiante");
            int semestreModificado = lector.nextInt();
            estudiante.setSemestre(semestreModificado);

            //lectura del correo del estudiante
            System.out.println("Ingrese el nuevo correo del estudiante");
            String correoModificado = lector.next().trim();
            estudiante.setCorreo(correoModificado);

            //lectura del numero de celular del estudiante
            System.out.println("Ingrese el nuevo numero de celular del estudiante");
            String numeroModificado = lector.next();
            estudiante.setCelular(numeroModificado);

            //cerrar la bandera para finalizar la modificacion 
            cambio = true;
            break;
        }

        if (cambio == false) {
            System.out.println("No hay registro del estudiante");
        }

    }

    /**
     * Metodo para eliminar a un estudiante del registo
     *
     * @param listadoEstudiantes
     * @param lector
     */
    public static void eliminarEstudiante(ArrayList<Estudiante> listadoEstudiantes, Scanner lector) {
        System.out.println("Ingrese el numero de cedula para eliminar al estudiante ");
        String eliminarEstudiante = lector.next();

        Estudiante eliminacionEstudiante = null;
        for (Estudiante estudiante : listadoEstudiantes) {
            if (estudiante.getCedula().equals(eliminarEstudiante)) {
                eliminacionEstudiante = estudiante;
                break;
            }
        }
        if (eliminacionEstudiante != null) {
            listadoEstudiantes.remove(eliminacionEstudiante);
        }
        System.out.println("Registro eliminado");
    }

    /**
     * Meotodo que muestra todos los estudiantes registrados
     *
     * @param listadoEstudiantes
     */
    public static void mostrarEstudiantes(ArrayList<Estudiante> listadoEstudiantes) throws FileNotFoundException {
        // crear archivo con la clase FIlE
        File archivo = new File("./data/reporteEstudiantes.txt");

        //crear la pluma para escribir el archivo 
        PrintWriter pluma = new PrintWriter(archivo);

        if (listadoEstudiantes.isEmpty()) {
            System.out.println("====================================");
            System.out.println("No hay registro de algun estudiante");
            System.out.println("====================================");

        } else {
            for (Estudiante estudiantesTotales : listadoEstudiantes) {
                System.out.println("==============Listado de todos los estudiantes===============");
                //pluma.println("==============Listado de todos los estudiantes===============");
                System.out.println("Nombre: " + estudiantesTotales.getNombre());
                //pluma.println("Nombre: " + estudiantesTotales.getNombre());
                System.out.println("Apelldido: " + estudiantesTotales.getApellido());
                //pluma.println("Apelldido: " + estudiantesTotales.getApellido());
                System.out.println("Cedula: " + estudiantesTotales.getCedula());
                //pluma.println("Cedula: " + estudiantesTotales.getCedula());
                System.out.println("Semestre: " + estudiantesTotales.getSemestre());
                //pluma.println("Semestre: " + estudiantesTotales.getSemestre());
                System.out.println("Correo: " + estudiantesTotales.getCorreo());
                //pluma.println("Correo: " + estudiantesTotales.getCorreo());
                System.out.println("Celular: " + estudiantesTotales.getCelular());
                //pluma.println("Celular: " + estudiantesTotales.getCelular());
                System.out.println("==============================================================");
                //pluma.println("===========================================================");

                pluma.println(estudiantesTotales.getCedula() + "," + estudiantesTotales.getNombre() + "," + estudiantesTotales.getApellido() + "," + estudiantesTotales.getSemestre() + "," + estudiantesTotales.getCorreo() + "," + estudiantesTotales.getCelular());

            }
        }

        pluma.close();
    }

    /**
     * Metodo para buscar los estudiantes que tiene el mismo semestre
     *
     * @param listadoEstudiantes
     * @param lector
     */
    public static void consultaEstudiantesSemestre(ArrayList<Estudiante> listadoEstudiantes, Scanner lector) {
        System.out.println("Ingrese el semestre");
        int semestre = lector.nextInt();

        boolean estudiantesEncontrados = false; // Variable para rastrear si se encontraron estudiantes

        for (Estudiante semestreEstudiante : listadoEstudiantes) {
            if (semestreEstudiante.getSemestre() == semestre) {
                if (!estudiantesEncontrados) {
                    System.out.println("==============Listado de estudiantes por semestre===============");
                }
                estudiantesEncontrados = true;
                System.out.println("Nombre: " + semestreEstudiante.getNombre());
                System.out.println("Apelldido: " + semestreEstudiante.getApellido());
                System.out.println("Cedula: " + semestreEstudiante.getCedula());
                System.out.println("Semestre: " + semestreEstudiante.getSemestre());
                System.out.println("Correo: " + semestreEstudiante.getCorreo());
                System.out.println("Celular: " + semestreEstudiante.getCelular());
                System.out.println("==============================================================");
            }
        }

        if (!estudiantesEncontrados) {
            System.out.println("No se encontraron estudiantes en el semestre ingresado.");
        }
    }

    /**
     *
     * @param listadoEstudiantes
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void leerArchivo(ArrayList<Estudiante> listadoEstudiantes) throws FileNotFoundException, IOException {

        File archivo = new File("./data/reporteEstudiantes.txt");
        FileReader fr = new FileReader(archivo);
        BufferedReader lector = new BufferedReader(fr);

        String linea = lector.readLine();
        while (linea != null) {

            String[] datos = linea.split(",");
            String cedulaL = datos[0];
            String nombreL = datos[1];
            String apellidoL = datos[2];
            String semestreL = datos[3];
            String correoL = datos[4];
            String celularL = datos[5];

            //llamamos al metodo constructor de estudiante para crear un nuevo estudiante 
            Estudiante estudianteL = new Estudiante();

            //agregamos los datos en el constructor para crear el nuevo estudiante
            estudianteL.setCedula(cedulaL);
            estudianteL.setNombre(nombreL);
            estudianteL.setApellido(apellidoL);
            int semestreLN = Integer.parseInt(semestreL);
            estudianteL.setSemestre(semestreLN);
            estudianteL.setCorreo(correoL);
            estudianteL.setCelular(celularL);

            //añadimos al estudiante al listado de estudiantes
            listadoEstudiantes.add(estudianteL);

            linea = lector.readLine();

        }
        fr.close();
        lector.close();
    }

}
