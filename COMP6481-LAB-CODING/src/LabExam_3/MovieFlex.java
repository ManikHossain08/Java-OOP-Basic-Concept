package LabExam_3;

import java.util.ArrayList;
import java.util.Scanner;

class MovieHT {

	private class MovieList {
		private String movieName;
		private String value;
		private MovieList next;

		MovieList(String name, String value) {
			this.movieName = name;
			this.value = value;
			this.next = null;
		}

	}

	private final static int TABLE_SIZE = 13;

	MovieList[] movieArr = new MovieList[TABLE_SIZE];

	public String isExists(String key) {
		int hash = computehashValue(key);
		if (movieArr[hash] == null)
			return "MovieNoTExist";
		else {
			MovieList entry = movieArr[hash];
			while (entry != null && !entry.movieName.contentEquals(key))
				entry = entry.next;
			if (entry == null)
				return "MovieNoTExist";
			else {
				System.out.println("movie already exists");
				return entry.value;
			}
		}
	}

	public void insertMovie(String mName, String value) {
		int hash = computehashValue(mName);
		if (movieArr[hash] == null)
			movieArr[hash] = new MovieList(mName, value);
		else {
			MovieList entry = movieArr[hash];
			while (entry.next != null)
				entry = entry.next;
			entry.next = new MovieList(mName, value);
		}
	}

	public String showHashTableContents() {
		System.out.println("==========");
		
		for (int i = 0; i < TABLE_SIZE; i++) {
			MovieList entry = movieArr[i];
			if (entry == null) {
				System.out.println("\nindex " + i + " has");
				System.out.println("empty");
				System.out.println("0 collisions");
				continue;
			}
			int collution = 0;
			System.out.println("\nindex " + i + " has");
			ArrayList<String> movies = new ArrayList<>();
			while (entry != null) {
				movies.add(entry.movieName);
				collution++;
				entry = entry.next;
			}
		
			System.out.println(getMovieList(movies));
			System.out.println((collution - 1) + " collisions");
		}
		return null;

	}

	private String getMovieList(ArrayList<String> movies) {
		String list = "";
		for (int i = movies.size() - 1; i >= 0; i--) {
			if (i != 0) {
				list = list + movies.get(i) + ", ";
			} else
				list = list + movies.get(i);
		}

		return list;
	}

	private int computehashValue(String mName) {
		int chVal = 0;
		for (int i = 0; i < mName.length(); i++) {
			if (i == 0)
				chVal += (int) mName.charAt(i);
			else
				chVal += (int) mName.charAt(i) * power(3, i);
			if (i == 5)
				break;
		}

		return chVal % TABLE_SIZE;
	}

	public static int power(int x, int n) {
		if (n == 0)
			return 1;
		else if (n % 2 == 0) {
			int y = power(x, n / 2);
			return y * y;
		} else {
			int y = power(x, (n - 1) / 2);
			return x * y * y;
		}
	}

}

public class MovieFlex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		MovieHT mh1 = new MovieHT();
		System.out.println("add movies to MovieFlex, enter \"!\" to terminate");
		String movie = sc.nextLine();
		while (!movie.contentEquals("!")) {
			String isexist = mh1.isExists(movie);
			if (isexist.contentEquals("MovieNoTExist"))
				mh1.insertMovie(movie, movie);
			movie = sc.nextLine();
		}
		mh1.showHashTableContents();
		sc.close();

	}

}

/*
 * Movie1 Movie2 Movie22 Movie3 Movie31 Movie1 Movie32 Movie4 Movie5 Movie3
 * Movie6 !
 */
