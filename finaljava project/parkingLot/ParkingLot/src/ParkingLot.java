import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class ParkingLot extends  javax.swing.JFrame{

    private int parkingSlot;

    private String dataFile;
    private String temp;
    private int maxLotSize;
    ParkingLot(String file){
    	
        maxLotSize = 30;
       
        parkingSlot=0;
        dataFile = file;
        temp="src//temp.txt";
    }
    public Boolean isfull() throws IOException {
    	int num=0;
    	try {
			BufferedReader br =new BufferedReader(new FileReader(dataFile));
			String line;
			 num=0;
			while ((line = br.readLine()) != null) {
				num++;
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(num>=maxLotSize) {
    		return true;
    	}
    	return false;
    }
    
    public void Store(String s) {
    	try{   parkingSlot=getParkingslot();
	           String f =dataFile;
	           
	           BufferedWriter output = new BufferedWriter(new FileWriter(f,true));
	    
	           output.append(s+","+parkingSlot+"\n");
	           output.close();
	          
	       }
		catch(Exception e1){
			System.out.println(e1);
		}
    }
    public int getParkingslot() throws FileNotFoundException {
    	String line;
    	int num=0,n;
        BufferedReader br=new BufferedReader(new FileReader(dataFile));
        try {
			while ((line = br.readLine()) != null) {
				num++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        n=num;
        return n;
    }
    public void remove(String re) throws FileNotFoundException {
    	String k =re;
        BufferedReader br=new BufferedReader(new FileReader(dataFile));
        
        
        	String line,number,str;
        	System.out.println(re);
        	try {
        		BufferedWriter output = new BufferedWriter(new FileWriter(temp,false));
				while ((line = br.readLine()) != null) {
					str=line;
					number=line.split(",")[0];
					if(number.equals(re)) {
						System.out.println(re);	
					}
					else {
						output.append(str+"\n");
					}
				}
				output.close();	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	BufferedReader wr=new BufferedReader(new FileReader(temp));
        	try {
        		BufferedWriter out = new BufferedWriter(new FileWriter(dataFile,false));
				while ((line = wr.readLine()) != null) {
					out.append(line+"\n");
				}
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
    public int Capacity() {
    	try {
			int n =getParkingslot();
			int k=maxLotSize;
			return k-n;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
    	
    }
    public String Locate(String k) throws FileNotFoundException {
    	BufferedReader br=new BufferedReader(new FileReader(dataFile));
    	String line,number;
    	String n="-1";
    	try {
			while((line = br.readLine()) != null) {
				number=line.split(",")[0];
				if(number.equals(k)) {
					n=line.split(",")[1];
					return n;
				}
				
			}
			
		
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
    }
   
}
