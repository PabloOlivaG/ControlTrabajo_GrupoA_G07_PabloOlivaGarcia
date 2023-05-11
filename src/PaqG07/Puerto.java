package PaqG07;
//Pablo Oliva García
public class Puerto {

    Hub[] hubs;

    public Puerto(){
        this.hubs = new Hub[3];
        for (int i = 0; i < 3; i++) {
            hubs[i] = new Hub();
        }
    }

    public int apilar(Contenedor cont){
        for (int i = 0; i < 3; i++) {
            if(hubs[i].AñadirContenedor(cont) == 0){
                return 0;
            }else if(hubs[i].AñadirContenedor(cont) == 2){
                return 2;
            }
        }
        return 1;
    }

    public int desapilar(int columna){
        for (int i = 2; i >= 0; --i) {
            if(hubs[i].QuitarContenedor(columna) == 0){
                return 0;
            }
        }
        return 1;
    }

    public int paises(String p){
        int c = 0;
        for (int i = 0; i < 3; i++) {
            c = c + hubs[i].procedentes(p);
        }
        return c;
    }

    public String contenedor(int id){
        for (int i = 0; i < 3; i++) {
            if(!hubs[i].MostrarDatos(id).equals("err")){
               return hubs[i].MostrarDatos(id);
            }
        }
        return "No existe el contenedor con ID " + id;
    }

    private String infoContenedorRedu(int hub, int fila, int columna){
        return "ID: "+hubs[hub].getHub()[fila][columna].getId()+
                "\nEmpresaRemitente: "+hubs[hub].getHub()[fila][columna].getEmpresaEmisora()+
                "\nPeso: "+hubs[hub].getHub()[fila][columna].getPeso()+
                "\nChekeo: "+hubs[hub].getHub()[fila][columna].getInspeccionado();
    }

    public String buscarPrioridad(int prioridad){
        StringBuilder resul = new StringBuilder();
        for(int i=0; i<3; i++){ //Recorremos todos los hubs
            resul.append("\n-------------\n").append("Hub ").append(i+1).append(":\n-------------\n");
            for(int j=0; j<12; j++) { //Por cada hub vamos recorriendo todas las columnas
                if(hubs[i].getHub()[9][j] != null) {
                    if (hubs[i].getHub()[9][j].getPrioridad() == prioridad) { //Comprobamos la prioridad de los contenedores en la última fila de cada columna
                        resul.append(this.infoContenedorRedu(i, 9, j)).append("\n-------------\n"); //Si el contenedor tiene esa prioridad usamos la función que devuelve su info reducida
                    }
                }
            }
        }
        return resul.toString();
    }

    @Override
    public String toString() {
        StringBuilder mapa = new StringBuilder();
        for(int i=0; i<3; i++){
            mapa.append("Hub ").append(i + 1).append("\n").append(hubs[i].toString()).append("\n");
        }
        return mapa.toString();
    }
}
