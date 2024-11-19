# Parcial-2
Haider Carreño 192350 // Jesus Zapata 192342

## reservas de espacios recreacionales en una institución.
sirve a los estudiantes para consultar, horarios en diferentes tipos de espacios, tambien para que puedan administarlo 

1. 
Creamos la clase Espaciorecreacional con los atributos String nombre que no da el nombre del espacio, String tipo ese nos dice si es una cancha o sala, Int capacidad es la capacidad max, String[] horario es una array para guardar los horario que hay desde las 6 hasta las 10,boolean[] disponibilidad para que sea true si está disponkble y si no está disponible false

2. 
Creamos los siguientes metodos EspacioRecreacional(String nombre, String tipo, int capacidad) este es para inicializar un espacio, void inicializarHorarios() este marca los horarios como disponible , boolean reservar(String horario) lo hice para reservar si está disponibles, 
void mostrarDisponibilidad() Muestra la dispoibilidad actual del horario, void cancelarReserva(String horario)`: Cancela una reserva que ya existe.

3. 
tenemos los siguientes atributos String nombre, String ide ID del estudiante 

4. 
Estudiante(String nombre, String id) este constructor era para inicializar el estudiante, boolean reservarEspacio(EspacioRecreacional espacio, String horario) Este para poder reservar el horario. En la calse GestionRecreacional para gestionar los espacios registrados 

5. 
EspacioRecreacional[] espacios es para la lista de espacios que se regiatró, int numEspacios este nos dara el numero actual de espacio que se resgistro , int maxEspacios número máximo de espacios permitidos en el sistema.

6. 
GestionRecreacional(int maxEspacios) este metodo define el número máximo de espacios, void registrarEspacio(EspacioRecreacional espacio) este permite registrar un espacio recreacional, void verificarDisponibilidad() Para mostrar la disponibilidad de todos los espacios registrados.

7. 
void cancelarReserva(String nombreEspacio, String horario) cancela una reserva en un espacio específico.

8.  
Clase SistemaReservas (Main) es la entrada del programa, lo que haces es ejecutar las acciones principales que son crear las genstion de espacios y tambien lass instancias que interactuan, verifica si está disponble realiza reservas y cancela.  