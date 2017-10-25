import java.util.ArrayList;
import java.util.List;

public class PaintWizrd {
    private int areaToBePainted;
    private List<Paint> paints = new ArrayList<>();

    public PaintWizrd(int areaToBePainted){
        this.areaToBePainted = areaToBePainted;
    }

    public void doCompleteCalculation(){
        for(Paint p : paints){
            calculatePaintNeeded(p);
            calculateCansNeededAndWaste(p);
            calculateCost(p);
        }
        calculateCheapestPaint(paints.get(0), paints.get(1), paints.get(2));
        calculateLeastWaste(paints.get(0), paints.get(1), paints.get(2));
    }

    public void calculatePaintNeeded(Paint p){
        p.setLitresNeeded(areaToBePainted / p.getAreaPerLitre());
    }

    public void calculateCansNeededAndWaste(Paint p){
        if (p.getLitresNeeded() <= p.getSizeInLitres()){
            p.setCansNeeded(1);
            p.setWastePaint(p.getSizeInLitres() - p.getLitresNeeded());
        }
        else{
            p.setCansNeeded((int) Math.ceil(p.getLitresNeeded() / p.getSizeInLitres()));
            p.setWastePaint(p.getLitresNeeded() % p.getSizeInLitres());
        }
    }

    public void calculateCost(Paint p){
        p.setCostOfArea(p.getCost() * p.getCansNeeded());
    }

    public void addToList(Paint p){
        paints.add(p);
    }

    public void calculateCheapestPaint(Paint p1, Paint p2, Paint p3){

        if (p1.getCostOfArea() < p2.getCostOfArea() && p1.getCostOfArea() < p3.getCostOfArea()){
            System.out.println(p1.getName() + "is the cheapest paint, at £" + p1.getCostOfArea());
        }
        else if (p2.getCostOfArea() < p1.getCostOfArea() && p2.getCostOfArea() < p3.getCostOfArea()){
            System.out.println(p2.getName() + "is the cheapest paint, at £" + p2.getCostOfArea());
        }
        else {
            System.out.println(p3.getName() + "is the cheapest paint, at £" + p3.getCostOfArea());
        }
    }

    public void calculateLeastWaste(Paint p1, Paint p2, Paint p3){
        if (p1.getWastePaint() < p2.getWastePaint() && p1.getWastePaint() < p3.getWastePaint()){
            System.out.println(p1.getName() + " has the least waste, at " + p1.getWastePaint() + "litres.");
        }
        else if (p2.getWastePaint() < p1.getWastePaint() && p2.getWastePaint() < p3.getWastePaint()){
            System.out.println(p2.getName() + " has the least waste, at " + p2.getWastePaint() + "litres.");
        }
        else {
            System.out.println(p3.getName() + " has the least waste, at " + p3.getWastePaint() + "litres.");
        }
    }

}


class Paint{
    private double cost;
    private double areaPerLitre;
    private double sizeInLitres;
    private String name;

    private int cansNeeded;
    private double litresNeeded;
    private double wastePaint;

    private double costOfArea;


    public Paint(double cost, double areaPerLitre, double sizeInLitres, String name){
        this.cost = cost;
        this.areaPerLitre = areaPerLitre;
        this.sizeInLitres = sizeInLitres;
        this.name = name;
    }

    public double getCost(){
        return cost;
    }

    public double getAreaPerLitre(){
        return areaPerLitre;
    }

    public double getSizeInLitres(){
        return sizeInLitres;
    }

    public String getName(){
        return name;
    }

    public int getCansNeeded(){
        return cansNeeded;
    }

    public double getLitresNeeded(){
        return litresNeeded;
    }

    public double getWastePaint(){
        return wastePaint;
    }

    public void setCansNeeded(int cansNeeded){
        this.cansNeeded = cansNeeded;
    }

    public void setLitresNeeded(double litresNeeded){
        this.litresNeeded = litresNeeded;
    }

    public void setWastePaint(double wastePaint){
        this.wastePaint = wastePaint;
    }

    public void setCostOfArea(double cost){
        this.costOfArea = cost;
    }

    public double getCostOfArea(){
        return costOfArea;
    }
}
