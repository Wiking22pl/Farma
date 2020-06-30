package farms;

public class Farm {


//     rozmiar
    public Double size;

//    liczbę budynków.
    public Integer buildingAmount;

    public Double hectarCost;

    public Double buildingCost;

    public Farm(Double size, Integer buildingAmount, Double hectarCost, Double buildingCost) {
        this.size = size;
        this.buildingAmount = buildingAmount;
        this.hectarCost = hectarCost;
        this.buildingCost = buildingCost;
    }
//    Na początku każdej rozgrywki powinien być dostępny nowy zestaw farm do kupienia.
//    Możesz w tym celu przygotować generator farm lub losować dostępne farmy z przygotowanej wcześniej, większej bazy.
}
