package com.realization;
import java.util.Scanner;

import com.person.Person;

public class Main {

	public static void main(String[] args){
			
		String help = "Available commands:\nadd\nremove\nprint\nfinish";
		System.out.println(help);
		
		boolean doWork = true;
		while(doWork) {
			Scanner scan = new Scanner(System.in);
			String command = scan.next();
			switch (command) {
			case "add":
				Commands.addPerson();
				break;
			case "remove":
				Commands.removePerson();
				break;
			case "print":
				Commands.printData();
				break;
			case "finish":
				doWork = false;
				break;
			default:
				System.out.println("Unexpected value: " + command + help);
			}
		}
	}

}
