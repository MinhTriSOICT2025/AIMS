public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private int qtyOrdered = 0;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    public void addDigitalVideoDisc(DigitalVideoDisc dvd){
        if(qtyOrdered == MAX_NUMBERS_ORDERED){
            System.out.println("The cart is almost full");
            return;
        }
        else{
            itemsOrdered[qtyOrdered] = dvd;
            qtyOrdered++;
            System.out.println("Added DVD successfully");
            return;
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc dvd){
        int indx = -1;
        for(int i = 0 ; i < qtyOrdered ; i++){
            if(itemsOrdered[i].equals(dvd)){
                indx = i;
                break;
            }
        }
        if(indx == -1){
            System.out.println("No disc found!");
            return;
        }

        for(int i = indx ; i < qtyOrdered - 1; i++){
            itemsOrdered[i] = itemsOrdered[i + 1];
        }
        qtyOrdered--;
        itemsOrdered[qtyOrdered] = null;
        System.out.println("Remove DVD successfully!");
        return;
    }

    public float totalCost(){
        float total = 0;
        for(int i = 0 ; i < qtyOrdered ; i++){
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
}
