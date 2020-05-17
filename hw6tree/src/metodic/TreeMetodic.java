package metodic;

public class TreeMetodic {
    private NodeMetodic root;

    public NodeMetodic find(int key) {
        NodeMetodic current = root;
        while (current.personMetodic.id != key) {
            if(key < current.personMetodic.id) {
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

    public void insert (PersonMetodic personMetodic) {
        NodeMetodic nodeMetodic = new NodeMetodic();
        nodeMetodic.personMetodic = personMetodic;
        if (root == null) {
            root = nodeMetodic;
        } else {
            NodeMetodic current = root;
            NodeMetodic parent;
            while (true) {
                parent = current;
                if (personMetodic.id < current.personMetodic.id) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = nodeMetodic;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = nodeMetodic;
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int id) {
        NodeMetodic current = root;
        NodeMetodic parent = root;
        boolean isLeftChild = true;

        while (current.personMetodic.id != id) {
            parent = current;
            if(id<current.personMetodic.id) {
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
            NodeMetodic successor = getSuccesor(current);
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

    public NodeMetodic getSuccesor(NodeMetodic nodeMetodic) {
        NodeMetodic successorParent = nodeMetodic;
        NodeMetodic successor = nodeMetodic;
        NodeMetodic current = nodeMetodic.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if(successor != nodeMetodic.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = nodeMetodic.rightChild;
        }

        return successor;
    }

    public void traverse(int traverseType) {
        switch(traverseType) {
            case 1: System.out.println("Preorder traversal");
            preOrder(root);
            break;
        }
    }

    private void preOrder(NodeMetodic rootNodeMetodic) {
        if(root != null) {
            rootNodeMetodic.display();
            preOrder(rootNodeMetodic.leftChild);
            preOrder(rootNodeMetodic.rightChild);
        }
    }

    private void postOrder(NodeMetodic rootNodeMetodic) {
        if(rootNodeMetodic != null) {
            postOrder(rootNodeMetodic.leftChild);
            postOrder(rootNodeMetodic.rightChild);
            rootNodeMetodic.display();
        }
    }

    private void inOrder(NodeMetodic rootNodeMetodic) {
        if(rootNodeMetodic != null) {
            inOrder(rootNodeMetodic.leftChild);
            rootNodeMetodic.display();
            inOrder(rootNodeMetodic.rightChild);
        }
    }

    public void displayTree() {
        StackMetodic stackMetodic = new StackMetodic(100);
        stackMetodic.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;

        while(!isRowEmpty) {
            StackMetodic localStackMetodic = new StackMetodic(100);
            isRowEmpty = true;
            for(int i = 0; i<nBlanks; i++) {
                System.out.print(" ");
            }
            while(!stackMetodic.isEmpty()) {
                NodeMetodic temp = stackMetodic.pop();
                if(temp != null) {
                    temp.display();
                    localStackMetodic.push(temp.leftChild);
                    localStackMetodic.push(temp.rightChild);
                    if(temp.leftChild != null || temp.rightChild != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStackMetodic.push(null);
                    localStackMetodic.push(null);
                }
                for(int j = 0; j < nBlanks * 2 - 2; j++)
                    System.out.print("  ");
            }
            System.out.println(" ");
            nBlanks = nBlanks / 2;
            while (!localStackMetodic.isEmpty()) {
                stackMetodic.push(localStackMetodic.pop());
            }
            System.out.println("...............................................................");
        }
    }

    public NodeMetodic min() {
        NodeMetodic current, last = null;
        current = root;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    public NodeMetodic max() {
        NodeMetodic current, last = null;
        current = root;
        while (current != null) {
            last = current;
            current = current.rightChild;
        }
        return last;
    }


}
