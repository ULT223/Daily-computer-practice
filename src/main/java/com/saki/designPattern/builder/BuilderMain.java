package com.saki.designPattern.builder;


import static oracle.jrockit.jfr.tools.ConCatRepository.usage;

public class BuilderMain {
    public static void main(String[] args) {
        if (args.length != 1){
            usage();
            System.exit(0);
        }else if (args[0].equals("text")){
            TextBuilder textBuilder = new TextBuilder();
            Director director = new Director(textBuilder);
            director.construct();
            System.out.println(textBuilder.getResult());
        } else if (args[0].equals("html")){
            HTMLBuilder htmlBuilder = new HTMLBuilder();
            Director director = new Director(htmlBuilder);
            director.construct();
            System.out.println(htmlBuilder.getResult());
        }else
            usage();
    }
}
