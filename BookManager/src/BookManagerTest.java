import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class BookManagerTest {
	
	private BookManager bookManager;

	@BeforeEach
	void setUp() throws Exception {
		bookManager = new BookManager();
	}

	@Test
	void testAddBook() {
		BookManager.Book testBook =  new BookManager.Book("1", "자바 기초", "Jane", 2021);
		bookManager.AddBook("1", "자바 기초", "Jane", 2021);
		
		ArrayList<BookManager.Book> books = bookManager.getBooks();
		assertEquals(testBook, books.get(0));
	}

	@Test
	void testSearchBook() {
		bookManager.SearchBook("1");
	}

	@Test
	void testRemoveBook() {
		fail("Not yet implemented");
	}

}
