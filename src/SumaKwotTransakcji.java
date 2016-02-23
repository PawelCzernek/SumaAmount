
import java.math.BigDecimal;
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
		BigDecimal amount = BigDecimal.valueOf(0, 2);
		BigDecimal suma = BigDecimal.valueOf(0, 2);
		
		
		ArrayList<String> nameList = new ArrayList<>();
		ArrayList<String> surnameList = new ArrayList<>();
		ArrayList<String> src_ibanList = new ArrayList<>();
		ArrayList<String> dst_ibanList = new ArrayList<>();
		ArrayList<String> amountList = new ArrayList<>();
		ArrayList<BigDecimal> amountDoubleList = new ArrayList<>();
		
//		String filePath = "";
//		
//		if (args.equals(null)){
//			filePath ="./Plik z danymi.txt";
//				filePath = args.toString();
//		} else {
//			filePath = args.toString();
//		}
		
		
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
				
				
				//System.out.printf ("Wczytano dane -> name: %s, surname: %s, src_iban: %s, dst_iban: %s, amount: %s\n",name, surname,src_iban,dst_iban,amountStr );
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
					digit2+='.';
				}else if(digit.charAt(j)=='0'||digit.charAt(j)=='1'||digit.charAt(j)=='2'||digit.charAt(j)=='3'
						||digit.charAt(j)=='4'||digit.charAt(j)=='5'||digit.charAt(j)=='6'||digit.charAt(j)=='7'
						||digit.charAt(j)=='8'||digit.charAt(j)=='9'){
					digit2+=digit.charAt(j);
				}else{
					digit2+="";
				}
				amountList.set(i, digit2);
			}
			amount = new BigDecimal(digit2);
			amountDoubleList.add(amount);	
		}
			
			//Obliczanie sumy
			
			for (int k=0; k< amountDoubleList.size(); k++ ){
				suma = (suma.add(amountDoubleList.get(k)));	
			}
		
		System.out.println("Suma wartości amount wynosi:"+suma.toString());
	}

}
