import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Pablo Arriola
 * @author Julio Dieguez
 */
 
public class FactorySet {
    Set setEsperar;

    public FactorySet() {
    }
    public Set getSet(int tipoSet){
       if (tipoSet ==1 ){
           // crear un HashSet
           setEsperar= new HashSet<String>();
       } 
       else if (tipoSet==2){
           // crear un TreeSet
           setEsperar = new TreeSet<String>();
       }
       else{
           //se crea un LinketSet
           setEsperar = new LinkedHashSet<String>();
        
       }
       //retorna el set solicitado
       return setEsperar;
    }
}
