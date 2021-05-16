package com.company;

import java.awt.*;
import java.io.*;
import java.util.Scanner;
import java.awt.event.KeyEvent;

import com.fazecast.jSerialComm.SerialPort;

public class Main {

    public static void main(String[] args) throws Exception {

        SerialPort[] ports = SerialPort.getCommPorts();
        int x;

        Scanner s= new Scanner(System.in);

        System.out.println("Poczatek");
        System.out.println("porty: " + ports.length);
        for(SerialPort p : ports){
            System.out.println(p.getSystemPortName());
        }


        System.out.println("Podaj numer portu");
        x=Integer.parseInt(s.nextLine());


       RunConnection(x);

    }

    static void RunConnection(int x){
        SerialPort comPort = SerialPort.getCommPorts()[x-1];
        comPort.openPort();
        System.out.println("Port "+x+" otwarto");
        try {
            while (true)
            {
                while (comPort.bytesAvailable() <=0)
                    Thread.sleep(20);

                byte[] readBuffer = new byte[comPort.bytesAvailable()];


                int numRead = comPort.readBytes(readBuffer, readBuffer.length);
                String mess = new String(readBuffer,"UTF-8");
                System.out.println("Read " + numRead + " bytes.");
                System.out.println(("Wiadomość: "+mess));
                RunCommand(mess);

            }
        } catch (Exception e) { e.printStackTrace(); }
        comPort.closePort();


    }

    static void RunCommand(String command){
        if(command!="ERR")
            if(command.charAt(0)=='u' || command.charAt(0)=='d'){
                System.out.println(command);

                Robot r=null;
                try {
                    r = new Robot();
                } catch (AWTException e) {
                    e.printStackTrace();
                }

                if(command.contains("d10")){
                    r.keyPress(KeyEvent.VK_L);
                    System.out.println("L DOWN");
                }
                else if(command.contains("u10")){
                    r.keyRelease(KeyEvent.VK_L);
                    System.out.println("L UP");
                }


                else if(command.contains("d1")){
                    r.keyPress(KeyEvent.VK_W);
                    System.out.println("W DOWN");
                }
                else if(command.contains("u1")){
                    r.keyRelease(KeyEvent.VK_W);
                    System.out.println("W UP");
                }

                else if(command.contains("d4")){
                    r.keyPress(KeyEvent.VK_S);
                    System.out.println("S DOWN");
                }
                else if(command.contains("u4")){
                    r.keyRelease(KeyEvent.VK_S);
                    System.out.println("S UP");
                }

                else if(command.contains("d2")){
                    r.keyPress(KeyEvent.VK_A);
                    System.out.println("A DOWN");
                }
                else if(command.contains("u2")){
                    r.keyRelease(KeyEvent.VK_A);
                    System.out.println("A UP");
                }

                else if(command.contains("d3")){
                    r.keyPress(KeyEvent.VK_D);
                    System.out.println("D DOWN");
                }
                else if(command.contains("u3")){
                    r.keyRelease(KeyEvent.VK_D);
                    System.out.println("D UP");
                }

                else if(command.contains("d5")){
                    r.keyPress(KeyEvent.VK_I);
                    System.out.println("I DOWN");
                }
                else if(command.contains("u5")){
                    r.keyRelease(KeyEvent.VK_I);
                    System.out.println("I UP");
                }

                else if(command.contains("d6")){
                    r.keyPress(KeyEvent.VK_O);
                    System.out.println("O DOWN");
                }
                else if(command.contains("u6")){
                    r.keyRelease(KeyEvent.VK_O);
                    System.out.println("O UP");
                }

                else if(command.contains("d7")){
                    r.keyPress(KeyEvent.VK_P);
                    System.out.println("P DOWN");
                }
                else if(command.contains("u7")){
                    r.keyRelease(KeyEvent.VK_P);
                    System.out.println("P UP");
                }

                else if(command.contains("d8")){
                    r.keyPress(KeyEvent.VK_J);
                    System.out.println("J DOWN");
                }
                else if(command.contains("u8")){
                    r.keyRelease(KeyEvent.VK_J);
                    System.out.println("J UP");
                }

                else if(command.contains("d9")){
                    r.keyPress(KeyEvent.VK_K);
                    System.out.println("K DOWN");
                }
                else if(command.contains("u9")){
                    r.keyRelease(KeyEvent.VK_K);
                    System.out.println("K UP");
                }

            }
    }

}
