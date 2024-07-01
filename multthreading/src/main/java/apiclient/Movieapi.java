package apiclient;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import learnjava.domain.movie.Review;
import learnjava.domain.movie.Movie;
import learnjava.domain.movie.MovieInfo;

public class Movieapi {
	//add the webclient dependency
	private final WebClient webclient ;
	
	//use constructor injection to inject webclient 

	public Movieapi(WebClient webclient) {
		super();
		this.webclient = webclient;
	}
	
//	public Movie retrieveMovie(Long movieid ) {
//		
//		invokeMovieInfo(movieid);
//		return null;
//		
//	}
	public CompletableFuture<Movie> retreivMovie_cf(Long movieid) {
		var  movieInfo = CompletableFuture.supplyAsync(()->invokeMovieInfo(movieid));
				
		var reviewinfo = CompletableFuture.supplyAsync(()->invokeReviewInfo(movieid));
				
				//invokeReviewInfo(movieid);
		return movieInfo.thenCombine(reviewinfo,(mi,ri)->{
			return new Movie(mi,ri);
		});
	}
	
	public Movie retreivMovie(Long movieid) {
		var  movieInfo = invokeMovieInfo(movieid);
		var reviewinfo = invokeReviewInfo(movieid);
		return new Movie(movieInfo,reviewinfo);
	}
	public List<Movie> retreivMovieList_future(List<Long> movieidlist) {
		var movieFutures= movieidlist.stream().map(this::retreivMovie_cf).collect(Collectors.toList());
		return movieFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
	}

	public List<Movie> retreivMovieList(List<Long> movieidlist) {
		return movieidlist.stream().map(this::retreivMovie).collect(Collectors.toList());
	}
	private List<Review> invokeReviewInfo(Long movieInfoId) {
		// TODO Auto-generated method stub
		//var movieinfourl="/v1/reviews?movieInfo}";
		//we need to build wiht queryparams , we have to do this in diff way ,uricomponenet accepts request param as input
		var reviewuri = UriComponentsBuilder.fromUriString("/v1/reviews")
			.queryParam("movieInfoId",movieInfoId)
			.buildAndExpand().toString();
		 //Here we need to use bodytoFlux as we are expecting more than one value 
		return webclient.get().uri(reviewuri).retrieve().bodyToFlux(Review.class).collectList().block();
				
		
	}
	private MovieInfo invokeMovieInfo(Long movieid) {
		// TODO Auto-generated method stub
		var movieinfourl="/v1/movie_infos/{movieid}";
		//get() function is use as its just a select call methods ,
		//retrieve funtion is going to make api call ,
		//after that bodyToMono is used for single object  ,for multi use bodytoflux
		//block will block the call until a value is returned 
		return webclient.get().uri(movieinfourl,movieid).retrieve().bodyToMono(MovieInfo.class).block();
		
	}
	
	
	
	
	
}
