package com.saki.designPattern.singleton.extend;

public class TicketMaker {
    private static TicketMaker ticketMaker = new TicketMaker();

    private int ticket = 1000;

    private TicketMaker() {
        System.out.println("生成TicketMaker实例");
    }

    public static TicketMaker getInstance() {
        return ticketMaker;
    }

    public int getNextTicketNumber() {
        return ticket++;
    }
}
