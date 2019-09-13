/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Interfaz.java
 *
 * 
 */

package conecta4;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author sistemas inteligentes
 */
public class Interfaz extends javax.swing.JFrame {

    Juego m_nuevoJuego;

    /** Creates new form Interfaz */
    public Interfaz(Juego juego) {

        initComponents();
        m_nuevoJuego=juego;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonHH = new javax.swing.JButton();
        jButtonHM = new javax.swing.JButton();
        jButtonMM = new javax.swing.JButton();
        boton1 = new javax.swing.JToggleButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Práctica Sistemas Inteligentes 2016/2017");
        setResizable(false);

        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 346, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Selecciona un modo de juego");

        jButtonHH.setText("Humano/Humano");
        jButtonHH.setFocusPainted(false);
        jButtonHH.setRequestFocusEnabled(false);
        jButtonHH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHHActionPerformed(evt);
            }
        });

        jButtonHM.setText("Humano/Máquina");
        jButtonHM.setRequestFocusEnabled(false);
        jButtonHM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHMActionPerformed(evt);
            }
        });

        jButtonMM.setText("Máquina/Máquina");
        jButtonMM.setRequestFocusEnabled(false);
        jButtonMM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMMActionPerformed(evt);
            }
        });

        boton1.setText("Alfa-Beta");
        boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton1ActionPerformed(evt);
            }
        });

        jMenu2.setText("Archivo");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Nuevo Juego");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar2.add(jMenu2);

        setJMenuBar(jMenuBar2);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(20, 20, 20)
                        .add(jButtonHH)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButtonHM)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButtonMM))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(boton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButtonHH)
                    .add(jButtonHM)
                    .add(jButtonMM))
                .add(14, 14, 14)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel1)
                    .add(boton1))
                .add(32, 32, 32)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Función que se ejecuta al pulsar el botón Humano/Humano
    private void jButtonHHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHHActionPerformed
        //Debe indicar que el modo de juego es Humano/Humano
        //Esa modalidad es la modalidad 1
        m_nuevoJuego.setJuego(1);
        repaint();
        jButtonHH.setEnabled(false);
        jButtonHM.setEnabled(false);
        jButtonMM.setEnabled(false);
        
}//GEN-LAST:event_jButtonHHActionPerformed

    //Función que se ejecuta al pulsar el botón Humano/Máquina
    private void jButtonHMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHMActionPerformed
        //Debe indicar que el modo de juego es Humano/Máquina
        //Esa modalidad es la modalidad 2
        m_nuevoJuego.setJuego(2);
        repaint();
        jButtonHH.setEnabled(false);
        jButtonHM.setEnabled(false);
        jButtonMM.setEnabled(false);
}//GEN-LAST:event_jButtonHMActionPerformed

    //Función que se ejecuta al pulsar el botón Máquina/Máquina
    private void jButtonMMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMMActionPerformed
        //Debe indicar que el modo de juego es Máquina/Máquina
        //Esa modalidad es la modadlidad 3
        m_nuevoJuego.setJuego(3);
        repaint();
        jButtonHH.setEnabled(false);
        jButtonHM.setEnabled(false);
        jButtonMM.setEnabled(false);
        
        while(m_nuevoJuego.getJugando())
        {
             try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {}
             
            m_nuevoJuego.controlJuego();
            
            paint(getGraphics());
        }
}//GEN-LAST:event_jButtonMMActionPerformed

    
    //Cuando se mueve el ratón por el panel se ejecuta este evento
    //Dibuja en la parte superior de la ventana la ficha que va a colocar el jugador
    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved

        float anchoCasilla, altoCasilla, margenAncho;
        int columna;
        Graphics g;

        //Únicamente tiene que dibujar la ficha si es el turno del jugador humano:
        //En caso que el turno sea del jugador 1 en el caso de Humano/Máquina
        //o el cualquier caso si estamos en el modo Humano/Humano
        //y además únicamente, si el juego ha empezado.
        if(m_nuevoJuego.getJugando())
        {
            if(m_nuevoJuego.getModo() == 1 ||  (m_nuevoJuego.getModo()==2 && m_nuevoJuego.getTurno()==1))
            {
                //Determina a qué columna está más cercano el ratón
                //Calcula el tamaño de cada casilla
                anchoCasilla = (jPanel1.getSize().width-40)/m_nuevoJuego.m_tablero.numColumnas();
                altoCasilla = (jPanel1.getSize().height-70)/m_nuevoJuego.m_tablero.numFilas();
                margenAncho = (float) (0.2 * anchoCasilla);

                //Calcula la columna más cercana en la que se encuentra el ratón
                columna = (int) ((evt.getX()-40)/anchoCasilla);

                //Si la columna es correcta
                if(columna>=0 && columna<m_nuevoJuego.m_tablero.numColumnas())
                {
                    //Dibuja la ficha en la parte superior del panel
                    g = jPanel1.getGraphics();

                    //Antes de dibujar la ficha realiza un borrado por si había una ficha anterior
                    g.setColor(jPanel1.getBackground());
                    g.fillRect(0,0,jPanel1.getSize().width,50);
                    
                    //Para saber de qué color tiene que dibujar la ficha comprueba el turno
                    if(m_nuevoJuego.getTurno() == 1)
                        g.setColor(Color.RED);
                    else
                        g.setColor(Color.YELLOW);

                    //Dibuja la ficha
                    g.fillOval((int)(margenAncho)+(int)(columna*anchoCasilla+20), 5, (int) (0.8*altoCasilla), (int) (0.8*altoCasilla));
                }
            }
        }
    }//GEN-LAST:event_jPanel1MouseMoved

    
    //Esta función inserta la ficha en el tablero cuando el jugador hace clic
    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        float anchoCasilla, altoCasilla, margenAncho;
        int columna;

        //Únicamente tiene que insertar la ficha si es el turno del jugador humano:
        //En caso que el turno sea del jugador 1 en el caso de Humano/Máquina
        //o el cualquier caso si estamos en el modo Humano/Humano
        //y además únicamente, si el juego ha empezado.
        if(m_nuevoJuego.getJugando())
        {
            if(m_nuevoJuego.getModo() == 1 ||  (m_nuevoJuego.getModo()==2 && m_nuevoJuego.getTurno()==1))
            {
                //Determina a qué columna está más cercano el ratón
                //Calcula el tamaño de cada casilla
                anchoCasilla = (jPanel1.getSize().width-40)/m_nuevoJuego.m_tablero.numColumnas();
                altoCasilla = (jPanel1.getSize().height-70)/m_nuevoJuego.m_tablero.numFilas();
                margenAncho = (float) (0.2 * anchoCasilla);

                //Calcula la columna más cercana en la que se encuentra el ratón
                columna = (int) ((evt.getX()-40)/anchoCasilla);

                //Si la columna es correcta
                if(columna>=0 && columna<m_nuevoJuego.m_tablero.numColumnas())
                {
                    if(m_nuevoJuego.getTurno()==1)
                    {
                        //m_nuevoJuego.m_tablero.ponerFicha(columna, 1);
                        m_nuevoJuego.jugadaHumano(columna, 1);
                    }

                    if(m_nuevoJuego.getTurno()==2)
                    {
                        //m_nuevoJuego.m_tablero.ponerFicha(columna, 2);
                        m_nuevoJuego.jugadaHumano(columna, 2);
                    }

                    if(m_nuevoJuego.getJugando())
                    {
                        m_nuevoJuego.cambiaTurno();

                        //Si el juego aun no ha terminado y está en modo de juego 2
                        //Humano/Máquina después de poner ficha el humano debe ponerlo la máquina
                        if(m_nuevoJuego.getModo() == 2)
                        {
                            //Dibuja el tablero con la ficha del jugador 1
                            paint(getGraphics());
                            
                            m_nuevoJuego.controlJuego();
                        }
                    }

                   //Dibuja el tablero con la ficha del juegador 1
                    repaint();
                }
            }
        }

    }//GEN-LAST:event_jPanel1MouseClicked

    //Opción "Nuevo Juego" del menú Archivo
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        //Llama a la función que limpia el tablero y establece los parámetros iniciales
        m_nuevoJuego.reiniciarJuego();
        repaint();
        jButtonHH.setEnabled(true);
        jButtonHM.setEnabled(true);
        jButtonMM.setEnabled(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    public static Boolean alfaBeta = false;
    private void boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton1ActionPerformed
        // TODO add your handling code here:
        if (boton1.isSelected()){
            alfaBeta = true;
        }else{
            alfaBeta = false;
        }
    }//GEN-LAST:event_boton1ActionPerformed

    
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Interfaz(Juego juego).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton boton1;
    private javax.swing.JButton jButtonHH;
    private javax.swing.JButton jButtonHM;
    private javax.swing.JButton jButtonMM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables


    //Dibuja el tablero de juego.
    @Override
    @SuppressWarnings("static-access")
    public void paint(Graphics g)
    {
        
        float alturaTablero, anchuraTablero;
        float anchoCasilla, altoCasilla, margenAncho, margenAlto;
        int x,y;
        
        //Calcula el tamaño que tendrá el tablero. Le resta los márgenes izquierdo y superior respectivamente.
        anchuraTablero = jPanel1.getSize().width-40;
        alturaTablero = jPanel1.getSize().height-70;

        //Como estamos sobreescribiendo la función llamamos a la función padre.
        super.paint(g);
        g = jPanel1.getGraphics();

        //Dibuja el tablero como un rectángulo azul.
        g.setColor(Color.BLUE);
        g.fillRect(20,50,((int)anchuraTablero),((int)alturaTablero));


        //Una vez dibujado el tablero, crea cada una de las casillas del tablero.
        
        //Calcula el tamaño que ocupará cada casilla a patir del tamaño del tablero.
        anchoCasilla = (anchuraTablero)/m_nuevoJuego.m_tablero.numColumnas();
        altoCasilla = (alturaTablero)/m_nuevoJuego.m_tablero.numFilas();
        margenAncho = (float) (0.2 * anchoCasilla);
        margenAlto = (float) (0.1 * altoCasilla);

        //Dibuja cada una de las casillas
        for(int i=0; i<m_nuevoJuego.m_tablero.numColumnas();i++)
            for(int j=0; j<m_nuevoJuego.m_tablero.numFilas();j++)
            {
                
                //Si la casilla pertenece al jugador 1, la dibuja de color rojo
                if(m_nuevoJuego.m_tablero.obtenerCasilla(j, i) == 1)
                      g.setColor(Color.RED);
                else //Si la casilla pertenece al jugador 2, la dibuja de color amarillo
                    if(m_nuevoJuego.m_tablero.obtenerCasilla(j, i) == 2)
                        g.setColor(Color.YELLOW);
                    else //Si la casilla está vacía, la dibuja de color negro
                        g.setColor(Color.darkGray);

                //Calcula la posición en la que debe dibujar la casilla
                x = (int) (i * anchoCasilla+20);
                y = (int) (alturaTablero) - (int) (j * altoCasilla);

                //Dibuja la casilla
                g.fillOval((int)(x+margenAncho), (int)(y+margenAlto), (int) (0.8*altoCasilla), (int) (0.8*altoCasilla));
            }
        EscribeMensaje();
    }

   
    public void EscribeMensaje()
    {
        switch (m_nuevoJuego.m_mensaje){
            case 0:  jLabel1.setText("Selecciona un modo de juego");
                     break;
            case 1:  jLabel1.setText("Turno del jugador "+m_nuevoJuego.getTurno()+".");
                     break;
            case 2:  jLabel1.setText("Ha ganado el jugador "+m_nuevoJuego.getTurno()+".");
                     break;
            case 3:  jLabel1.setText("Empate. Tablero lleno.");
                     break;
            case 4:  jLabel1.setText("El jugador "+m_nuevoJuego.getTurno()+" ha colocado una ficha incorrectamente.");
                     break;
            default: jLabel1.setText(" ");
                     break;
        }
    }
}
