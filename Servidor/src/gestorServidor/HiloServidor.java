package gestorServidor;

import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class HiloServidor extends Thread{
    
    private int puerto;
    private JFrame ventana;
    
    public HiloServidor(JFrame ventana, int puerto) {
        this.puerto = puerto;
        this.ventana = ventana;
    }
    
    public void run(){
        ServerSocket ss=null;
        try{
            ss=new ServerSocket(puerto);
            while (true){
                Socket s=ss.accept();
                HiloGestorConexiones.getInstance().conectaNuevo(new HiloConexiones(s));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(ventana,"Error al abrir el puerto, puede estar en uso.");
        }
        try{
            ss.close();
        }catch(Exception e){
        }
    }
    
}
