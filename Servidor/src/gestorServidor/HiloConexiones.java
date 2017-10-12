package gestorServidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class HiloConexiones extends Thread{
    
    @SuppressWarnings("unused")
	private Socket s;
    private DataInputStream dis;
    private DataOutputStream dos;
    private String usuario;
    
    public HiloConexiones(Socket s) {
        try{
            this.s=s;
            dis=new DataInputStream(s.getInputStream());
            dos=new DataOutputStream(s.getOutputStream());
            start();
        }catch(Exception e){
        }
    }
    
    public String getUsuario(){
        return usuario;
    }
    
    public void run(){
        while (true){
            try{
                int nCodigo=dis.readInt();
                String sTrama=dis.readUTF();
                switch(nCodigo){
                    case 1:
                        usuario=sTrama;
                        HiloGestorConexiones.getInstance().enviarTrama(nCodigo, sTrama);
                        break;
                    case 2:
                        sTrama="<" + usuario + "> - " + sTrama;
                        HiloGestorConexiones.getInstance().enviarTrama(nCodigo, sTrama);
                        break;
                    case 3:
                        HiloGestorConexiones.getInstance().desconecta(this);
                        break;
                }
                
            }catch(Exception e){
            }
            
        }
    }
    
    public void enviarTrama(int nCodigo, String sTrama){
        try{
           dos.writeInt(nCodigo);
           dos.writeUTF(sTrama);
        }catch(Exception e){
        }
    }
}