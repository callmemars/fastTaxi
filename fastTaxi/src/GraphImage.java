import java.util.*; 

public class GraphImage
{
   int Node_Size = 20;
   int Edge_Count = 20;
   Node n1 = new Node(0, 0);
   Node n2 = new Node(0, 0);
   Node n3 = new Node(0, 0);
   Node n4 = new Node(0, 0);
   Node n5 = new Node(0, 0);
   Node n6 = new Node(0, 0);
   Node n7 = new Node(0, 0);
   Node n8 = new Node(0, 0);
   Node n9 = new Node(0, 0);
   Node n10 = new Node(0, 0);
   Node n11 = new Node(0, 0);
   Node n12 = new Node(0, 0);
   Node n13 = new Node(0, 0);
   Node n14 = new Node(0, 0);
   Node n15 = new Node(0, 0);
   Node n16 = new Node(0, 0);
   ArrayList<Node> nodes = new ArrayList<Node>();
   Edge[] edges = new Edge[20];
   
   void setupGraph()
   {  
      // All vertices set with pixel locations that correspond to intersections in philly2.
	  
      n1 = new Node(58, 81);
       n2 = new Node(220, 81);
       n3 = new Node(440, 81);
       n4 = new Node(58, 178);
       n5 = new Node(220, 178);
       n6 = new Node(58, 223);
       n7 = new Node(220, 223);
       n8 = new Node(440, 223);
       n9 = new Node(58, 268);
       n10 = new Node(220, 268);
       n11 = new Node(440, 268);
       n12 = new Node(58, 314);
       n13 = new Node(220, 314);
       n14 = new Node(58, 359);
       n15 = new Node(220, 359);
       n16 = new Node(440, 359);
     /* 
      nodes.add(n1);
      nodes.add(n2);
      nodes.add(n3);
      nodes.add(n4);
      nodes.add(n5);
      nodes.add(n6);
      nodes.add(n7);
      nodes.add(n8);
      nodes.add(n9);
      nodes.add(n10);
      nodes.add(n11);
      nodes.add(n12);
      nodes.add(n13);
      nodes.add(n14);
      nodes.add(n15);
      nodes.add(n16);
*/
      // All Edges: 
      n1.addEdge(n2, 1000);
      n1.addEdge(n4, 600);
      
      n2.addEdge(n3, 1300);
      n2.addEdge(n5, 600);
      
      n3.addEdge(n8, 900);
      
      n4.addEdge(n5, 1000);
      n4.addEdge(n6, 300);
      
      n5.addEdge(n7, 300);
      
      n6.addEdge(n7, 1000);
      n6.addEdge(n9, 300);
      
      n7.addEdge(n8, 1300);
      n7.addEdge(n10, 300);
      
      n8.addEdge(n11,300);
      
      n9.addEdge(n10, 1000);
      n9.addEdge(n12, 300);
      
      n10.addEdge(n11, 1300);
      n10.addEdge(n13, 300);
      n11.addEdge(n16, 600);
      
      n12.addEdge(n13, 1000);
      n12.addEdge(n14, 300);
      
      n13.addEdge(n15, 300);
      
      n14.addEdge(n15, 1000);
      
      n15.addEdge(n16, 1300); 
      
      
      nodes.add(n1);
      nodes.add(n2);
      nodes.add(n3);
      nodes.add(n4);
      nodes.add(n5);
      nodes.add(n6);
      nodes.add(n7);
      nodes.add(n8);
      nodes.add(n9);
      nodes.add(n10);
      nodes.add(n11);
      nodes.add(n12);
      nodes.add(n13);
      nodes.add(n14);
      nodes.add(n15);
      nodes.add(n16);
      //nodes.trimToSize();
      System.out.println(n16.edges);
   }
   /*
   1. Mark all nodes unvisited. Create a set of all the unvisited nodes called the unvisited set.
   2. Assign to every node a tentative distance value: set it to zero for our initial node and to infinity for all other nodes. Set the initial node as current.
   3. For the current node, consider all of its unvisited neighbors and calculate their tentative distances through the current node. 
      Compare the newly calculated tentative distance to the current assigned value and assign the smaller one. 
      For example, if the current node A is marked with a distance of 6, and the edge connecting it with a neighbor B has length 2, then the distance to B through A will be 6 + 2 = 8. 
      If B was previously marked with a distance greater than 8 then change it to 8. Otherwise, keep the current value.
   4. When we are done considering all of the unvisited neighbors of the current node, mark the current node as visited and remove it from the unvisited set. A visited node will never be checked again.
   5. If the destination node has been marked visited (when planning a route between two specific nodes)
       or if the smallest tentative distance among the nodes in the unvisited set is infinity 
       (when planning a complete traversal; occurs when there is no connection between the initial node and remaining unvisited nodes), then stop. The algorithm has finished.
   6 Otherwise, select the unvisited node that is marked with the smallest tentative distance, set it as the new "current node", and go back to step 3.
   */
   
   
   public void calcDistance(ArrayList<Node> n, Node location, Node destination)
   {
	  // System.out.println(n.get(0).getX() + " " + n.get(0).getY());
	   //System.out.println(n.get(15).getX() );
	   
	   int index = n.indexOf(location);
	
	   int destinationIndex = n.indexOf(destination);
	   
	   int[] parent = new int[n.size()];
	   //System.out.println(locationIndex);
	   //System.out.println(destinationIndex);

	   double BIGNUMBER = Double.MAX_VALUE;
	  System.out.println("n size : " + n.size());
	   
	 
	   
	   
	   double[] distance = new double[n.size()];
	   boolean[] isVisited = new boolean[n.size()];
	  // int[] x = new int[n.size()];
	 
	   //System.out.println(n.size());
	   for(int i = 0; i < distance.length; i++)
	   {
		   distance[i] = BIGNUMBER;
		   isVisited[i] = false;
		   parent[i] = -1;
		   //x[i] = -1;
	   }
	   // Set location node. 
	   distance[index] = 0;
	   isVisited[index] = true;
	   //System.out.println(location.edges);
	   //distance[] = 0;

	  List<Edge> edges = location.edges;
	  
	  int test = 0;
	  //System.out.println(edges.get(1).getWeight());
     
	 
	  System.out.println(edges.get(1).getWeight());
     
    //
		while(isVisited[destinationIndex] == false)
		{
	      		int min = Integer.MAX_VALUE;
		  		int minIndex = 0;
		  		
	      
			   // Loop through edges of each node. 
			   for (int i = 0; i< n.get(index).edges.size(); i++)
			   {
				   
				   //System.out.println(edges.get(i).getWeight());
	             
	               // Find shortest edge.
	             
				   if(n.get(index).edges.get(i).getWeight() < min
	                 && !isVisited[n.indexOf(n.get(index).edges.get(i).node2)])
				   {
					   min = n.get(index).edges.get(i).getWeight();
					   minIndex = n.indexOf(n.get(index).edges.get(i).node2);
					  
					   
					   //System.out.println(edges.get(i));
					   System.out.println("min indx: " + minIndex);
				   }	  
			   }
	      	 	isVisited[minIndex] = true;
	      	 	
				distance[minIndex] = min;
				parent[minIndex] = index;
	      		index = minIndex;
	      		for (int i = 0; i < isVisited.length -1;i++)
	      	 	{
	      	 		int count = i +1;
	      	 	//System.out.println("node: " + count + " " + isVisited[i]);	
	      	 	System.out.println("distance to node: " + i + " " + distance[i]);
	      	 	
	      	 	}
	      		//System.out.println("stuck");
		}
		System.out.println("not stuck");
	     //System.out.print(parent[0]);
	    int count = 0;
	   // int[] definitelyAQueue = new 
	     for (int i = destinationIndex; i != -1; i = parent[i])
	     {
	    	 
	    	 int nod = i +1;
	    	 
	        // System.out.println("node: " + nod);
	         
	      
	         
	     }
	        
   }
}
     
     