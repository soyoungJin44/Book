package com.javaex.book;

public class Book2Vo {
		//필드
		
		private int bookId;
		private String title;
		private String pubs;
		private String pubDate;
		private int authorId;
		private String name; // 작가이름
		private String desc;
		
		
		//생성자
		public Book2Vo() {
			super();
		}
		
		public Book2Vo(int bookId, String title, String pubs, String pubDate, int authorId, String name, String desc) {
			super();
			this.bookId = bookId;
			this.title = title;
			this.pubs = pubs;
			this.pubDate = pubDate;
			this.authorId = authorId;
			this.name = name;
			this.desc = desc;
		}
		//메서드 gs

		public int getBookId() {
			return bookId;
		}

		public void setBookId(int bookId) {
			this.bookId = bookId;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getPubs() {
			return pubs;
		}

		public void setPubs(String pubs) {
			this.pubs = pubs;
		}

		public String getPubDate() {
			return pubDate;
		}

		public void setPubDate(String pubDate) {
			this.pubDate = pubDate;
		}

		public int getAuthorId() {
			return authorId;
		}

		public void setAuthorId(int authorId) {
			this.authorId = authorId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		
		//메서드 일반

		@Override
		public String toString() {
			return "Book2Vo [bookId=" + bookId + ", title=" + title + ", pubs=" + pubs + ", pubDate=" + pubDate
					+ ", authorId=" + authorId + ", name=" + name + ", desc=" + desc + "]";
		}

}
