import java.util.ArrayList;
import java.util.List;
// import java.util.Stack;
public class Evento {
    public String fecha;             // Fecha del evento
    public String hora;              // Hora del evento
    public String lugar;             // Lugar del evento
    public String tdp;     // partido a ocurrir
    public List<Entrada> entradas;   // Lista de entradas disponibles para el evento
    public int numerodelaultimaentrada;
    
    
    public Evento(String fecha, String hora, String lugar, String tdp) {
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
        this.tdp = tdp;
        this.entradas = new ArrayList<>();   // Inicializar la lista de entradas vacía
    }

    public void agregarEntrada(Entrada entrada) {
        entradas.add(entrada);   // Agregar una entrada a la lista de entradas disponibles
    }

    public List<Entrada> getEntradasDisponibles() {
        List<Entrada> disponibles = new ArrayList<>();
        for (Entrada entrada : entradas) {
            if (!entrada.isOcupada()) {
                disponibles.add(entrada);   // Agregar a la lista de entradas disponibles si no está ocupada
            }
        }
        return disponibles;
    }

    public List<Entrada> getEntradasOcupadas() {
        List<Entrada> ocupadas = new ArrayList<>();
        for (Entrada entrada : entradas) {
            if (entrada.isOcupada()) {
                ocupadas.add(entrada);   // Agregar a la lista de entradas ocupadas si está ocupada
            }
        }
        return ocupadas;
    }
    public Entrada comprarEntrada(int numeroEntrada, String nombreComprador, String correoComprador, long telefonoComprador) {
        for (Entrada entrada : entradas) {
            if (entrada.getNumero() == numeroEntrada && !entrada.isOcupada()) {
                entrada.setOcupada(true);
                entrada.setNombreComprador(nombreComprador);
                entrada.setCorreoComprador(correoComprador);
                entrada.setTelefonoComprador(telefonoComprador);
                return entrada;   // Devolver la entrada comprada
            }
        }
    
        return null;   // No hay entradas disponibles o el número de entrada es inválido
    }
    public int geLastNum(){
        List<Entrada> disponibles = getEntradasDisponibles();
        int cantidad_de_entradas_disponibles = disponibles.size();
        if (cantidad_de_entradas_disponibles==0)
        {numerodelaultimaentrada = 0;}
        else{
            Entrada ultimoElemento = disponibles.get((cantidad_de_entradas_disponibles-1));
            numerodelaultimaentrada= ultimoElemento.getNumero();}
        return numerodelaultimaentrada;
    }    
    
    
}

// public int geLastNum(){
//     List<Entrada> disponibles = getEntradasDisponibles();
//     Stack<Entrada> piladisponibles= new Stack<Entrada>();//Inclucion forzada de contenido peruano.
//     if(disponibles.isEmpty())
//     {numerodelaultimaentrada = 0;}
//     else{
//         try{
//             Entrada ultimoElemento= piladisponibles.peek();
//             for (int i = 0; i == disponibles.size(); i++) {
//                 ultimoElemento = piladisponibles.peek();
//                 piladisponibles.push(disponibles.get(i));}
//                 numerodelaultimaentrada= ultimoElemento.getNumero();}
//              catch (Exception isEmpty) {
//                 numerodelaultimaentrada = 0;
//                 // TODO: handle exception
//             }}
        
//     return numerodelaultimaentrada;
// }