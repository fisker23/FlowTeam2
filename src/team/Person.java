/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team;

/**
 *
 * @author Andreas Fisker
 */
public class Person {
    private String name;
    private int administrator, analyst, creative, finisher;
    
    public Person(String name, int admin, int analyst, int creative, int finisher){
        this.name = name;
        this.administrator = admin;
        this.analyst = analyst;
        this.creative = creative;
        this.finisher = finisher;
    }
    // Skal vi have en "fromString" constructor der kan lave en string fra en .txt fil om til en personklasse?
    // Har lavet den idag, søndag, men har ikke testet den
    public Person(String fromTextFile){
        //  finder komma seperatorene i String inputtet og bruger dem til at lave object af personen
        int sepName = fromTextFile.indexOf(",");
        int sepAdmin = fromTextFile.indexOf(",", sepName);
        int sepAnalyst = fromTextFile.indexOf(",",sepAdmin);
        int sepCreative = fromTextFile.indexOf(",", sepAnalyst);
        this.name = fromTextFile.substring(0, sepName);
        this.administrator = Integer.parseInt(fromTextFile.substring((sepName + 2), sepAdmin));
        this.analyst = Integer.parseInt(fromTextFile.substring((sepAdmin + 2), sepAnalyst));
        this.creative = Integer.parseInt(fromTextFile.substring((sepAnalyst + 2),sepCreative));
        this.finisher = Integer.parseInt(fromTextFile.substring((sepCreative + 2)));
    }
    
    @Override
    public String toString(){
        String str;
        str = name + ", " + administrator + ", " + analyst + ", " + creative + ", " + finisher;
        return str;
    }

    public String getName() {
        return name;
    }

    public int getAdministrator() {
        return administrator;
    }

    public int getAnalyst() {
        return analyst;
    }

    public int getCreative() {
        return creative;
    }

    public int getFinisher() {
        return finisher;
    }
    
}
