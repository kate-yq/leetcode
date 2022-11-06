import java.util.HashMap;

public class Q133 {
    HashMap<Integer, Node> vertices; 

    public Node cloneGraph(Node node) {
        if (node == null){
            return null;
        }

        this.vertices = new HashMap<>();
        Node copy_node = new Node(node.val);
        vertices.put(node.val, copy_node);
        draw(node, copy_node);

        return copy_node;
    }

    private void draw(Node origin, Node copy){
        for (Node neighbor : origin.neighbors){
            if(this.vertices.containsKey(neighbor.val)){
                copy.neighbors.add(vertices.get(neighbor.val));
            } else {
                Node copy_neighbor = new Node(neighbor.val);
                this.vertices.put(neighbor.val, copy_neighbor);
                draw(neighbor, copy_neighbor);
                copy.neighbors.add(copy_neighbor);
            }
        }
    }
}
