CREATE DATABASE bai_thi_module3;
USE bai_thi_module3;

CREATE TABLE book (
    book_id VARCHAR(20) PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL,
    description TEXT,
    quantity INT NOT NULL
);

CREATE TABLE student (
    student_id VARCHAR(20) PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    class VARCHAR(20) NOT NULL
);

CREATE TABLE borrow_card (
    borrow_id VARCHAR(20) PRIMARY KEY CHECK (borrow_id REGEXP '^MS-[0-9]{4}$'),
    book_id VARCHAR(20) NOT NULL,
    student_id VARCHAR(20) NOT NULL,
    status BOOLEAN NOT NULL DEFAULT TRUE,
    borrow_date DATE NOT NULL,
    return_date DATE NOT NULL,
    FOREIGN KEY (book_id) REFERENCES book(book_id),
    FOREIGN KEY (student_id) REFERENCES student(student_id),
    CONSTRAINT check_return_date CHECK (return_date >= borrow_date)
);