public class ShortCodeApplication {
    static public void main (String[] args) {
        ShortCode shortCode = new ShortCode();
    }
}

class ShortCode {
    private Node shortCodeTree = new Node();

    public void inputCode(String code){
        Node currentNode = shortCodeTree.getChild(code.charAt(0) - 'a');
        for(int i = 1; i < code.length(); i++) {
            currentNode = currentNode.getChild(code.charAt(i) - 'a');
        }
        currentNode.setValue(true);
    }

    public Node shortCodeNotConflict(Node node) {
        int[] positions = node.getChildrenPosition();
        for(int i = 0; i < positions.length; i++){
            node.setChild(shortCodeNotConflict(node.getChild(positions[i])),positions[i]);
        }
        if(positions.length == 1 && !node.getValue()) {
            if (node.getChild(positions[0]).getValue()) {
                node.setValue(true);
                if(node.getChild(positions[0]).numberChild() == 0)
                    node.setChild(null,positions[0]);
                else
                    node.getChild(positions[0]).setValue(false);
            }
        }
        return node;
    }

    public void searchValueFalse(Node node) {
        int[] positions = node.getChildrenPosition();
        for (int i = 0; i < positions.length; i++) {
            searchValueFalse(node.getChild(positions[i]));
        }
        if (!node.getValue()) {
            node.setValue(true);
            searchMaxDepthNodeToNull(node);
        }
    }

    private void searchMaxDepthNodeToNull(Node node) {
        int[] positions = node.getChildrenPosition();
        Node maxNodeBefore;
        int maxDepth = 0;
        for(int i = 0; i < positions.length; i++) {
            if()
        }
    }
}

class Node {
    private boolean value = false;
    private Node[] children = new Node[26];

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public Node getChild(int positionChild) {
        if(children[positionChild] == null)
            children[positionChild] = new Node();
        return children[positionChild];
    }

    public void setChild(Node child, int positionChild) {
        children[positionChild] = child;
    }

    public int numberChild() {
        int count = 0;
        for (int i = 0; i < children.length; i++) {
            if(children[i] != null)
                count++;
        }
        return count;
    }
    public int[] getChildrenPosition() {
        int[] positions = new int[numberChild()];
        int count = 0;
        for(int i = 0; i < children.length; i++) {
            if(children[i] != null)
                positions[count] = i;
        }
        return positions;
    }
}
