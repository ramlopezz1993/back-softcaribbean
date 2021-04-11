package co.com.softcaribbean.pruebasoftcaribbean.model;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Arbol {
    //iniciamos desde la raiz
    public Nodo raiz;
    public Arbol(){
        this.raiz=null;
    }

    public void insertar(Cliente cliente) {
        var nodo = new Nodo(cliente);
        nodo.cliente = cliente;
        if(raiz==null){
            // no tenemos raiz entonces la colocamos
            raiz=nodo;
        } else {
            //si tenemos raiz
            //creamos un nodo aux para saber donde colocarlo
            var nodoAux = raiz;
            while(nodoAux!=null){
                nodo.padre = nodoAux;
                if (nodo.indice >= nodoAux.indice) {
                    nodoAux=nodoAux.derecha;
                } else {
                    nodoAux=nodoAux.izquierda;
                }
            }
            if(nodo.indice<nodo.padre.indice) {
                nodo.padre.izquierda=nodo;
            } else {
                nodo.padre.derecha=nodo;
            }
        }
    }

    public void recorrerArbol(Nodo nodo){
        if(nodo!=null) {
            recorrerArbol(nodo.izquierda);
            log.info("indice "+nodo.cliente.getCusCdtelefono()+" izquierda "+nodo.izquierda + " derecha "+nodo.derecha);
            recorrerArbol(nodo.derecha);
        }
    }

    public void actualizarNodo(Cliente cliente, Nodo nodo) {
        if (nodo!=null) {
            actualizarNodo(cliente,nodo.izquierda);
            log.info("indice "+nodo.indice+ " izquierda "+nodo.izquierda + " derecha "+nodo.derecha);
            if (nodo.cliente.getCusNmcliente().equals(cliente.getCusNmcliente())) {
                nodo.cliente = cliente;
            }
            actualizarNodo(cliente,nodo.derecha);
        }
    }

    //clase privada para crear los nodos u hojas del arbol
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public class Nodo {
        Nodo padre;
        Nodo izquierda;
        Nodo derecha;
        int indice;
        Cliente cliente;

        public Nodo(Cliente cliente) {
            this.indice=cliente.getCusNmcliente();
            this.padre=null;
            this.derecha=null;
            this.izquierda=null;
            this.cliente=null;
        }
    }
}
