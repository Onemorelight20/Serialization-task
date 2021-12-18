package com.realization;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import com.person.*;

public class DataProcessing {
	
	public void serialize(List<Person> list) throws IOException, ClassNotFoundException{

		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Data.txt")); 
		out.writeObject(list);
		out.close();
		
	}
	
	public List<Person> deserialize() throws IOException, ClassNotFoundException{
		List<Person> persons = null;
		
		try {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Data.txt"));
		persons = (List<Person>)in.readObject();
		in.close();
		} catch(EOFException e) {
			//System.err.println("The database is empty");
			persons = new ArrayList<>();
		}
		
		return persons;
	}
}
