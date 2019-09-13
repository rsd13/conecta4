/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package conecta4;


import java.util.ArrayList;

/**
 *
 * @author sistemas inteligentes
 */
public class JugadorMaquina extends Jugador{

    //Profundidad hasta la que se va a desarrollar el árbol de juego
public final static int NIVEL_DEFECTO = 2;

    //Constructor
    public JugadorMaquina(int jugador)
    {
        super(jugador);
    }

    // Función que se ejecuta en el thread
    public void run()
    {
        //Llama a la función Minimax que implementa el algoritmo para calcular la jugada

        minimax();
     
        //No borrar esta línea!!
        isDone(true);
    }
    //la i es columna, j es fila

    /**
     * Se debe determinar la mejor jugada mediante Minimax. El tablero de juego se
     * encuentra en la variable m_tablero.
     * Al final de la función de la variable m_columna debe contener la tirada.
     * @return
     */
    public void minimax()
    {
        //true es max
        //false es min
        int columnaFinal = -1;
        boolean maxMin = true;
        int nivelActual = 0;
        boolean buenaTirada = false;
        
        Tablero tablero = new Tablero(m_tablero);
        
        //aqui se elige si quieres poda
        if(Interfaz.alfaBeta){
            columnaFinal = VAlfayBeta(tablero,maxMin,m_jugador,nivelActual,Integer.MIN_VALUE, Integer.MAX_VALUE);
        }else{
            columnaFinal = V(tablero,maxMin,m_jugador,nivelActual);
        }
      
        if(m_tablero.comprobarColumna(columnaFinal)!= -1){
            buenaTirada = true;
            m_columna = columnaFinal;
        }else{
            m_columna = (int) (Math.random()*m_tablero.numColumnas());
        }


    }
  
    public int VAlfayBeta(Tablero tablero1, boolean maxmin, int jugador, int nivelActual,int alpha, int beta){
        int columna,puntuacion,primerNodo,auxPuntuacion;
        columna = puntuacion =  primerNodo = auxPuntuacion = 0;

        if (tablero1.tableroLleno()|| tablero1.cuatroEnRaya() != 0 || nivelActual == NIVEL_DEFECTO) { 
            return F(tablero1, m_jugador); 
             
        }else{
            for(int i = 0; i <m_tablero.numColumnas() ; i++){
                //creo la copia del tablero
                Tablero auxTablero = new Tablero(tablero1); 
                //miro a ver si se puede poner
                if(auxTablero.ponerFicha(i, jugador) == 0){
                    // si es max
                    if(maxmin){
                        
                        alpha =  VAlfayBeta( auxTablero, !maxmin, jugador-1,nivelActual+1,alpha,beta); 
                        if(alpha > puntuacion || primerNodo == 0){ 
                             puntuacion = alpha;
                             columna= i;
                             primerNodo++;
                        }
                        if(alpha >= beta) return beta;
                    }else{
                        beta =  VAlfayBeta( auxTablero, !maxmin, jugador+1,nivelActual+1,alpha,beta); 
                        if(beta < puntuacion || primerNodo == 0 ){ 
                            puntuacion = beta; 
                            columna = i;
                            primerNodo++;
                        }
                         if(alpha >= beta) return alpha;
                    }
                }
            }
            if(nivelActual == 0)return columna; 
            return puntuacion;
            
        }
    }
    
    public int V(Tablero tablero1, boolean maxmin, int jugador, int nivelActual){
        int columna,puntuacion,Primernodo,auxPuntuacion;
        
        columna = puntuacion =  Primernodo = auxPuntuacion = 0;
        
        if (tablero1.tableroLleno()|| tablero1.cuatroEnRaya() != 0 || nivelActual == NIVEL_DEFECTO) { 
            return F(tablero1, m_jugador); 
             
        }else{
            for(int i = 0; i <m_tablero.numColumnas() ; i++){
                //creo la copia del tablero
                Tablero auxTablero = new Tablero(tablero1); 
                //miro a ver si se puede poner
                if(auxTablero.ponerFicha(i, jugador) == 0){ 
                    if(maxmin){
                     
                        auxPuntuacion =  V( auxTablero, !maxmin, jugador-1,nivelActual+1);  
                        //miro si es la primera vez o si la puntuacion es mejor
                        if(auxPuntuacion > puntuacion || Primernodo == 0){  
                             puntuacion = auxPuntuacion; 
                             columna= i;
                             Primernodo++;
                        }
                        
                    }else{
                         
                        auxPuntuacion =  V( auxTablero, !maxmin, jugador+1,nivelActual+1);  

                        if(auxPuntuacion < puntuacion || Primernodo == 0 ){  
                            puntuacion = auxPuntuacion;  
                            columna = i;
                            Primernodo++;
                        }
                         
                    }
                }
                
            }
            if(nivelActual == 0)return columna; 
            return puntuacion;
            
        }
    }
    
    public  int F(Tablero tableroCopia,int jugador){
        int puntuacion = 0;
        for(int i = 0; i < tableroCopia.numFilas();i++){
           for(int j = 0; j < tableroCopia.numColumnas();j++){
               // mientras que la casilla no este vacia
               if(tableroCopia.obtenerCasilla(i,j ) != 0 ){
                    puntuacion += comprobarHorizontal(i,j,tableroCopia,jugador);
                    puntuacion += comprobarVertical(i,j,tableroCopia,jugador);
                    puntuacion += comprobarDiagonal(i,j,tableroCopia,jugador);
                   
               }
           }
        }
       
        return puntuacion;
       
    }
    
