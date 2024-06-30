package security;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Encryption {

	private Scanner sc;
	private Random r;
	private ArrayList<Character> list;
	private ArrayList<Character> shuffledList;
	private char character;
	private String line;
	private char[] letters;
	
	Encryption(){
		sc = new Scanner(System.in);
		r = new Random();
		list = new ArrayList();
		shuffledList = new ArrayList();
		character = ' ';

		newKey();
		askQuestion();
	}
	private void askQuestion(){
		
		while(true) {
			System.out.println("********************************************");
			System.out.println("What do you want to do?");
			System.out.println("(N)ewKey,(G)etKey,(E)ncrypt,(D)ecrypt,(Q)uit");
			char response = Character.toUpperCase(sc.nextLine().charAt(0));
			
			switch(response) {
			case 'N':
				newKey();
				break;
			case 'G':
				getKey();
				break;
			case 'E':
				encrypt();
				break;
			case 'D':
				decrypt();
				break;
			case 'Q':
				quit();
				break;
			default:
				System.out.println("System Warning");
			}
		}
	}
	private void newKey(){
		
		character = ' ';
		list.clear();
		shuffledList.clear();
		
		for(int i=32;i<127;i++) {
			list.add(Character.valueOf(character));
			character++;
		}
		
		shuffledList = new ArrayList(list);
		Collections.shuffle(shuffledList);
		System.out.println("*A new key has been generated*");
		
	}
	private void getKey(){
		System.out.println("Key: ");
		for(Character x : list) {
			System.out.print(x);
		}
		System.out.println();
		for(Character x : shuffledList) {
			System.out.print(x);
		}
		System.out.println();
	}
	private void encrypt(){
		System.out.print("Enter a message to be encrypted: ");
		String message = sc.nextLine();
		
		letters = message.toCharArray();
		
		for(int i =0;i<letters.length;i++) {
			
			for(int j =0;j<list.size();j++) {
				if(letters[i]==list.get(j)) {
					letters[i]=shuffledList.get(j);
					break;
				}
			}
		}
		System.out.println("Encrypted: ");
		for(char x : letters) {
			System.out.print(x);
		}
		System.out.println();
	}
	private void decrypt(){
		System.out.print("Enter a message to be decrypted: ");
		String message = sc.nextLine();
		
		letters = message.toCharArray();
		
		for(int i =0;i<letters.length;i++) {
			
			for(int j =0;j<shuffledList.size();j++) {
				if(letters[i]==shuffledList.get(j)) {
					letters[i]=list.get(j);
					break;
				}
			}
		}
		System.out.println("Decrypted: ");
		for(char x : letters) {
			System.out.print(x);
		}
		System.out.println();
	}
	private void quit(){
		System.out.println("Thank you, have a safe day");
		System.exit(0);
	}
	
}
