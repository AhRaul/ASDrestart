package bagTask;

public class RecursionBag {

    private int weightLimit = 0;

    private ObjectForBag[] totalObjects;
    private int totalObjectsCounter = 0;

    private ObjectForBag[] tempInABag;
    private int tempInABagCounter = 0;
    private int tempWeightResult = 0;

    private ObjectForBag[] maxPriceObjectsInABag;

    public RecursionBag(int weightLimit, int maxQuantityObjects) {
        this.weightLimit = weightLimit;
        this.totalObjects =  new ObjectForBag[maxQuantityObjects];
        this.tempInABag =  new ObjectForBag[maxQuantityObjects];
    }

    public int getWeightLimit() {
        return weightLimit;
    }

    public int getWeightRezult() {
        return tempWeightResult;
    }

    public int getPriceRezult(ObjectForBag[] checkBag) {
        int price = 0;
        for(int i = 0; i < checkBag.length; i++) {
            if(checkBag[i] != null) {
                price = price + checkBag[i].getPrice();
            } else {
                return price;
            }
        }
        return price;
    }

    public void prepareObject(ObjectForBag totalObject) {
        this.totalObjects[totalObjectsCounter] = totalObject;
        totalObjectsCounter++;
    }

    //попытка добавить обьекты в временную сумку
    public void tryPushObjectsInATempBag() {
        resetTempBag();
        for(int i = 0; i < totalObjectsCounter; i++) {
            if (tempWeightResult + totalObjects[i].getWeight() <= weightLimit) {
                this.tempInABag[this.tempInABagCounter++] = totalObjects[i];
                tempWeightResult = tempWeightResult + totalObjects[i].getWeight();
            }
        }
    }

    //опустошение сумки
    public void resetTempBag() {
        tempWeightResult = 0;
        tempInABagCounter = 0;
    }

    /**
     * getAnagramm пробегается по всем возможным анограммам.
     * @param newSize изначально задается максимальный размер массива
     */
    public void getAnagramm(int newSize) {
        if(newSize == 1)
            return;
        for (int i = 0; i<newSize; i++) {
            getAnagramm(newSize-1);
            rotate(newSize);
            checkAndFillMaxPriceBagg();
        }
    }

    /**
     * rotate циклический сдвиг на одну позицию влево от каждой буквы
     * @param newSize позиция, в которой будет находиться первый элемент массива. Сдвигая остальные элементы массива влево.
     */
    public void rotate(int newSize) {
        int i ;
        int pos = totalObjectsCounter - newSize;
        ObjectForBag temp = totalObjects[pos];
        for (i = pos +1; i < totalObjectsCounter; i++){
            totalObjects[i-1] = totalObjects[i];
        }
        totalObjects[i-1] = temp;
        tryPushObjectsInATempBag();
    }

    /**
     * заполнение самого дорогого массива
     */
    public void checkAndFillMaxPriceBagg() {
        if (getPriceRezult(maxPriceObjectsInABag) < getPriceRezult(tempInABag)) {
            maxPriceObjectsInABag = new ObjectForBag[tempInABagCounter];
            tempWeightResult = 0;
            for (int i = 0; i < tempInABagCounter; i++) {
                maxPriceObjectsInABag[i] = tempInABag[i];
            }
        }
    }

    public ObjectForBag[] startMaxPricePacking() {
        tryPushObjectsInATempBag();
        maxPriceObjectsInABag = new ObjectForBag[tempInABagCounter];
        for (int i = 0; i < tempInABagCounter; i++) {
            maxPriceObjectsInABag[i] = tempInABag[i];
        }
        getAnagramm(totalObjectsCounter);
        return maxPriceObjectsInABag;
    }

    public void display() {
        for(int i = 0; i< maxPriceObjectsInABag.length; i++) {
            System.out.println(maxPriceObjectsInABag[i]);
        }
    }

}
