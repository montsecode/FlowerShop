package com.controller;

import java.util.ArrayList;
import java.util.List;

import com.domain.Decoration;
import com.domain.Florist;
import com.domain.Flower;
import com.domain.Tree;


public class Controller {

	private List<Florist> floristList = new ArrayList<>();
	
	
	
	public Controller() {}
	
	public void createFlorist(String floristName) {
		Florist myFlorist = new Florist(floristName);
		floristList.add(myFlorist);
	}
	
	
	public Florist getFlorist(String floristName) throws Exception {
		int i = 0;
		while ( i<floristList.size()) {
			if (floristList.get(i).getFloristName().equals(floristName)) {
				return floristList.get(i);
			} 
			i++;
		}
		throw new Exception("This florist does not exist") ;
	}
	
	
	public void addTree(String floristName, double height, double price) throws Exception {
		Florist currentFlorist = getFlorist(floristName);
		currentFlorist.addTree(height, price);
		
	}
	
	public void addFlower(String floristName, String color, double price) throws Exception {
		Florist currentFlorist = getFlorist(floristName);
		currentFlorist.addFlower(color, price);
	}
	
	public void addDecoration(String floristName, String material, double price) throws Exception {
		Florist currentFlorist = getFlorist(floristName);
		currentFlorist.addDecoration(material, price);
	}
	
	public void printAllTrees(String floristName) throws Exception {
		Florist currentFlorist = getFlorist(floristName);
		int count = 1;
		for (Tree t : currentFlorist.getTrees()) {
			System.out.println("Tree " + count + ": " + t);
			count++;
		}

		
		
	}
	
	public void printAllFlowers(String floristName) throws Exception {
		Florist currentFlorist = getFlorist(floristName);
		int count = 1;
		for (Flower f : currentFlorist.getFlowers()) {
			System.out.println("Flower " + count + ": " + f);
			count++;
		}
	}
	
	
	public void printAllDecorations(String floristName) throws Exception {
		Florist currentFlorist = getFlorist(floristName);
		int count = 1;
		for (Decoration d : currentFlorist.getDecorations()) {
			System.out.println("Decoration " + count + ": " + d);
			count++;
		}
	}
	
	
	public void printAllItems(String floristName) throws Exception {
		System.out.println(floristName + " stock:");
		printAllTrees(floristName);
		printAllFlowers(floristName);
		printAllDecorations(floristName);	
	}
}