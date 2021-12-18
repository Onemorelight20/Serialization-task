package com.realization;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.person.Person;

public class Commands {
	private static DataProcessing process = new DataProcessing();
	
	static void addPerson(){
		List<Person> curr = new ArrayList<>();
		try {
			curr = process.deserialize();
			System.out.println("Enter person`s name and id:");
			curr.add(readPersonFromConsole());
			
			process.serialize(curr);
			System.out.println("Susseccfully added.");
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	static void printData() {
		try {
			List<Person> data = process.deserialize();
			System.out.println("Current data:");
			System.out.println(data);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void removePerson() {
		System.out.println("Input person to delete data:");
		Person toDelete = readPersonFromConsole();
		try {
			List<Person> curr = process.deserialize();
			if(curr.contains(toDelete)) {
				curr.remove(toDelete);
				System.out.println("Successfully removed.");
			} else {
				System.out.println("There is no such a person in list.");
			}
		process.serialize(curr);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	private static Person readPersonFromConsole() {
		Scanner scan = new Scanner(System.in);
		String name = scan.next();
		int id = scan.nextInt();
		Person person = new Person(name, id);
		return person;
	}
}
