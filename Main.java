
import java.util.HashMap;
import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);		
		boolean flag = true;

		while(flag == true){
		    int in;

		    System.out.println("1. IntSet Driver");
		    System.out.println("2. Polynomial Driver");
		    System.out.println("3. Exit");
		    
		    in = sc.nextInt();
		    
		    if(in == 1){
		    	ISDriver();

		    }
		    else if(in == 2){
		    	PolyDriver();
		        
		    }
		    else if(in == 3){
		        
		    	flag = false;
		    }

		    else {
		    	System.out.println("Enter valid choice");
		    }
		}

	}
	
	public static void printArray(int[] ans){
		for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
        System.out.println();
	}
	
	public static int[] getIntSetInput(){
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the length of Intset!!");
		int length1 = sc.nextInt();
		System.out.println("Enter elements of Intset!!");
		int[] arr1 = new int[length1];
		for(int i=0;i<length1;i++){
			int x = sc.nextInt();
			arr1[i] = x;
		}
		return arr1;
	}
	
	public static HashMap<Integer,Integer> getPolyInput(){
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the power and coeff of each element!!");
		
		System.out.println("Enter -1 to end!!");
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		while(true){
			int key = sc.nextInt();
			if(key == -1)
				break;
			int val = sc.nextInt();
			
			hm.put(key, val);
		}
		return hm;
	}
	
	public static void ISDriver(){
		Scanner sc= new Scanner(System.in);	
		
		
		IntSet is1 = new IntSet(getIntSetInput());

		boolean flag = true;
		
		while(flag){
		    int in;

		    System.out.println("1. is Member");
		    System.out.println("2. get size");
		    System.out.println("3. is Subset");
		    System.out.println("4. get Complement");
		    System.out.println("5. Union");
		    System.out.println("6. Exit");
		    
		    in = sc.nextInt();
		    
		    if(in == 1){
		    	System.out.println("Enter a number to check");
		    	int n = sc.nextInt();
		    	System.out.println(is1.isMember(n));
		    }
		    else if(in == 2){
		    	System.out.println("Size of IntSet :-" + is1.size());
		    }
		    else if(in == 3){
		    	IntSet is2 = new IntSet(getIntSetInput());
		    	
		    	System.out.println(is1.isSubSet(is2));
		    }
			else if(in == 4){
				System.out.println("Complement of IntSet:-");
				printArray(is1.getComplement());
			}
			else if(in == 5){
				IntSet is2 = new IntSet(getIntSetInput());
				System.out.println("Union of IntSets:-");
				printArray(is1.union(is1,is2));
			}
			else if(in == 6){
				break;
			}
		}
		
		
		
	}
	
	public static void PolyDriver(){
		Scanner sc= new Scanner(System.in);	
		
		
		Poly p1 = new Poly(getPolyInput());

		boolean flag = true;
		
		while(flag){
		    int in;

		    System.out.println("1. evaluate");
		    System.out.println("2. get Degree");
		    System.out.println("3. add ");
		    System.out.println("4. multiply");
		    System.out.println("5. Insert an element");
		    System.out.println("6. Delete an element");
		    System.out.println("7. Exit");
		    
		    in = sc.nextInt();
		    
		    if(in == 1){
		    	System.out.println("Enter a number to evaluate");
		    	float n = sc.nextFloat();
		    	System.out.println(p1.evaluate(n));
		    }
		    else if(in == 2){
		    	System.out.println("Degree of Poly :-" + p1.getDegree());
		    }
		    else if(in == 3){
		    	Poly p2 = new Poly(getPolyInput());
		    	
		    	Poly.add(p1,p2).printPoly();
		    }
			else if(in == 4){
				Poly p2 = new Poly(getPolyInput());
		    	
		    	Poly.multiply(p1,p2).printPoly();
			}
			else if(in == 5){
				System.out.println("Enter pow and coefficeint  to add");
				int pow = sc.nextInt();
				int coeff = sc.nextInt();
				p1.addElement(pow,coeff);
			}
			else if(in == 6){

				System.out.println("Enter pow and coefficeint to delete");
				int pow = sc.nextInt();
				int coeff = sc.nextInt();
				p1.removeElement(pow,coeff);
			}
			else if(in == 7){
				break;
			}
		}
		
		
		
	}
}