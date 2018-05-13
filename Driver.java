//Mei-Ying Croddy
//CS141 
//Assignment 4
//5/13/18


package hw4;

import java.util.*;
import java.io.*;






public class Driver {


	
	private static ArrayList<String> dictionary;
	private static ArrayList<String> refinedWordList;
	private static ArrayList<String> finalWordList;
	
	private static String userInput;
	
	public static void main(String[] args) throws IOException
	{
		readFile();
		userQuery();
	
		

	}
	
	public static void userQuery() throws IOException
	{

		refinedWordList = new ArrayList<String>();
		finalWordList = new ArrayList<String>();
		Scanner keyboard = new Scanner(System.in);
		
		
		
		
	
		do{
			System.out.print("Enter 3 letters: ");
			userInput = keyboard.nextLine();
			//System.out.println(userInput);  display
			if(userInput.toLowerCase().equals("exit"))
			{
				System.out.println("Exiting program.");
				break;
			}
			else
			{
				boolean match1 = false;
				boolean match2 = false;
				boolean match3 = false;
				
				if(userInput.length() !=3)
				{
					System.out.println("Please only enter 3 letters. ");
				}
			
				else
				{
					//start processing - find words containing those letters
					for(int i = 0; i < dictionary.size(); i++)
					{
						String word = dictionary.get(i);
						
						match1 = false;
						match2 = false;
						match3 = false;
						
							for(int k = 0; k < word.length(); k++)
							{
							

								if(userInput.charAt(0) == word.charAt(k))
								{
									match1 = true;
								}
							
								if(userInput.charAt(1) == word.charAt(k))
								{
									match2 = true;
								}
							
								if(userInput.charAt(2) == word.charAt(k))
								{
									match3 = true;
								}
					
			
							}
							
							if(match1 == true && match2 == true)
							{
								if(match2 ==true && match3 == true)
								{
								refinedWordList.add(word);
								//System.out.println(word);
							
							}
						
						
						}
					
					}
					
				//	for(int i = 0; i < refinedWordList.size(); i++)    displays arraylist for troubleshooting
				//	{
				//		System.out.println(refinedWordList.get(i));
				//	}
					
				
				}
				
				//refine that list - find words with letters in correct order
				
				int letterLocation1 = 0;
				int letterLocation2 = 0;
				int letterLocation3 = 0;
				
				
				for(int i = 0; i < refinedWordList.size(); i++)
				{
					String word = refinedWordList.get(i);
					
					letterLocation1 = 0;
					letterLocation2 = 0;
					letterLocation3 = 0;
					//keeps track of the location of the letter inside the word
					boolean letterFound1 = false;
					boolean letterFound2 = false;
					boolean letterFound3 = false;
					//switches to keep the first found matching letter 
					
					for(int k = 0; k < word.length(); k++)
					{
						if(userInput.charAt(0) == word.charAt(k))
						{
							if(letterFound1 == false)
							{
								letterLocation1 = k;
							}
							letterFound1 = true;
						}
						
						if(userInput.charAt(1) == word.charAt(k))
						{
							if(letterFound2 == false)
							{
								letterLocation2 = k;
							}
							letterFound2 = true;
						}
						
						if(userInput.charAt(2) == word.charAt(k))
						{
							if(letterFound3 == false)
							{
								letterLocation3 = k;
							}
							letterFound3 = true;
						}
						
						
					}
					

					if(letterLocation1 < letterLocation2)
					{
						if(letterLocation2 < letterLocation3)
						{
							finalWordList.add(word);
						//	System.out.println(word);
						}
					}

				}

				for(int j = 0; j < finalWordList.size(); j++)
				{
					System.out.println(finalWordList.get(j));
				}
				
			}
		}
		
		
			
			while(userInput!="exit");
			{
				
			}
		


		

	
	
		

		
	//	System.out.println(userInput);
	
		
		keyboard.close();
		
	}
	

	
	public static void readFile() throws IOException
	{
		dictionary = new ArrayList<String>();
		File inputFile = new File("wordsEn.txt");
		Scanner readFile = new Scanner(inputFile); 
		
		while(readFile.hasNext())
		{
			String word = readFile.next();
			dictionary.add(word);
		}
		
	// displays the list of words
	//	for(int i = 0; i < dictionary.size(); i++)
	//	{
	//		System.out.println(dictionary.get(i));
	//	}
		
		readFile.close();
	}
	


}


/* Notes:

Your job in this part of the assignment is to write a program that prompts the user for a three-letter string,
 and then prints all English words that match that pattern. Your program should sit in a loop prompting the 
 user to enter a three-letter string (which can be upper-case or lower-case), re-prompting as necessary 
 until the user enters a string consisting of three letters. Then, your program should list all English words 
 that match that string and the game restarts by prompting again for 3 letter word. Your program should exit if 
 the user type "exit". We've provided you a file (wordsEn.txt) containing all words in a dictionary, which you'll 
 need for this assignment. There are many ways you can implement this program. Although we haven't talked about 
 efficiency this quarter, file reading is slower than most other program operations. For full credit, your program 
 should only read in the dictionary file once. Other than that, don't worry about efficiency. 


*/