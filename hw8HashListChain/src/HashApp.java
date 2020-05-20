import hash.HashChainList;

public class HashApp {
    public static void main(String[] args) {
        HashChainList hashChainList = new HashChainList();
        hashChainList.insert("привет");
        hashChainList.insert("амлет");
        hashChainList.insert("Алёша");
        hashChainList.insert("блокчейн");
        hashChainList.insert("интеллект");
        hashChainList.display();
        System.out.println("______________________________");
        if(hashChainList.find("амлет") != null) {
            System.out.println("амлет там");
        } else {
            System.out.println("нету");
        }
        hashChainList.delete("амлет");
        System.out.println("______________________________");
        hashChainList.display();
        System.out.println("______________________________");
        if(hashChainList.find("амлет") != null) {
            System.out.println("амлет там");
        } else {
            System.out.println("нету амлет");
        }
    }
}
