package gestorCliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

import principal.VentanaCliente;

//para crear el hilo
public class HiloCliente extends Thread{

    private int puerto;
    private String ip;
    private Socket s;
    private boolean conectado;
    VentanaCliente ventana;
    private String usuario;
    
    public HiloCliente(int puerto, String ip, String usuario, VentanaCliente ventana) {
        this.puerto=puerto;
        this.ip=ip;
        this.usuario=usuario;
        this.ventana=ventana;
    }
    
    public void run(){
        try{
            s=new Socket(ip, puerto);
            DataInputStream dis=new DataInputStream(s.getInputStream());
            enviarTrama(1, usuario);
            conectado=true;
            while(conectado){
                int nCodigo =dis.readInt();
                String sTrama=dis.readUTF();
                switch(nCodigo){
                    case 1:
                        ventana.nuevaPersona(sTrama);
                        break;
                    case 2:
                        ventana.mensajeRecibido(sTrama);
                        break;
                    case 3:
                        try{
                            int nPos = Integer.parseInt(sTrama);
                            ventana.borrarPersona(nPos);
                        }catch(Exception e2){
                        }
                        break;
                }
            }
            JOptionPane.showMessageDialog(ventana, "Se ha conectado");
        }catch(Exception e){
            JOptionPane.showMessageDialog(ventana, "Error al conectar");
        }
    }
    
    public void enviarMensaje(String sMensaje){
        enviarTrama(2, sMensaje);
    }
    
    public void enviarTrama(int nCodigo, String sTrama){
        try{
            DataOutputStream dos=new DataOutputStream(s.getOutputStream());
            dos.writeInt(nCodigo);
            dos.writeUTF(sTrama);
        }catch(Exception e){
            JOptionPane.showMessageDialog(ventana, "No se envio el mensaje");
        }
        
    }

}
