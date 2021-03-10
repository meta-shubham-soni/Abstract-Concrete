import java.util.HashMap;
import java.lang.Math;
import java.util.*;

public class Poly {
	private HashMap<Integer,Integer> polynomial = new HashMap<Integer,Integer>();
	
	//constructor
	Poly(HashMap<Integer,Integer> poly){
		polynomial = poly;
	}
	
	//helper function
	HashMap<Integer,Integer> getPoly(){
		return new HashMap<Integer,Integer>(polynomial);
	}

	//function send length of polynomial
	public int getLen(){
		return polynomial.size();
	}
	
	//function to add a new element to polynomial
	public void addElement(int pow,int coeff){
		if(polynomial.containsKey(pow)){
			System.out.print("this pow already exists");
			return ;
		}
		
		polynomial.put(pow,coeff);
	}
	
	//function to delete a element to polynomial
	public void removeElement(int pow,int coeff){
		if(!polynomial.containsKey(pow)){
			System.out.print("this pow doesn't exists");
			return ;
		}
		
		polynomial.remove(pow);
	}
	
	/**
	 * function to evalute the value of poly for num
	 * @param num
	 * @return 
	 */
	public float evaluate(float num){
		float ans = 0;
		
		for(Map.Entry mapElement : polynomial.entrySet()){
			ans += Math.pow(num,Integer.parseInt(mapElement.getKey().toString())) * Integer.parseInt( mapElement.getValue().toString()) ;
		}
		return ans;
	}
	
	//function find Degree of poly
	public int getDegree(){
		int degree = -1;
		for(Map.Entry mapElement : polynomial.entrySet()){
			int tempDegree = Integer.parseInt(mapElement.getKey().toString());
			if(tempDegree > degree)
				degree = tempDegree;
		}
		
		return degree;
	}
	
	
	//function to print Polynomial
	public void printPoly(){
		for(Map.Entry mapElement : polynomial.entrySet()){
			System.out.print(mapElement.getValue()+"x^"+mapElement.getKey()+" ");
		}
		System.out.println();
	}
	
	//function to add two polynomials
	public static Poly add(Poly p1,Poly p2){
		HashMap<Integer,Integer> tempPolynomial = new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> P1 = p1.getPoly();
		HashMap<Integer,Integer> P2 = p2.getPoly();
		int deg1 = p1.getDegree();
		int deg2 = p2.getDegree();
		int deg = deg1 > deg2 ? deg1 : deg2;
		
		for(int i=0;i<=deg;i++){
			if(P1.containsKey(i) && P2.containsKey(i)){
				tempPolynomial.put(i, P1.get(i) + P2.get(i));
			}
			else if(P1.containsKey(i)){
				tempPolynomial.put(i, P1.get(i));	
			}
			else if(P2.containsKey(i)){
				tempPolynomial.put(i, P2.get(i));	
			}
		}
		return new Poly(tempPolynomial);
	}
	
	//functions to multiply two polynomials
	public static Poly multiply(Poly p1,Poly p2){
		HashMap<Integer,Integer> ansPolynomial = new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> P1 = p1.getPoly();
		HashMap<Integer,Integer> P2 = p2.getPoly();
		int deg1 = p1.getDegree();
		int deg2 = p2.getDegree();
		
		for(Map.Entry mapElement : P1.entrySet()){
			HashMap<Integer,Integer> tempPolynomial = new HashMap<Integer,Integer>();
			for(Map.Entry mapElement2 : P2.entrySet()){

				int coeff = Integer.parseInt(mapElement.getValue().toString()) * Integer.parseInt(mapElement2.getValue().toString());
				int pow = Integer.parseInt(mapElement.getKey().toString()) + Integer.parseInt(mapElement2.getKey().toString());
				
				tempPolynomial.put(pow, coeff);
			}
			ansPolynomial = add(new Poly(ansPolynomial),new Poly(tempPolynomial)).getPoly();
		}
		return new Poly(ansPolynomial);
	}
}
