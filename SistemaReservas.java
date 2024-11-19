class EspacioRecreacional {
    String nombre;
    String tipo;
    int capacidad;
    String[] horarios;
    boolean[] disponibilidad;

    EspacioRecreacional(String nombre, String tipo, int capacidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.horarios = new String[5];
        this.disponibilidad = new boolean[5];
        inicializarHorarios();
    }

    private void inicializarHorarios() {
        horarios[0] = "6:00";
        horarios[1] = "7:00";
        horarios[2] = "8:00";
        horarios[3] = "9:00";
        horarios[4] = "10:00";
        for(int i = 0; i < 5; i++) {
            disponibilidad[i] = true;
        }
    }

    boolean reservar(String horario) {
        for(int i = 0; i < horarios.length; i++) {
            if(horarios[i].equals(horario) && disponibilidad[i]) {
                disponibilidad[i] = false;
                System.out.println("reserva exitosa en " + nombre);
                return true;
            }
        }
        System.out.println("horario no disponible en " + nombre);
        return false;
    }

    void mostrarDisponibilidad() {
        System.out.println("\nDisponibilidad de " + nombre + " (" + tipo + "):");
        System.out.println("capacidad: " + capacidad + " personas");
        for(int i = 0; i < horarios.length; i++) {
            System.out.println(horarios[i] + " - " + (disponibilidad[i] ? "disponible" : "ocupado"));
        }
    }

    void cancelarReserva(String horario) {
        for(int i = 0; i < horarios.length; i++) {
            if(horarios[i].equals(horario) && !disponibilidad[i]) {
                disponibilidad[i] = true;
                System.out.println("reserva cancelada en " + nombre);
                return;
            }
        }
        System.out.println("no se encontro reserva para cancelar en el horario");
    }
}

class Estudiante {
    String nombre;
    String id;

    Estudiante(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    boolean reservarEspacio(EspacioRecreacional espacio, String horario) {
        System.out.println("\nEstudiante " + nombre + " (id: " + id + ") intetando reservar:");
        return espacio.reservar(horario);
    }
}

class GestionRecreacional {
    EspacioRecreacional[] espacios;
    int numEspacios;
    int maxEspacios;

    GestionRecreacional(int maxEspacios) {
        this.maxEspacios = maxEspacios;
        this.espacios = new EspacioRecreacional[maxEspacios];
        this.numEspacios = 0;
    }

    void registrarEspacio(EspacioRecreacional espacio) {
        if(numEspacios < maxEspacios) {
            espacios[numEspacios] = espacio;
            numEspacios++;
            System.out.println("espacio registrado: " + espacio.nombre);
        } else {
            System.out.println("no se pueden registrar mas espacios");
        }
    }

    void verificarDisponibilidad() {
        System.out.println("\n=== disponibilidad de los espacios ===");
        for(int i = 0; i < numEspacios; i++) {
            espacios[i].mostrarDisponibilidad();
        }
    }

    void cancelarReserva(String nombreEspacio, String horario) {
        for(int i = 0; i < numEspacios; i++) {
            if(espacios[i].nombre.equals(nombreEspacio)) {
                espacios[i].cancelarReserva(horario);
                return;
            }
        }
        System.out.println("no se encontro el spacio especificado");
    }
}

public class SistemaReservas {
    public static void main(String[] args) {
        
        GestionRecreacional gestion = new GestionRecreacional(5);

        EspacioRecreacional cancha = new EspacioRecreacional("cancha de fulbol", "cancha", 22);
        EspacioRecreacional sala = new EspacioRecreacional("sala de juegos", "sala", 10);

        gestion.registrarEspacio(cancha);
        gestion.registrarEspacio(sala);

        Estudiante estudiante1 = new Estudiante("wolf yisus", "192368");
        Estudiante estudiante2 = new Estudiante("alexis", "192350");

        gestion.verificarDisponibilidad();

        estudiante1.reservarEspacio(cancha, "6:00");
        estudiante2.reservarEspacio(cancha, "7:00");
        estudiante1.reservarEspacio(sala, "8:00");

        gestion.verificarDisponibilidad();

        System.out.println("\nCancelando reserva:");
        gestion.cancelarReserva("cancha de fulbol", "6:00");

        gestion.verificarDisponibilidad();
    }
}