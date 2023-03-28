package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Input thread number:");
            int threadNumber=in.nextInt();
            int step []=new int[threadNumber];
            int time []=new int[threadNumber];            
            BreakThread [] breakThread = new BreakThread[threadNumber];
            for (int i=0; i<threadNumber;i++){
                System.out.println("Enter step for " +(i+1)+" thread");
                step[i]=in.nextInt();
                System.out.println("Enter execution time(seconds) for " +(i+1)+" thread");
                time[i]=in.nextInt();
            }            
            for (int i=0; i<threadNumber;i++){            
                breakThread [i]=new BreakThread(time[i]);            
                new MainThread(i+1, breakThread[i],step[i]).start();
                new Thread(breakThread[i]).start();
            }
        }

        
    }
}
