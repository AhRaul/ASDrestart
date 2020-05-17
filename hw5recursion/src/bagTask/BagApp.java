package bagTask;

public class BagApp {

    public static void main(String[] args) {

        RecursionBag bag = new RecursionBag(30, 5);

        ObjectForBag apple = new ObjectForBag("Яблоко", 5, 15);
        ObjectForBag table = new ObjectForBag("Стол", 500, 5000);
        ObjectForBag album = new ObjectForBag("Альбом", 10, 50);
        ObjectForBag notebook = new ObjectForBag("Блокнот", 10, 30);
        ObjectForBag phone = new ObjectForBag("Мобильник", 15, 15000);

        bag.prepareObject(apple);
        bag.prepareObject(table);
        bag.prepareObject(album);
        bag.prepareObject(notebook);
        bag.prepareObject(phone);

        bag.startMaxPricePacking();
        bag.display();
    }
}
