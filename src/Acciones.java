/**
 *
 * @author Pablo Arriola
 * @author Julio Dieguez
 */
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.Collections;



public class Acciones {
    //tipo de set
    public int tipoSet;
    
    //Conjuntos de desarrolladores
    public Set<String> setDesarrolladoresJava, setDesarrolladoresWeb,setDesarrolladoresMoviles;
   
    //Factory para patron de diseño
    public FactorySet factory = new FactorySet();
    
    //Tipos de desarrolladores
    public Set<String> DesarrolladoresTres; 
    //desarrolladores de web y movil 
    public Set<String> WebMovil; 
    //java pero no web
    public Set<String> javaNoWeb; 
    //web y celular
    public Set<String> WebCelular; 
    
    // Constructor
    
    public Acciones()
    {
        //Hace posible los ciclos infinitos
        boolean infinito = false; 
     
        tipoSet = Integer.parseInt(JOptionPane.showInputDialog("1.HashSet  2.TreeSet  3.LinkedHashSet"));
        switch (tipoSet) {
            case 1:
            case 2:
            case 3:
            {
                setDesarrolladoresJava = factory.getSet(tipoSet);
                setDesarrolladoresWeb = factory.getSet(tipoSet);
                setDesarrolladoresMoviles = factory.getSet(tipoSet);
                break;
            }
            default:
            {
                //Ingreso incorrecto
                JOptionPane.showMessageDialog(null, "El numero ingresado es invalido");
                System.exit(0);
            }
        }
        
            //Infinito
            while(infinito == false)
            {
                String nombre = JOptionPane.showInputDialog(" Ingrese el nombre del desarrollador. \n(Si desea dejar de ingresar escriba 0) ");
                
                
                
                // si desea dejar de ingresar desarrolladores el ciclo infinito se termina
                if (nombre.equals("0"))
                {
                    infinito = true;
                }
                else 
                {
                    int clase = Integer.parseInt(JOptionPane.showInputDialog(
                        "       Elija una de estas opciones: \n           1.Desarrollador Java \n            2.Desarrollador web \n           3.Desarrollador para celulares"));
                    
                    switch (clase)
                    {
                        case 1:
                        {
                            setDesarrolladoresJava.add(nombre);
                            break;
                        }
                        case 2:
                        {
                            setDesarrolladoresWeb.add(nombre);
                            break;
                        }
                        case 3: 
                        {
                            setDesarrolladoresMoviles.add(nombre);
                            break;
                        }
                    }
            }
           
        }
    
            
            System.out.println("D. Java: " + setDesarrolladoresJava);
            System.out.println("D. Web: " + setDesarrolladoresWeb);
            System.out.println("D. Celulares: " + setDesarrolladoresMoviles);
            System.out.println("");
            
            
            
    //Parte 3
      //Compara los sets de web y celular
      WebCelular = buscarIntersecciones(setDesarrolladoresWeb,setDesarrolladoresMoviles);
      System.out.println("Los desarrolladores de web y moviles son:");
        System.out.println(WebCelular);
        
         System.out.println("D. Java: " + setDesarrolladoresJava);
            System.out.println("D. Web: " + setDesarrolladoresWeb);
            System.out.println("D. Celulares: " + setDesarrolladoresMoviles);
            System.out.println("");      
            
      DesarrolladoresTres = buscarIntersecciones(setDesarrolladoresJava,WebCelular);
        System.out.println("Los desarrolladores de Java, Web y Celulares son:");
        System.out.println(DesarrolladoresTres);
  
      //Busca desarrolladores java, pero que no desarrollen web
      javaNoWeb = buscarDiferencias(setDesarrolladoresJava,setDesarrolladoresWeb);
      System.out.println("Los desarrolladores que programan en java pero no web son:");
        System.out.println(javaNoWeb);
      
            System.out.println("D. Java: " + setDesarrolladoresJava);
            System.out.println("D. Web: " + setDesarrolladoresWeb);
            System.out.println("D. Celulares: " + setDesarrolladoresMoviles);
            System.out.println("");
  
      //Crea la union de desarrolladores web y desarrolladores moviles
      WebMovil = crearUnion(setDesarrolladoresWeb,setDesarrolladoresMoviles);
        System.out.println("La union de desarrolladores web y desarrolladores moviles es: ");
        System.out.println(WebMovil);
      
       //Parte 5
        boolean sub = esSubconjunto(setDesarrolladoresWeb,setDesarrolladoresJava);
        System.out.println("Los desarrolladores java, son un subconjunto de los desarrolladores web?");
        System.out.println(sub);

        //Que conjunto tiene mas desarrolladores
        
        int cant1,cant2,cant3,mayor; //Almacenar la cantidad de desarrolladores
        cant1 = setDesarrolladoresJava.size();
        cant2 = setDesarrolladoresWeb.size();
        cant3 = setDesarrolladoresMoviles.size();
        
        mayor = 0; //Quien tiene mas desarrolladores al final
  
        //Si la cantidad1 es mayor que la cantidad2
        if (cant1 > cant2)
        {
            if (cant1 > cant3)
            {
                System.out.println("Hay mas desarrolladores en el conjunto de desarrolladores Java");
                mayor = 1; //mas desarrolladores java
                System.out.println("Los desarrolladores java son: ");
                System.out.println(setDesarrolladoresJava);
                //Ordenar alfabeticamente
                ordenarAlfabeticamente(setDesarrolladoresJava);
            }
         
            else
            {
                System.out.println("Hay mas desarrolladores en el conjunto de desarrolladores para celulares");
                mayor = 3; //hay mas desarrolladores para celulares
                System.out.println("Los desarrolladores para celulares son: ");
                System.out.println(setDesarrolladoresMoviles);
               ordenarAlfabeticamente(setDesarrolladoresMoviles);
            }
        }
       
        else
        {
            
            if (cant2 > cant3)
            {
                
                System.out.println("Hay mas desarrolladores en el conjunto de desarrolladores Web");
                
                mayor = 2;  //Hay mas desarrolladores web
                
                 //Se imprimen los desarrolladores Web
                System.out.println("Los desarrolladores web son: ");
                System.out.println(setDesarrolladoresWeb);
            
                //Ordenar acendentes
                ordenarAlfabeticamente(setDesarrolladoresWeb);
            }
            else
            {
                System.out.println("Hay mas desarrolladores en el conjunto de desarrolladores moviles");
                mayor = 3;  //Hay mas desarrolladores para celulares
                System.out.println("Los desarrolladores moviles son: ");
                System.out.println(setDesarrolladoresMoviles);
                ordenarAlfabeticamente(setDesarrolladoresMoviles);
            }
        }  
   }
 
