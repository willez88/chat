package gestorServidor;

import java.util.ArrayList;

public class HiloGestorConexiones {
    
    private static HiloGestorConexiones singleton=new HiloGestorConexiones();
    public  static HiloGestorConexiones getInstance(){
        return singleton;
    }
    
    private ArrayList<HiloConexiones> conexiones = new ArrayList<HiloConexiones>();
    
    public void enviarTrama(int nCodigo, String sTrama){
        for (HiloConexiones ms:conexiones){
            ms.enviarTrama(nCodigo, sTrama);
        }
    }
    
    public void conectaNuevo(HiloConexiones nuevo){
        for (HiloConexiones ms:conexiones){
            nuevo.enviarTrama(1, ms.getUsuario());
        }
        conexiones.add(nuevo);
    }
    
    public void desconecta(HiloConexiones eliminar){
        int nPos=-1;
        for (int n=0;n<conexiones.size();n++){
            if (conexiones.get(n)==eliminar){
                nPos=n;
            }
        }
        if (nPos!=-1){
            for (int n=0;n<conexiones.size();n++){
                if (n!=nPos){
                    conexiones.get(n).enviarTrama(3, ""+nPos);
                }
            }
            conexiones.remove(nPos);
        }
    }    
    
}