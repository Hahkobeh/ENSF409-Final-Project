package edu.ucalgary.ensf409;

public class Lamp extends FurnitureItem{
    private char base;
    private char bulb;
    
    public Lamp(){
        
    }
    public char getBase(){
        return this.base;
    }
    public char getBulb(){
        return this.bulb;
    }
    public void setBase(char base){
         this.base = base;
    }
    public void setBulb(char bulb){
         this.bulb = bulb;
    }
}
