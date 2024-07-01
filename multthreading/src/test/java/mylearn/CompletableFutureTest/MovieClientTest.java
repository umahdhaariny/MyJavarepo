package mylearn.CompletableFutureTest;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;//used this
import org.springframework.web.reactive.function.client.WebClient;

import apiclient.Movieapi;
import learnjava.util.CommonUtil;

public class MovieClientTest {
	WebClient webclient = WebClient.builder().baseUrl("http://localhost:8080/movies").build();
	Movieapi movieclient = new Movieapi(webclient);
	
	@Test
	void retrieveMovie() {
		CommonUtil.startTimer();
		var movieInfoId = 1;
		var movie = movieclient.retreivMovie(1L);
		System.out.println(movie.getMovieInfo().getName());
		assertEquals("Batman Begins",movie.getMovieInfo().getName());
		
	}
	@Test
	void retrieveMovie_cf() {//test case for completable future
		var movieInfoId = 1;
		var movie = movieclient.retreivMovie_cf(1L).join();//join used to block the call
		System.out.println(movie.getMovieInfo().getName());
		assertEquals("Batman Begins",movie.getMovieInfo().getName());
		
	}
}
