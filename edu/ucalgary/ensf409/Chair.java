package edu.ucalgary.ensf409;

public class Chair extends FurnitureItem {
    private char legs;
    private char arms;
    private char seat;
    private char cushion;

    public Chair(){
        
    }
    public char getArms(){
        return this.arms;
    }
    public char getLegs(){
        return this.legs;
    }
    public char getSeat(){
        return this.seat;
    }
    public char getCushion(){
        return this.cushion;
    }
    public void setArms(char arms){
         this.arms = arms;
    }
    public void setLegs(char legs){
        this.legs = legs;
    }
    public void setSeat(char seat){
      this.seat = seat;
    }
    public void setCushion(char cushion){
        this.cushion = cushion;
    }
    
}
