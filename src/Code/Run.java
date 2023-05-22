package Code;

import java.io.IOException;
import java.util.ArrayList;

public class Run {
    public static ArrayList<Double> Load = new ArrayList();
    public static ArrayList<Double> Migration_cost = new ArrayList();
    public static ArrayList<Double> Resource_availability = new ArrayList();
    public static ArrayList<Double> Energy_consumption = new ArrayList();
    public static int PM = 10, VM = 50;         //initialize Physical & virtual machine
    public static int task = Code.GUI.task, max_itr = Code.GUI.iteration;     //input from GUI
    public static double th = 0.04;              //threshold
    public static ArrayList<Integer> VM_Migration = new ArrayList();
    public static ArrayList<Double> P = new ArrayList();    //Processing entities
    public static ArrayList<Double> C = new ArrayList();    //CPU
    public static ArrayList<Double> B = new ArrayList();    //Bandwidth
    public static ArrayList<Double> M = new ArrayList();    //Memory
    public static ArrayList<Double> I = new ArrayList();    //MIPS
    public static void main(String[] args) throws IOException {
        Load = new ArrayList();
        Migration_cost = new ArrayList();
        Resource_availability = new ArrayList();
        Energy_consumption = new ArrayList();
        
        //initializing the VM_parameters
        P = new ArrayList(); C = new ArrayList(); B = new ArrayList(); M = new ArrayList(); I = new ArrayList();
        System.out.println("\nInitializing VM..");
        initial_VM_migration();
        System.out.println("\nGenerating VM parameters..");
        generate_VM_parameters();
        System.out.println("\nAssign Task..");
        System.out.println("\nCalculating Load & optimizing...");
        
        ChicWhale.run1.callmain();
        WOA.run.callmain();
        Firefly.run.callmain();
        ABC_BA.run.callmain();
        ICWA.run.callmain();
        
        System.out.println("\nDone.!");
        }

    public static void initial_VM_migration() {
        int i, j;
        VM_Migration = new ArrayList(); //VM_Mig size 1xVM (1x50)
        int n = 1, m = VM / PM;        //VM in each PM 
        for( i = 0; i < PM; i++) {      //no. of PM in mig.
            if( n < PM ) {             
                int it = 0;
                while( it < m) {
                    VM_Migration.add(n);        //VM in which PM is added to VM_migration
                    it++;
                }
                n++;
            }
            else {                     
                int it = VM_Migration.size() - 1;
                while( it < VM - 1) {
                    VM_Migration.add(n);
                    it++;
                }
            }
        }
    }

    public static void generate_VM_parameters() {
        //size of paramters = no.of VM
        for( int i = 0; i < VM; i++) {
            P.add(Math.random()*10+1);
            C.add(Math.random()*10+1);
            B.add(Math.random()*10+1);
            M.add(Math.random()*10+1);
            I.add(Math.random()*10+1);
        }
    }
}
