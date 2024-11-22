package org.example.presentacion;

import org.example.datos.ClienteDAO;
import org.example.datos.MaquinaDAO;
import org.example.datos.AlquilerDAO;
import org.example.dominio.Cliente;
import org.example.dominio.Maquina;
import org.example.dominio.Alquiler;

import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ClienteDAO clienteDAO = new ClienteDAO();
    private static final MaquinaDAO maquinaDAO = new MaquinaDAO();
    private static final AlquilerDAO alquilerDAO = new AlquilerDAO();

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenuPrincipal();
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    gestionarClientes();
                    break;
                case 2:
                    gestionarMaquinas();
                    break;
                case 3:
                    gestionarAlquileres();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
            }
        } while (opcion != 4);
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n*** MENÚ PRINCIPAL ***");
        System.out.println("1. Gestionar Clientes");
        System.out.println("2. Gestionar Máquinas");
        System.out.println("3. Gestionar Alquileres");
        System.out.println("4. Salir");
        System.out.print("Selecciona una opción: ");
    }

    private static void gestionarClientes() {
        int opcion;
        do {
            mostrarMenuClientes();
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    agregarCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    modificarCliente();
                    break;
                case 4:
                    eliminarCliente();
                    break;
                case 5:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
            }
        } while (opcion != 5);
    }

    private static void mostrarMenuClientes() {
        System.out.println("\n*** MENÚ DE GESTIÓN DE CLIENTES ***");
        System.out.println("1. Agregar cliente");
        System.out.println("2. Listar clientes");
        System.out.println("3. Modificar cliente");
        System.out.println("4. Eliminar cliente");
        System.out.println("5. Regresar al menú principal");
        System.out.print("Selecciona una opción: ");
    }

    private static void agregarCliente() {
        System.out.println("\n*** AGREGAR CLIENTE ***");

        System.out.print("Ingrese el nombre completo del cliente: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el correo electrónico: ");
        String correo = scanner.nextLine();

        System.out.print("Ingrese el teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Ingrese la dirección: ");
        String direccion = scanner.nextLine();

        Cliente cliente = new Cliente(nombre, correo, telefono, direccion);

        boolean agregado = clienteDAO.agregarCliente(cliente);
        if (agregado) {
            System.out.println("Cliente agregado exitosamente.");
        } else {
            System.out.println("Hubo un error al agregar el cliente.");
        }
    }

    private static void listarClientes() {
        System.out.println("\n*** LISTAR CLIENTES ***");
        List<Cliente> clientes = clienteDAO.listarClientes();

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }

    private static void modificarCliente() {
        System.out.println("\n*** MODIFICAR CLIENTE ***");

        System.out.print("Ingrese el ID del cliente a modificar: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        Cliente cliente = new Cliente();
        cliente.setId(id);

        boolean encontrado = clienteDAO.buscarClientePorId(cliente);

        if (!encontrado) {
            System.out.println("Cliente no encontrado.");
        } else {
            System.out.print("Ingrese el nuevo nombre completo: ");
            String nombre = scanner.nextLine();
            cliente.setNombre(nombre);

            System.out.print("Ingrese el nuevo correo electrónico: ");
            String correo = scanner.nextLine();
            cliente.setCorreo(correo);

            System.out.print("Ingrese el nuevo teléfono: ");
            String telefono = scanner.nextLine();
            cliente.setTelefono(telefono);

            System.out.print("Ingrese la nueva dirección: ");
            String direccion = scanner.nextLine();
            cliente.setDireccion(direccion);

            boolean modificado = clienteDAO.modificarCliente(cliente);
            if (modificado) {
                System.out.println("Cliente modificado exitosamente.");
            } else {
                System.out.println("Hubo un error al modificar el cliente.");
            }
        }
    }

    private static void eliminarCliente() {
        System.out.println("\n*** ELIMINAR CLIENTE ***");

        System.out.print("Ingrese el ID del cliente a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        Cliente cliente = new Cliente();
        cliente.setId(id);

        boolean eliminado = clienteDAO.eliminarCliente(cliente);
        if (eliminado) {
            System.out.println("Cliente eliminado exitosamente.");
        } else {
            System.out.println("Hubo un error al eliminar el cliente.");
        }
    }

    private static void gestionarMaquinas() {
        int opcion;
        do {
            mostrarMenuMaquinas();
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    agregarMaquina();
                    break;
                case 2:
                    listarMaquinas();
                    break;
                case 3:
                    modificarMaquina();
                    break;
                case 4:
                    eliminarMaquina();
                    break;
                case 5:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
            }
        } while (opcion != 5);
    }

    private static void mostrarMenuMaquinas() {
        System.out.println("\n*** MENÚ DE GESTIÓN DE MÁQUINAS ***");
        System.out.println("1. Agregar máquina");
        System.out.println("2. Listar máquinas");
        System.out.println("3. Modificar máquina");
        System.out.println("4. Eliminar máquina");
        System.out.println("5. Regresar al menú principal");
        System.out.print("Selecciona una opción: ");
    }

    private static void agregarMaquina() {
        System.out.println("\n*** AGREGAR MÁQUINA ***");

        System.out.print("Ingrese el modelo de la máquina: ");
        String modelo = scanner.nextLine();

        System.out.print("Ingrese el número de serie: ");
        String numeroSerie = scanner.nextLine();

        System.out.print("Ingrese el estado de la máquina (Disponible/Alquilada): ");
        String estado = scanner.nextLine();

        Maquina maquina = new Maquina(modelo, numeroSerie, estado);

        boolean agregado = maquinaDAO.agregarMaquina(maquina);
        if (agregado) {
            System.out.println("Máquina agregada exitosamente.");
        } else {
            System.out.println("Hubo un error al agregar la máquina.");
        }
    }

    private static void listarMaquinas() {
        System.out.println("\n*** LISTAR MÁQUINAS ***");
        List<Maquina> maquinas = maquinaDAO.listarMaquinas();

        if (maquinas.isEmpty()) {
            System.out.println("No hay máquinas registradas.");
        } else {
            for (Maquina maquina : maquinas) {
                System.out.println(maquina);
            }
        }
    }

    private static void modificarMaquina() {
        System.out.println("\n*** MODIFICAR MÁQUINA ***");

        System.out.print("Ingrese el ID de la máquina a modificar: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        Maquina maquina = maquinaDAO.buscarMaquinaPorId(id);

        if (maquina == null) {
            System.out.println("Máquina no encontrada.");
        } else {
            System.out.print("Ingrese el nuevo modelo: ");
            String modelo = scanner.nextLine();
            maquina.setModelo(modelo);

            System.out.print("Ingrese el nuevo número de serie: ");
            String numeroSerie = scanner.nextLine();
            maquina.setNumeroSerie(numeroSerie);

            System.out.print("Ingrese el nuevo estado de la máquina: ");
            String estado = scanner.nextLine();
            maquina.setEstado(estado);

            boolean modificado = maquinaDAO.modificarMaquina(maquina);
            if (modificado) {
                System.out.println("Máquina modificada exitosamente.");
            } else {
                System.out.println("Hubo un error al modificar la máquina.");
            }
        }
    }

    private static void eliminarMaquina() {
        System.out.println("\n*** ELIMINAR MÁQUINA ***");

        System.out.print("Ingrese el ID de la máquina a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        boolean eliminado = maquinaDAO.eliminarMaquina(id);
        if (eliminado) {
            System.out.println("Máquina eliminada exitosamente.");
        } else {
            System.out.println("Hubo un error al eliminar la máquina.");
        }
    }

    private static void gestionarAlquileres() {
        int opcion;
        do {
            mostrarMenuAlquileres();
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    agregarAlquiler();
                    break;
                case 2:
                    listarAlquileres();
                    break;
                case 3:
                    modificarAlquiler();
                    break;
                case 4:
                    eliminarAlquiler();
                    break;
                case 5:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
            }
        } while (opcion != 5);
    }

    private static void mostrarMenuAlquileres() {
        System.out.println("\n*** MENÚ DE GESTIÓN DE ALQUILERES ***");
        System.out.println("1. Agregar alquiler");
        System.out.println("2. Listar alquileres");
        System.out.println("3. Modificar alquiler");
        System.out.println("4. Eliminar alquiler");
        System.out.println("5. Regresar al menú principal");
        System.out.print("Selecciona una opción: ");
    }

    private static void agregarAlquiler() {
        System.out.println("\n*** AGREGAR ALQUILER ***");

        // Obtener ID del cliente
        System.out.print("Ingrese el ID del cliente: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        // Obtener ID de la máquina
        System.out.print("Ingrese el ID de la máquina: ");
        int idMaquina = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        // Ingresar las fechas de inicio y fin
        System.out.print("Ingrese la fecha de inicio (yyyy-mm-dd): ");
        String fechaInicioStr = scanner.nextLine();

        System.out.print("Ingrese la fecha de fin (yyyy-mm-dd): ");
        String fechaFinStr = scanner.nextLine();

        // Crear el objeto Alquiler
        Alquiler alquiler = new Alquiler();
        alquiler.setCliente(new Cliente(idCliente));  // Cliente con ID
        alquiler.setMaquina(new Maquina(idMaquina));  // Máquina con ID
        alquiler.setFechaInicio(java.sql.Date.valueOf(fechaInicioStr));  // Convertir la fecha a java.sql.Date
        alquiler.setFechaFin(java.sql.Date.valueOf(fechaFinStr));  // Convertir la fecha a java.sql.Date
        alquiler.setEstado("Activo");  // El estado inicial es "Activo"

        // Llamar al DAO para agregar el alquiler
        boolean agregado = alquilerDAO.agregarAlquiler(alquiler);
        if (agregado) {
            System.out.println("Alquiler agregado exitosamente.");
        } else {
            System.out.println("Hubo un error al agregar el alquiler.");
        }
    }

    private static void listarAlquileres() {
        System.out.println("\n*** LISTAR ALQUILERES ***");
        List<Alquiler> alquileres = alquilerDAO.listarAlquileres();

        if (alquileres.isEmpty()) {
            System.out.println("No hay alquileres registrados.");
        } else {
            for (Alquiler alquiler : alquileres) {
                // Imprimir detalles de cada alquiler
                System.out.println("ID Alquiler: " + alquiler.getId());
                System.out.println("Cliente: " + alquiler.getCliente().getNombre());
                System.out.println("Máquina: " + alquiler.getMaquina().getModelo());
                System.out.println("Fecha Inicio: " + alquiler.getFechaInicio());
                System.out.println("Fecha Fin: " + alquiler.getFechaFin());
                System.out.println("Estado: " + alquiler.getEstado());
                System.out.println("---------------------------");
            }
        }
    }

    private static void modificarAlquiler() {
        System.out.println("\n*** MODIFICAR ALQUILER ***");

        // Obtener el ID del alquiler que se quiere modificar
        System.out.print("Ingrese el ID del alquiler a modificar: ");
        int idAlquiler = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        // Buscar el alquiler en la base de datos
        Alquiler alquiler = alquilerDAO.buscarAlquilerPorId(new Alquiler(idAlquiler));

        if (alquiler == null) {
            System.out.println("Alquiler no encontrado.");
        } else {
            // Mostrar información actual
            System.out.println("Alquiler encontrado: ");
            System.out.println("Cliente: " + alquiler.getCliente().getNombre());
            System.out.println("Máquina: " + alquiler.getMaquina().getModelo());
            System.out.println("Fecha Inicio: " + alquiler.getFechaInicio());
            System.out.println("Fecha Fin: " + alquiler.getFechaFin());
            System.out.println("Estado: " + alquiler.getEstado());

            // Permitir modificar las fechas y el estado
            System.out.print("Ingrese la nueva fecha de inicio (yyyy-mm-dd) o presione Enter para mantener la actual: ");
            String nuevaFechaInicio = scanner.nextLine();
            if (!nuevaFechaInicio.isEmpty()) {
                alquiler.setFechaInicio(java.sql.Date.valueOf(nuevaFechaInicio));
            }

            System.out.print("Ingrese la nueva fecha de fin (yyyy-mm-dd) o presione Enter para mantener la actual: ");
            String nuevaFechaFin = scanner.nextLine();
            if (!nuevaFechaFin.isEmpty()) {
                alquiler.setFechaFin(java.sql.Date.valueOf(nuevaFechaFin));
            }

            System.out.print("Ingrese el nuevo estado (Activo/Desactivado) o presione Enter para mantener el actual: ");
            String nuevoEstado = scanner.nextLine();
            if (!nuevoEstado.isEmpty()) {
                alquiler.setEstado(nuevoEstado);
            }

            // Llamar al DAO para actualizar el alquiler
            boolean modificado = alquilerDAO.modificarAlquiler(alquiler);
            if (modificado) {
                System.out.println("Alquiler modificado exitosamente.");
            } else {
                System.out.println("Hubo un error al modificar el alquiler.");
            }
        }
    }

    private static void eliminarAlquiler() {
        System.out.println("\n*** ELIMINAR ALQUILER ***");

        // Obtener el ID del alquiler que se desea eliminar
        System.out.print("Ingrese el ID del alquiler a eliminar: ");
        int idAlquiler = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        // Llamar al DAO para eliminar el alquiler
        boolean eliminado = alquilerDAO.eliminarAlquiler(new Alquiler(idAlquiler));
        if (eliminado) {
            System.out.println("Alquiler eliminado exitosamente.");
        } else {
            System.out.println("Hubo un error al eliminar el alquiler.");
        }
    }
}