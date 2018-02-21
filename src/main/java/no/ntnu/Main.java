/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu;

/**
 *
 * @author olavt
 */
public class Main {
    public static void main(String args[]) {
        // Create a shared Message Queue
        WaitingChairs waitingChairs = new WaitingChairs();
        
        // Create a producer and a consumer
        TeachingAssistant t = new TeachingAssistant();
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        Student s4 = new Student();
       
        // Run the produce+consumer processes
        t.start();
        s1.start();
        s2.start();
        s1.start();
        s1.start();
        
        // Wait for producer and consumer to finish
        try {
            t.join();
            s1.join();
            s2.join();
            s3.join();
            s4.join();
        } catch (InterruptedException ex) {
            System.out.println("Parent process interrupted"); 
        }
        
    }
}
