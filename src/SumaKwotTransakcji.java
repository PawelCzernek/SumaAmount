
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SumaKwotTransakcji {
	
public static void main(String[] args) {
		
		Scanner in = null;
		
		String name;
		String surname;
		String src_iban;
		String dst_iban;
		String amountStr;
		Double amount;
		Double suma = 0.0;
		
		
		ArrayList<String> nameList = new ArrayList<>();
		ArrayList<String> surnameList = new ArrayList<>();
		ArrayList<String> src_ibanList = new ArrayList<>();
		ArrayList<String> dst_ibanList = new ArrayList<>();
		ArrayList<String> amountList = new ArrayList<>();
		ArrayList<Double> amountDoubleList = new ArrayList<>();
		
		
		
		try{
			
			in = new Scanner(Paths.get("./Plik z danymi.txt"));
			in.useDelimiter(Pattern.compile("[\\r\\n@:]+"));
			while(in.hasNext()){
				
				in.next();
				name = in.next();
				in.next();
				surname = in.next();
				in.next();
				src_iban = in.next();
				in.next();
				dst_iban = in.next();
				in.next();
				amountStr = in.next();
				
				nameList.add(name);
				surnameList.add(surname);
				src_ibanList.add(src_iban);
				dst_ibanList.add(dst_iban);
				amountList.add(amountStr);
				
				
				System.out.printf ("Wczytano dane -> name: %s, surname: %s, src_iban: %s, dst_iban: %s, amount: %s\n",name, surname,src_iban,dst_iban,amountStr );
			}
			
		} 
		catch (Exception e){
			e.printStackTrace();
		}
		finally {
			if(in != null) {
				in.close();
			}
			
		}
		
		for(int i=0; i< amountList.size(); i++){
			String digit = amountList.get(i);
			String digit2 = "";
			for(int j=0; j<digit.length(); j++){
				
				if(digit.charAt(j)==','){
					digit2 = digit.substring(0,j-1)+'.'+digit.substring(j+1);
				}
				amountList.set(i, digit2);
			}
			amount = Double.valueOf(digit2.substring(0, 3));
			amountDoubleList.add(amount);			
			//Obliczanie sumy
			
			for (int k=0; k< amountDoubleList.size(); k++ ){
				suma += amountDoubleList.get(i);	
			}
		}
		System.out.println("Suma wartości amount wynosi:"+suma);
	}

}
