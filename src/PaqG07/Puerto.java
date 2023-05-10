package PaqG07;

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

    @Override
    public String toString() {
        StringBuilder mapa = new StringBuilder();
        for(int i=0; i<3; i++){
            mapa.append("Hub ").append(i + 1).append("\n").append(hubs[i].toString()).append("\n");
        }
        return mapa.toString();
    }
}
