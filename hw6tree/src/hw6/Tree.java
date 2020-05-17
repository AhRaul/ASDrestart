package hw6;

public class Tree {
    private Node root;
    public static final int MAX_LEWEL = 4;
    private boolean levelIsLimit = false;
    private int levelCounter = 0;
    private boolean isBalanced = true;

    public Node find(int value) {
        Node current = root;
        while (current.value != value) {
            if(value < current.value) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }

            if (current == null) {
                return null;
            }
        }
        return current;
    }

    private boolean isMoreThanMaxLevel(Node node) {
        if(node.level > MAX_LEWEL) {
            return false;
        }
        return true;
    }

    public void insert (int value) {
        if(levelIsLimit) {
            return;
        }
        Node node = new Node();
        node.value = value;
        if (root == null) {
            node.level = 0;
            root = node;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if(parent.level >= MAX_LEWEL) {
                    System.out.println("Level " + MAX_LEWEL + " is limit. Insert method off");
                    levelIsLimit = true;
                    return;
                }
                if (value < current.value) {
                    current = current.leftChild;
                    if (current == null) {
                        node.level = parent.level+1;
                        parent.leftChild = node;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        node.level = parent.level+1;
                        parent.rightChild = node;
                        return;
                    }
                }
            }
        }
    }

    //поиск преемника после удаления
    public Node getSuccesor(Node node) {
        Node successorParent = node;
        Node successor = node;
        Node current = node.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if(successor != node.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = node.rightChild;
        }

        return successor;
    }

    public boolean delete(int value) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (current.value != value) {
            parent = current;
            if(value<current.value) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if(current == null) {
                return false;
            }
        }

        //Если узел не имеет потомков
        if(current.leftChild == null && current.rightChild == null) {
            if(current == root) {
                root = null;
            } else if(isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        }

        //Если нет правого потомка
        else if(current.rightChild == null) {
            if(current == root) {
                root = current.leftChild;
            } else if(isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        }

        //Если нет левого потомка
        else if (current.leftChild == null) {
            if(current == root) {
                root = current.rightChild;
            } else if(isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            Node successor = getSuccesor(current);
            if(current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    public void displayTree() {
        Stack stack = new Stack(100);
        stack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;

        while(!isRowEmpty) {
            Stack localStack = new Stack(100);
            isRowEmpty = true;
            for(int i = 0; i<nBlanks; i++) {
                System.out.print(" ");
            }
            while(!stack.isEmpty()) {
                Node temp = stack.pop();
                if(temp != null) {
                    temp.display();
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if(temp.leftChild != null || temp.rightChild != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for(int j = 0; j < nBlanks * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println(" ");
            nBlanks = nBlanks / 2;
            while (!localStack.isEmpty()) {
                stack.push(localStack.pop());
            }
            System.out.println("...............................................................");
        }
    }

    //сравнение двух максимальных веток рассматриваемого корня
    public void compareTwoBranches(Node rootNode) {
        int leftMaxLevelCounter = rootNode.level;
        int rightMaxLevelCounter = rootNode.level;
        this.levelCounter = 0;

        if(rootNode.leftChild != null) {
            inOrderFindMaxBranch(rootNode.leftChild);
            leftMaxLevelCounter = levelCounter;
        }

        this.levelCounter = 0;
        if(rootNode.rightChild != null) {
            inOrderFindMaxBranch(rootNode.rightChild);
            rightMaxLevelCounter = levelCounter;
        }

        if(leftMaxLevelCounter+1 < rightMaxLevelCounter || leftMaxLevelCounter > rightMaxLevelCounter+1 || !isBalanced) {
            isBalanced = false;
        }
    }

    //поиск максимальной длины ветки рассматриваемого корня
    private void inOrderFindMaxBranch(Node rootNode) {
        if(rootNode != null) {
            inOrderFindMaxBranch(rootNode.leftChild);
            if (this.levelCounter < rootNode.level) {
                this.levelCounter = rootNode.level;
            }
            inOrderFindMaxBranch(rootNode.rightChild);
        }
    }

    //проход по всем корням со сравнением максимальных ветвей.
    private void inOrderCompareAllBranches(Node rootNode) {
        if(rootNode != null && isBalanced) {            //проверка isBalanced здесь для уменьшения количества операций,
                                                        // если найден хоть один не сбалансированный корень
            inOrderCompareAllBranches(rootNode.leftChild);
            compareTwoBranches(rootNode);
            inOrderCompareAllBranches(rootNode.rightChild);
        }
    }

    //запуск определения сбалансированности всех корней
    public boolean isBalanced() {
        isBalanced = true;              //на случай, если проверка будет проходить после внесения изменений в древо
        inOrderCompareAllBranches(root);
        return isBalanced;
    }
}
