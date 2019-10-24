public class Hashing{
	
	private int Slots = 31;
	private Namen[] kush = new Namen[Slots];

	public boolean insert(Namen n){
		int wert = hash(n.getName());
		if(kush[wert] == null){
			kush[wert] = n;
			return true;
		}else{
			for(int i = 1; i<Slots; i++){
				if(kush[(wert+i)%Slots] == null){
					kush[(wert+i)%Slots] = n;
					return true;
				}
			}
		}
		System.out.println("no memory");
		return false;
	}

	public Namen get(String name){
		int wert = hash(name);
		if(kush[wert].Name.compareTo(name) == 0){
			return kush[wert];
		}
		System.out.println("wrong");
		return null;
	}

	public int hash(String n){
		long val = 0;
		int i;

		n = n.toUpperCase();
		for( i=0; i<n.length();i++){
			val *= 100;
			val += (int) (n.charAt(i) -64);
		}
		i = (int) (val%(long)Slots);		
		return i;
	}

}
		 
			 					