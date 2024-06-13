import java.util.ArrayList;

public class BookManager {
	
	// book 클래스
	public static class Book {
		private String id;
		private String title;
		private String author;
		private int year;
		
		public Book(String id, String title, String author, int year) {
			this.id = id;
			this.title= title;
			this.author = author;
			this.year = year;
		}
		
		public String GetId() {
			return id;
		}
		
		public String GetBookInfo() {
			String info = String.format("Book{id: %s, 제목: %s, 저자: %s, 출판년도: %d}도서", id, title, author, year);
			return info;
		}
	}
	
	// bookmanager 클래스
	private ArrayList<Book> books = new ArrayList<>();
	
	public void AddBook(String id, String title, String author, int year) {
		// 추가하려는 도서 id가 이미 존재하는 id인지 확인
		for (int i = 0; i < books.size(); i++) {
		    Book book = books.get(i);
		    if(book.GetId() == id) {
		    	// 이미 있는 id이면, 경고문 보내기
		    	String alertinfo = String.format("해당 ID(%s)는 이미 존재합니다.\n", id);
		    	System.out.println(alertinfo);
		    	break;
		    }
		}
		
		//기존에 없던 id이면 books에 추가하고, 추가했다는 안내문 보내기
		Book newBook = new Book(id, title, author, year);
		books.add(newBook);
		String addinfo = newBook.GetBookInfo() + "가 추가되었습니다.\n";
		System.out.println(addinfo);
	}
	
	// 저장된 책 목록을 반환하는 메서드 (테스트용)
    public ArrayList<Book> getBooks() {
        return books;
    }
	
	public void SearchBook(String id) {
		// 찾고자하는 도서 id로 books 검색
		for (int i = 0; i < books.size(); i++) {
		    Book book = books.get(i);
		    if(book.GetId() == id) {
		    	// 도서가 존재하는 경우
		    	// 도서 정보 출력
		    	System.out.println(book.GetBookInfo() + "\n");
		    	break;
		    }
		}
		
		//도서가 존재하지 않는 경우
		System.out.println("검색된 도서가 없습니다.\n");
	}
	
	public void RemoveBook(String id) {
		// 지우고자 하는 도서 id를 바탕으로 books 검색
		for (int i = 0; i < books.size(); i++) {
			Book book = books.get(i);
			if(book.GetId() == id) {
				String addinfo = book.GetBookInfo() + "를 삭제하였습니다.\n";
				System.out.println(addinfo);
				books.remove(book);
			}
		}
		
		//도서가 존재하지 않는 경우
		String alertinfo = String.format("해당 ID(%s)의 도서를 찾을 수 없습니다.\n", id);
    	System.out.println(alertinfo);
	}
}
