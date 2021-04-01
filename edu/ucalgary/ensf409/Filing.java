package edu.ucalgary.ensf409;

public class Filing extends FurnitureItem {
    private char rail;
    private char drawers;
    private char cabinet;
    public Filing(){
        
    }

    public char getRail(){
        return this.rail;
    }
    public char getDrawers(){
        return this.drawers;
    }
    public char getCabinet(){
        return this.cabinet;
    }
    public void setRail(char rail){
         this.rail = rail;
    }
    public void setDrawers(char drawers){
      this.drawers = drawers;
    }
    public void setCabinet(char cabinet){
         this.cabinet = cabinet;
    }
   
}
