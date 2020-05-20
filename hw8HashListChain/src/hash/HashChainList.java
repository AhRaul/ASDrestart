package hash;

import linkedList.Link;
import linkedList.LinkedList;

public class HashChainList {
    public static final int ABC_SIZE = 33;
    private LinkedList[] chainsArray = new LinkedList[ABC_SIZE];
    private String abcRus = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

    public void insert(String word) {
        if(chainsArray[prepareHashIndex(word)] == null) {
            chainsArray[prepareHashIndex(word)] = new LinkedList();
        }
        chainsArray[prepareHashIndex(word)].insert(word);
    }

    /**
     * Возвращает индекс хеш масссива, подходящий первой букве проверяемого слова
     * @param word проверяемое слово
     * @return индекс хещ массива
     */
    public int prepareHashIndex(String word) {
        return abcRus.indexOf(""+(word.toUpperCase()).charAt(0));
    }

    public Link find(String word) {
        return chainsArray[prepareHashIndex(word)].find(word);
    }

    public Link delete(String word) {
        return chainsArray[prepareHashIndex(word)].delete(word);
    }

    public void display() {
        for(int i = 0; i < ABC_SIZE; i++) {
            if(chainsArray[i] != null) {
                chainsArray[i].display();
            }
        }
    }
}
