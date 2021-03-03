/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doubly_linked_list;

/**
 *
 * @author ِABO-DALAL
 */
public class MainDLList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         // © HarounTaHa https://github.com/HarounTaHa
         // TODO code application logic here
              DLList x =new DLList();
              x.addFirst("haroun");
              x.addFirst("+970597918088");
              x.addFirst(true);
              x.addFirst(65);
              System.out.println(""+x.getFirst());
              System.out.println(""+x.getLast());
              System.out.println("-------------Loop Backword-----------");
              x.loopBackword();
              System.out.println("-------------Loop Backword-----------");
              System.out.println(""+x.Contains("+970597918088"));  //true  
              System.out.println(""+x.Contains("xx"));  //false  
//             ---------------------------------
              x.add(2,"barca");//add element in index 2
//             --------------------------------
            System.out.println("-------------Loop Backword-----------");
              x.loopBackword();
             System.out.println("-------------Loop Backword-----------");

    }
    
}
