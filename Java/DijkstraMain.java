import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraMain {

    public static void main(String[] args) {

        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");
        Vertex vertexD = new Vertex("D");
        Vertex vertexE = new Vertex("E");

        vertexA.addNeighbour(new Edge(10, vertexA, vertexC));
        vertexA.addNeighbour(new Edge(17, vertexA, vertexB));
        vertexC.addNeighbour(new Edge(5, vertexC, vertexB));
        vertexC.addNeighbour(new Edge(9, vertexC, vertexD));
        vertexC.addNeighbour(new Edge(11, vertexC, vertexE));
        vertexB.addNeighbour(new Edge(1, vertexB, vertexD));
        vertexD.addNeighbour(new Edge(6, vertexD, vertexE));

        DijkstraShortestPath shortestPath = new DijkstraShortestPath();
        shortestPath.computeShortestPaths(vertexA);

        System.out.println("======================================");
        System.out.println("Calculating minimum distance");
        System.out.println("======================================");

        System.out.println("Minimum distance from A to B: " + vertexB.getDistance());
        System.out.println("Minimum distance from A to C: " + vertexC.getDistance());
        System.out.println("Minimum distance from A to D: " + vertexD.getDistance());
        System.out.println("Minimum distance from A to E: " + vertexE.getDistance());

        System.out.println("=====================	=================");
        System.out.println("Calculating Paths");
        System.out.println("======================================");

        System.out.println("Shortest Path from A to B: " + shortestPath.getShortestPathTo(vertexB));
        System.out.println("Shortest Path from A to C: " + shortestPath.getShortestPathTo(vertexC));
        System.out.println("Shortest Path from A to D: " + shortestPath.getShortestPathTo(vertexD));
        System.out.println("Shortest Path from A to E: " + shortestPath.getShortestPathTo(vertexE));


    }
}

class DijkstraShortestPath {

    public void computeShortestPaths(Vertex sourceVertex) {

        sourceVertex.setDistance(0);
        PriorityQueue < Vertex > priorityQueue = new PriorityQueue < > ();
        priorityQueue.add(sourceVertex);
        sourceVertex.setVisited(true);

        while (!priorityQueue.isEmpty()) {
            // Getting the minimum distance vertex from priority queue
            Vertex actualVertex = priorityQueue.poll();

            for (Edge edge: actualVertex.getAdjacenciesList()) {

                Vertex v = edge.getTargetVertex();
                if (!v.isVisited()) {
                    double newDistance = actualVertex.getDistance() + edge.getWeight();

                    if (newDistance < v.getDistance()) {
                        priorityQueue.remove(v);
                        v.setDistance(newDistance);
                        v.setPredecessor(actualVertex);
                        priorityQueue.add(v);
                    }
                }
            }
            actualVertex.setVisited(true);
        }
    }

    public List < Vertex > getShortestPathTo(Vertex targetVertex) {
        List < Vertex > path = new ArrayList < > ();

        for (Vertex vertex = targetVertex; vertex != null; vertex = vertex.getPredecessor()) {
            path.add(vertex);
        }

        Collections.reverse(path);
        return path;
    }

}

class Edge {

    private double weight;
    private Vertex startVertex;
    private Vertex targetVertex;

    public Edge(double weight, Vertex startVertex, Vertex targetVertex) {
        this.weight = weight;
        this.startVertex = startVertex;
        this.targetVertex = targetVertex;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Vertex getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(Vertex startVertex) {
        this.startVertex = startVertex;
    }

    public Vertex getTargetVertex() {
        return targetVertex;
    }

    public void setTargetVertex(Vertex targetVertex) {
        this.targetVertex = targetVertex;
    }
}

class Vertex implements Comparable < Vertex > {

    private String name;
    private List < Edge > adjacenciesList;
    private boolean visited;
    private Vertex predecessor;
    private double distance = Double.MAX_VALUE;

    public Vertex(String name) {
        this.name = name;
        this.adjacenciesList = new ArrayList < > ();
    }

    public void addNeighbour(Edge edge) {
        this.adjacenciesList.add(edge);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List < Edge > getAdjacenciesList() {
        return adjacenciesList;
    }

    public void setAdjacenciesList(List < Edge > adjacenciesList) {
        this.adjacenciesList = adjacenciesList;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(Vertex otherVertex) {
        return Double.compare(this.distance, otherVertex.getDistance());
    }
}