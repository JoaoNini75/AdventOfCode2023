package adventOfCode2023;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CH7_Hand {

	private String hand;
	private int bid;
	private static Map<Character, Integer> map;
	
	public CH7_Hand(String hand, int bid) {
		this.hand = hand;
		this.bid = bid;
		CH7_Hand.map = new HashMap<>(); // A, K, Q, J, T, 9, 8, 7, 6, 5, 4, 3, or 2
		CH7_Hand.map.put('A', 14);
		CH7_Hand.map.put('K', 13);
		CH7_Hand.map.put('Q', 12);
		CH7_Hand.map.put('T', 10);
		CH7_Hand.map.put('9', 9);
		CH7_Hand.map.put('8', 8);
		CH7_Hand.map.put('7', 7);
		CH7_Hand.map.put('6', 6);
		CH7_Hand.map.put('5', 5);
		CH7_Hand.map.put('4', 4);
		CH7_Hand.map.put('3', 3);
		CH7_Hand.map.put('2', 2);
		CH7_Hand.map.put('J', 1);
	}
	
	static class HandComparator implements Comparator<CH7_Hand>{
	   @Override
	   public int compare(CH7_Hand h1, CH7_Hand h2) {
		   String hand1 = h1.getHand();
		   String hand2 = h2.getHand();
		   
		   int rank1 = getRank(hand1);
		   int rank2 = getRank(hand2);
		   
		   if (rank1 != rank2)
			   return rank1 - rank2;
		   
	       return compareChars(hand1, hand2);
	   }

		private int compareChars(String hand1, String hand2) {
			for (int i = 0; i < 5; i++) {
				char ch1 = hand1.charAt(i);
				char ch2 = hand2.charAt(i);
				
				int val1 = map.get(ch1);
				int val2 = map.get(ch2);
				
				if (val1 > val2)
					return 1;
				
				if (val2 > val1)
					return -1;
			}
			
			return 0;
		}

		private int getRank(String hand) {
			Map<Character, Integer> chars = new HashMap<>(5);
			
			for (int i = 0; i < 5; i++) {
				char ch = hand.charAt(i);
				Integer v = chars.get(ch);
				
				if (v == null)
					chars.put(ch, 1);
				else
					chars.put(ch, v+1);
			}
			
			Collection<Entry<Character, Integer>> res = chars.entrySet();
			int jNum = chars.get('J');
			
			boolean quad = false;
			char quadCh = '.';
			boolean three = false;
			char threeCh = '.';
			
			int pairs = 0;
			char pair1Ch = '.', pair2Ch = '.';
			
			for (Entry<Character, Integer> e : res) {
				char ch = e.getKey();
				int i = e.getValue();
				
				if (i == 5) 
					return 7;
				else if (i == 4) {
					quad = true;
					quadCh = ch;
				} else if (i == 3) {
					three = true;
					threeCh = ch;
				} else if (i == 2) {
					if (pairs == 0) 
						pair1Ch = ch;
					else
						pair2Ch = ch;
					
					pairs++;
				}
					
			}
			
			if (quad) {
				if (quadCh != 'J')
					return 6 + jNum;
				return 6;
			}
			
			if (three) { // tripla, full house, quadra, quinta
				if (threeCh != 'J') {
					if (jNum == 2)
						return 5;
				}
					
				return 4;
			}
			
			if (three && pairs == 1)
				return 5;
			
			if (three) 
				return 4;
			
			if (pairs == 2)
				return 3;
			
			if (pairs == 1)
				return 2;
			
			return 1;
		}
	}

	public String getHand() {
		return hand;
	}

	public void setHand(String hand) {
		this.hand = hand;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}
}
