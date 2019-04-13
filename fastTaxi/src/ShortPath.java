import java.util.List;

class ShortPath
{
	private static Vertex[] vertices;
	
	public static void setup()
	{
		//initilize nodes. 
		Vertex n1 = new Vertex("Node 1");
		Vertex n2 = new Vertex("Node 2");
		Vertex n3 = new Vertex("Node 3");
		Vertex n4 = new Vertex("Node 4");
		Vertex n5 = new Vertex("Node 5");
		Vertex n6 = new Vertex("Node 6");
		Vertex n7 = new Vertex("Node 7");
		Vertex n8 = new Vertex("Node 8");
		Vertex n9 = new Vertex("Node 9");
		Vertex n10 = new Vertex("Node 10");
		Vertex n11 = new Vertex("Node 11");
		Vertex n12 = new Vertex("Node 12");
		Vertex n13 = new Vertex("Node 13");
		Vertex n14 = new Vertex("Node 14");
		Vertex n15 = new Vertex("Node 15");
		Vertex n16 = new Vertex("Node 16");
		// create adjacencies using new node and an assigned weight value that is distance
		n1.adjacencies = new Edge[] {new Edge(n2, 1000), new Edge(n4, 600)};
		n2.adjacencies = new Edge[] {new Edge(n3, 1300), new Edge(n5, 600), new Edge(n1, 1000)};
		n3.adjacencies = new Edge[] {new Edge(n2, 1300), new Edge(n8, 900)};
		n4.adjacencies = new Edge[] {new Edge(n1, 600), new Edge(n5, 1000), new Edge(n6, 300)};
		n5.adjacencies = new Edge[] {new Edge(n2, 600), new Edge(n4, 1000), new Edge(n7, 300)};
		n6.adjacencies = new Edge[] {new Edge(n4, 300), new Edge(n7, 1000), new Edge(n9, 300)};
		n7.adjacencies = new Edge[] {new Edge(n5, 300), new Edge(n6, 1000), new Edge(n8, 1300), new Edge(n10, 300)};
		n8.adjacencies = new Edge[] {new Edge(n7, 1300), new Edge(n3, 900), new Edge(n11, 300)};
		n9.adjacencies = new Edge[] {new Edge(n6, 300), new Edge(n12, 300), new Edge(n10, 1000)};
		n10.adjacencies = new Edge[] {new Edge(n7, 300), new Edge(n9, 1000), new Edge(n13, 300), new Edge(n11, 1300)};
		n11.adjacencies = new Edge[] {new Edge(n10, 1300), new Edge(n8, 300), new Edge(n11, 600)};
		n12.adjacencies = new Edge[] {new Edge(n9, 300), new Edge(n13, 1000), new Edge(n14, 300)};
		n13.adjacencies = new Edge[] {new Edge(n10, 300), new Edge(n12, 1000), new Edge(n15, 300)};
		n14.adjacencies = new Edge[] {new Edge(n12, 300), new Edge(n15, 1000)};
		n15.adjacencies = new Edge[] {new Edge(n14, 1000), new Edge(n13, 300), new Edge(n16, 1300)};
		n16.adjacencies = new Edge[] {new Edge(n11, 600), new Edge(n15, 1300)};
		
		vertices = new Vertex[] {n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13, n14, n15, n16};
	}
	
	
	public static List<Vertex> getShortest(int location, int destination) {		
		Dijkstra.computePaths(vertices[location]);
		
		List<Vertex> path = Dijkstra.getShortestPathTo(vertices[destination]);
		
		return path;
	}
}