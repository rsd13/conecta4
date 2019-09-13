/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package conecta4;

/**
 *
 * @author sistemas inteligentes
 */
public class Main {

    //Tamaño del tablero
    static final int m_columnas = 7;
    static final int m_filas = 6;

    //Tiempo de espera máximo para una jugada
    static final int m_tiempoMaximo = 2000000;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Crea el juego
        Juego m_juego = new Juego(m_columnas,m_filas,m_tiempoMaximo,0,1);
        
        //Crea e inicia la interfaz del juego
        Interfaz interfaz = new Interfaz(m_juego);
            
        interfaz.setVisible(true);}}
        
        /*Tablero tablero = new Tablero(m_columnas,m_filas);
        tablero.ponerFicha(1, 1);
        tablero.ponerFicha(2, 1);
        tablero.ponerFicha(3, 1);
        tablero.ponerFicha(3, 2);
        tablero.ponerFicha(3, 2);
        tablero.ponerFicha(5, 2);
        int auxv;

        
        auxv = V(tablero,true,2,2);
        
        System.out.print(auxv);
        
        
       
    }
    
     public static int V(Tablero m_tablero, boolean maxmin, int jugador, int nivelActual){
        int columna,puntuacion,Primernodo,auxPuntuacion;
        
       columna = puntuacion =  Primernodo = auxPuntuacion = 0;

        
        if (m_tablero.tableroLleno() == true || m_tablero.cuatroEnRaya() != 0 || nivelActual == 0) { //Caso base empate o hay ganador o nivel = 0
            return F(m_tablero, jugador); 
             
        }else{ //Caso recursivo. Reducimos el nivel actual. 
            for(int i = 0; i < m_tablero.numColumnas(); i++){ //Recorro todas las columnas 
                if(m_tablero.comprobarColumna(i) != -1){//Si la columna está disponible
                    Tablero auxTablero = new Tablero(m_tablero); //Creo una copia del tablero
                    if(auxTablero.ponerFicha(i, jugador) == 0){ //Pongo la ficha
                        //Cambio los valores del jugador y maxmin1
                        if(maxmin)  jugador = cambiarJugador(jugador);
                        auxPuntuacion =  V( auxTablero, !maxmin, jugador, nivelActual-1); 
                        
                        if(Primernodo == 0){ //Si es primer dato del nodo
                           puntuacion = auxPuntuacion;
                           columna= i;
                           Primernodo++;
                        }else{ //Si no es el primer dato que tengo
                             
                            if(maxmin){
                                if(auxPuntuacion >= puntuacion){
                                    puntuacion = auxPuntuacion;
                                    columna = i;
                                }
                            }else{
                                 if(auxPuntuacion <= puntuacion){ 
                                    puntuacion = auxPuntuacion; 
                                    columna = i;
                                }
                            }
                        }
                    }   
                }
            }
            
            if(nivelActual == 2)return columna; 
            else return puntuacion;
            
        }
    }
    
 
    // cambiamos el jugador
    public static int cambiarJugador(int jugador){
        if(jugador == 1) jugador = 2;
        else jugador = 1;
        return jugador;
    }
   
   
   public static int F(Tablero tableroCopia,int jugador){
        int puntuacion,casillaCopia;
        puntuacion = 0;
        // cambiamos de jugador
        //recorremos el tablero, sale si no pued emirar mas para "arriba"
        for(int i = 0; i < tableroCopia.numFilas();i++){
           for(int j = 0; j < tableroCopia.numColumnas();j++){
               casillaCopia = tableroCopia.obtenerCasilla(i, j);
               //comprobamos si no esta vacia.
               if(casillaCopia != 0){
                    puntuacion+= comprobarVertical(i,j,tableroCopia,jugador);
                    puntuacion+= comprobarHorizontal(i,j,tableroCopia,jugador);
                    puntuacion+= comprobarDiagonal(i,j,tableroCopia,jugador);
               }
           }
        }
       
        return puntuacion;
       
    }

   
   
    public static int comprobarHorizontal(int i,int j,Tablero tableroCopia,int jugador){

        boolean jugadorContrario,fichaOpuesta;
        int result,aux1,aux2,puntuacionIz,puntuacionDe,auxJ;
        //guardamos la j
        
        auxJ = j;
        puntuacionDe = puntuacionIz = result = aux1 = aux2 = 0;
        fichaOpuesta =  jugadorContrario = false;
        //obtendremos de quien es la casilla inicial
        aux2 = tableroCopia.obtenerCasilla(i, auxJ);
        //s ila ficha es la contraria, ponemos otra ponderacion.
        if(aux2 != jugador){
            jugadorContrario = true;
            //cambiamos la ficha del jugador.
            if(jugador == 1) jugador = 2;
            else jugador = 1;
        }
        // miramos a la derecha
        if(j<=3){
            for(int k = 0; k < 3 && !fichaOpuesta;k++){
                auxJ++;//aumentamos aqui la posicion
                aux1 = tableroCopia.obtenerCasilla(i, auxJ);
                //si esta vacia la ficha
                if(aux1 == 0){
                    //si esta vacia le sumo 1
                    puntuacionDe += 2;
                }else if(aux1 == jugador){
                    //si es de tu jugadoor sumo 2
                    puntuacionDe += 3;
                //si es la ficha opuesta se sale
                }else fichaOpuesta = true;
            }         
        }
        //miro a ver si puede hacer 4 en raya
        if(puntuacionDe == 8) puntuacionDe += 100;
        auxJ = j;
        //miramos a la izquierda
        if(j >=3){
            for(int k = 0; k < 3 && !fichaOpuesta;k++){
                auxJ--;//aumentamos aqui la posicion
                aux1 = tableroCopia.obtenerCasilla(i, auxJ);
                //si esta vacia la ficha
                if(aux1 == 0){
                    //si esta vacia le sumo 1
                    puntuacionIz += 2;
                }else if(aux1 == jugador){
                    //si es de tu jugadoor sumo 2
                    puntuacionIz += 3;
                //si es la ficha opuesta se sale
                }else fichaOpuesta = true;
            }         
        }
        if(puntuacionIz == 8) puntuacionIz += 100;
        //IDEA INICIAL
        
        result = puntuacionDe + puntuacionIz;
        if(jugadorContrario) result *= -1;
        return result;
    }
    
    public static int comprobarVertical(int i,int j,Tablero tableroCopia,int jugador){
        //mira a ver si no ha encontrado ninguna ficha
        boolean jugadorContrario,fichaOpuesta;
        int result,aux1,aux2,numVacias,auxI;
        
        auxI = i;
        fichaOpuesta =  jugadorContrario = false;
        numVacias = result = aux1 = aux2 = 0;

        //obtendremos de quien es la casilla inicial
        aux2 = tableroCopia.obtenerCasilla(i, j);
        //s ila ficha es la contraria, ponemos otra ponderacion.
        if(aux2 != jugador){
            jugadorContrario = true;
            //cambiamos la ficha del jugador.
            if(jugador == 1) jugador = 2;
            else jugador = 1;
        }
        
        if(i <= 2){
            //sale si se ha encontrado uina fihca opuesta, o e
            //el numero de vacias es 2 ya que es imposible continuar
            for(int k = 0; k < 3 && !fichaOpuesta;k++){
                auxI++;//aumentamos aqui la posicion
                //obtengo la casilla
                aux1 = tableroCopia.obtenerCasilla(auxI, j);
                //si esta vacia la ficha
                if(aux1 == 0){
                    numVacias++;
                    //si esta vacia le sumo 1
                    result += 1;
                    //sale del bucle porque no tiene sentido
                    //ver mas de uno.
                    if(numVacias == 1) fichaOpuesta = true;
                }else if(aux1 == jugador){
                    //si es de tu jugadoor sumo 2
                    result += 2;
                //si es la ficha opuesta se sale
                }else fichaOpuesta = true;
            }         
        }
        //evito el 4 el raya
        if(result == 5) result += 100;
        
        //IDEA INICIAL
        if(jugadorContrario) result *= -1;
        return result;
    }
   
    public static int comprobarDiagonal(int i,int j,Tablero tableroCopia,int jugador){
       
       
       boolean jugadorContrario,fichaOpuesta;
       int result,aux1,aux2,numVacias,auxI,auxJ;
       int puntuacionArriba,puntuacionAbajo;
       
       puntuacionArriba = puntuacionAbajo = 0;
        
       fichaOpuesta =  jugadorContrario = false;
       numVacias = result = aux1 = aux2 = 0;

       //obtendremos de quien es la casilla inicial
       aux2 = tableroCopia.obtenerCasilla(i, j);
       //s ila ficha es la contraria, ponemos otra ponderacion.
       if(aux2 != jugador){
            jugadorContrario = true;
            //cambiamos la ficha del jugador.
            if(jugador == 1) jugador = 2;
            else jugador = 1;
       }
       auxJ = j;
       auxI = i;
       
       if(i+3 < tableroCopia.numFilas()){
           
            if(j-3 >= 0){
                for(int k = 0; k < 3 && !fichaOpuesta;k++){
                    auxI++;//aumentamos aqui la posicion
                    auxJ--;
                    //obtengo la casilla
                    aux1 = tableroCopia.obtenerCasilla(auxI, auxJ);
                    //si esta vacia la ficha
                    if(aux1 == 0){
                        numVacias++;
                        //si esta vacia le sumo 1
                        puntuacionAbajo += 2;
                        //sale del bucle porque no tiene sentido
                        //ver mas de uno.
                        if(numVacias == 2) fichaOpuesta = true;
                    }else if(aux1 == jugador){
                        //si es de tu jugadoor sumo 2
                        puntuacionAbajo += 3;
                    //si es la ficha opuesta se sale
                    }else fichaOpuesta = true;
                }         
            }
            auxJ = j;
            auxI = i;
            if(j+3 < tableroCopia.numColumnas()){
                for(int k = 0; k < 3 && !fichaOpuesta;k++){
                    auxI++;//aumentamos aqui la posicion
                    auxJ++;
                    //obtengo la casilla
                    aux1 = tableroCopia.obtenerCasilla(auxI, auxJ);
                    //si esta vacia la ficha
                    if(aux1 == 0){
                        numVacias++;
                        //si esta vacia le sumo 1
                        puntuacionArriba += 2;
                        //sale del bucle porque no tiene sentido
                        //ver mas de uno.
                        if(numVacias == 2) fichaOpuesta = true;
                    }else if(aux1 == jugador){
                        //si es de tu jugadoor sumo 2
                        puntuacionArriba += 3;
                    //si es la ficha opuesta se sale
                    }else fichaOpuesta = true;
                }         
            }
       }
       
       if(puntuacionAbajo == 8) puntuacionAbajo += 100;
       if(puntuacionArriba == 8) puntuacionArriba += 100;
       
       
       result = puntuacionAbajo + puntuacionArriba;
       
       if(jugadorContrario) result *= -1;
       
       return result;
   }
}*/