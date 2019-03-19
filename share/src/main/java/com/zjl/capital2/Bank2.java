package com.zjl.capital2;

public class Bank2 {
    public static void main(String[] args) {
        TicketWindowsRunable ticketWindows=new TicketWindowsRunable();
        new Thread(ticketWindows,"一号窗口").start();
        new Thread(ticketWindows,"二号窗口").start();
        new Thread(ticketWindows,"三号窗口").start();

    }
}
