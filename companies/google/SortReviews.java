package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortReviews {

	public static void main(String[] args) {
		List<String> words = new ArrayList<>();
		words.addAll(Arrays.asList("hotel", "good", "condo", "food", "clean", "affordable", "dirty", "spacious", "cramped"));
		List<String> reviews = new ArrayList<>();
		reviews.addAll(Arrays.asList(
					"The hotel was good and afforable",
					"It was clean but cramped space",
					"The condo was very dirty",
					"This hotel is clean, good and spacious",
					"I found that space to be very afforable",
					"I won't stay in that dirty place again",
					"The food was really good"
				));
		
		List<String> result = sortReviews(reviews, words);
		System.out.println(result);
	}

	private static List<String> sortReviews(List<String> reviews, List<String> words) {
		
		List<Review> reviewList = new ArrayList<>();
		
		for(String review: reviews) {
			String[] parts = review.split(" ");
			int count = 0;
			for(String part: parts) {
				if(words.contains(part))
					count++;
			}
			reviewList.add(new Review(review, count));
		}
		
		reviewList.sort(new Comparator<Review>() {
			@Override
			public int compare(Review r1, Review r2) {
				if(r1.count > r2.count) return -1;
				else if(r1.count < r2.count) return 1;
				return 0;
			}
		});
		
		List<String> result = new ArrayList<>();
		for(Review r: reviewList) {
			result.add(r.review);
		}
		
		return result;
	}

}

class Review {
	String review;
	int count;
	
	Review(String review, int count) {
		this.review = review;
		this.count = count;
	}
}