    private Set buscarIntersecciones(Set set1, Set set2)
    {
      
        Set<String> interseccion = factory.getSet(tipoSet);
        
      
        Iterator iterator = set1.iterator();
        while(iterator.hasNext())
        {
            interseccion.add((String) iterator.next());
        }
        
        
        interseccion.retainAll(set2);
        return interseccion;
    }
    private Set buscarDiferencias(Set set1, Set set2)
    {
        Set<String> diferencia = factory.getSet(tipoSet);
        
        Iterator iterator = set1.iterator();
        while(iterator.hasNext())
        {
            diferencia.add((String) iterator.next());
        }
        diferencia.removeAll(set2);
        return diferencia;
        
        
         
    }
    private Set crearUnion(Set set1,Set set2){
     Set<String> union = factory.getSet(tipoSet);
     Iterator iterator = set1.iterator();
     while (iterator.hasNext())
     {
         union.add((String) iterator.next());
     }
     
     union.addAll(set2);
     return union;
    }

    private boolean esSubconjunto(Set set1, Set set2)
    {
        boolean subconjunto;
        subconjunto = set1.containsAll(set2);
        
        return subconjunto;
    }
    //Ordernar en orden ascendente (alfabeticamente) 
    private void ordenarAlfabeticamente(Set set)
    {
        ArrayList<String> listaAOrdenar = new ArrayList<>();
        
        
        Set<String> union = factory.getSet(tipoSet);
     Iterator iterator = set.iterator();
     while (iterator.hasNext())
     {
         listaAOrdenar.add((String) iterator.next());
     }
     
     Collections.sort(listaAOrdenar);
        System.out.println(listaAOrdenar);
    }
}
    
    