    public  int comprobarVertical(int i,int j,Tablero tableroCopia,int jugador){
        //mira a ver si no ha encontrado ninguna ficha
        boolean salir = false;
        int result,casillaActual,jugadorCasilla,auxI,ficha,vacio;
        ficha = vacio = result = casillaActual = jugadorCasilla = 0;

        //obtendremos de quien es la casilla inicial
        jugadorCasilla = tableroCopia.obtenerCasilla(i, j);
    
        // miro arriba
        auxI = i;
        for(int k = 0; k < 3 && !salir;k++){
            auxI++;
            if(auxI >= 0 && auxI <= 5 && j>= 0 && j <=6){
                //miro a quien pertenece la casilla
                casillaActual = tableroCopia.obtenerCasilla(auxI, j);
                if(casillaActual == 0) vacio++;
                else if (casillaActual == jugadorCasilla) ficha++;
                else if (casillaActual != jugadorCasilla)salir = true;
            }else salir = true;
            
        }
        result = puntuacion(ficha,vacio);
     
        //si es el jugador contrario a la jugada
        if(jugadorCasilla != jugador) result *= -1;
        return result;
    }
    
    
    public  int comprobarHorizontal(int i,int j,Tablero tableroCopia,int jugador){
        //mira a ver si no ha encontrado ninguna ficha
        boolean salir = false;
        int result,casillaActual,jugadorCasilla,auxJ,vacio,ficha;
        vacio = ficha = result = casillaActual = jugadorCasilla = 0;

        //obtendremos de quien es la casilla inicial
        jugadorCasilla = tableroCopia.obtenerCasilla(i, j);
    
        auxJ = j;
        for(int k = 0; k < 3 &&  !salir ;k++){
           auxJ++;
            if(i >= 0 && i <= 5 && auxJ >= 0 && auxJ <=6){
                casillaActual = tableroCopia.obtenerCasilla(i, auxJ);
                if(casillaActual == 0) vacio++;
                else if (casillaActual == jugadorCasilla) ficha++;
                else if (casillaActual != jugadorCasilla)salir = true;
            }else salir = true;
           
        }
        //la puntuacion obtenida por la derecha
        result = puntuacion(ficha,vacio);
        
        //miro la izquierda
        auxJ = j;
        vacio = ficha = 0;
        for(int k = 0; k < 3 &&  !salir ;k++){
            auxJ--;//aumentamos aqui la posicion
            //obtengo la casilla
            if(i >= 0 && i <= 5 && auxJ >= 0 && auxJ <=6){
                casillaActual = tableroCopia.obtenerCasilla(i, auxJ);
                if(casillaActual == 0) vacio++;
                else if (casillaActual == jugadorCasilla) ficha++;
                else if (casillaActual != jugadorCasilla)salir = true;
            }else salir = true;
            
        }
        
        int izquierda = puntuacion(ficha,vacio);
        result += izquierda;

        if(jugadorCasilla != jugador) result *= -1;
        return result;
    }
   
    //repasar metodo diagonal
    public  int comprobarDiagonal(int i,int j,Tablero tableroCopia,int jugador){
        //mira a ver si no ha encontrado ninguna ficha
        boolean salir = false;
        int result,casillaActual,jugadorCasilla,auxJ,auxI;
        int vacio,ficha;

        vacio = ficha = result = casillaActual = jugadorCasilla = 0;

       //diagonal-derecha-abajo
        jugadorCasilla = tableroCopia.obtenerCasilla(i, j);
        auxJ = j;
        auxI = i;
        for(int k = 0; k < 3 &&  !salir && j-3 >= 0 ;k++){
             auxI++;
             auxJ--;
             if(auxI >= 0 && auxI <= 5 && auxJ >= 0 && auxJ <=6){
                casillaActual = tableroCopia.obtenerCasilla(auxI, auxJ);
                if(casillaActual == 0) vacio++;
                else if (casillaActual == jugadorCasilla) ficha++;
                else if (casillaActual != jugadorCasilla)salir = true;
            }else salir = true;

         }
         result = puntuacion(ficha,vacio);

         ficha = vacio = 0;
         auxJ = j;
         auxI = i;
         for(int k = 0; k < 3 && !salir && j+3 >= tableroCopia.numColumnas() ;k++){
             auxI++;
             auxJ++;
             if(auxI >= 0 && auxI <= 5 && auxJ >= 0 && auxJ <=6){
                casillaActual = tableroCopia.obtenerCasilla(auxI, auxJ);
                if(casillaActual == 0) vacio++;
                else if (casillaActual == jugadorCasilla) ficha++;
                else if (casillaActual != jugadorCasilla)salir = true;
            }else salir = true;

         }
         int diagonalDerecha = puntuacion(ficha,vacio);
         result += diagonalDerecha;

       if(jugadorCasilla != jugador) result *= -1;
       return result;
   }
     
    public int puntuacion(int ficha,int vacio){
        int result = 0;
       
        //caso que mira que hay 4 en raya
        if(ficha == 3)  result =  2*10000000;
        //caso de 3 en raya y uno vacio
        if(ficha == 2 && vacio == 1) result = 10000000;
        else if(ficha == 1 && vacio == 2) result =  10*600;
        //por si encuentra dos adyacentes y de la posicion del tablero
        else if(ficha == 2 && vacio == 0) result = 10*400;
        else if(vacio == 3) result =  10*200;
        return result;
    }
}