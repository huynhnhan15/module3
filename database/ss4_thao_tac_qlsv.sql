CREATE DATABASE QuanLySinhVien4;
USE QuanLySinhVien4;

CREATE TABLE Class (
    ClassID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ClassName VARCHAR(60) NOT NULL,
    StartDate DATE NOT NULL,
    Status TINYINT(1) DEFAULT 1
);

CREATE TABLE Student (
    StudentId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    StudentName VARCHAR(30) NOT NULL,
    Address VARCHAR(50),
    Phone VARCHAR(20),
    Status TINYINT(1) DEFAULT 1,
    ClassId INT NOT NULL,
    FOREIGN KEY (ClassId) REFERENCES Class(ClassID) ON DELETE CASCADE
);

CREATE TABLE Subject (
    SubId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    SubName VARCHAR(30) NOT NULL,
    Credit TINYINT NOT NULL DEFAULT 1 CHECK (Credit >= 1),
    Status TINYINT(1) DEFAULT 1
);

CREATE TABLE Mark (
    MarkId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    SubId INT NOT NULL,
    StudentId INT NOT NULL,
    Mark FLOAT DEFAULT 0 CHECK (Mark BETWEEN 0 AND 10), -- Giới hạn điểm từ 0 - 10
    ExamTimes TINYINT DEFAULT 1,
    UNIQUE (SubId, StudentId),
    FOREIGN KEY (SubId) REFERENCES Subject(SubId) ON DELETE CASCADE,
    FOREIGN KEY (StudentId) REFERENCES Student(StudentId) ON DELETE CASCADE
);


INSERT INTO Class (ClassID, ClassName, StartDate, Status) VALUES
(1, 'A1', '2008-12-20', 1),
(2, 'A2', '2008-12-22', 1),
(3, 'B3', CURRENT_DATE, 0);

INSERT INTO Student (StudentName, Address, Phone, Status, ClassId) VALUES
('Hung', 'Ha Noi', '0912113113', 1, 1),
('Hoa', 'Hai Phong', NULL, 1, 1),
('Manh', 'HCM', '0123123123', 0, 2);

INSERT INTO Subject (SubId, SubName, Credit, Status) VALUES
(1, 'CF', 5, 1),
(2, 'C', 6, 1),
(3, 'HDJ', 5, 1),
(4, 'RDBMS', 10, 1);

INSERT INTO Mark (SubId, StudentId, Mark, ExamTimes) VALUES
(1, 1, 8, 1),
(1, 2, 10, 2),
(2, 1, 9, 1);

-- câu 1--
SELECT * 
FROM Subject 
WHERE Credit = (SELECT MAX(Credit) FROM Subject);

-- câu 2 
SELECT s.*
FROM Subject s
JOIN Mark m ON s.SubId = m.SubId
WHERE m.Mark = (SELECT MAX(Mark) FROM Mark);

-- câu 3
SELECT st.StudentId, st.StudentName, COALESCE(AVG(m.Mark), 0) AS AvgMark
FROM Student st
LEFT JOIN Mark m ON st.StudentId = m.StudentId
GROUP BY st.StudentId, st.StudentName
ORDER BY AvgMark DESC;


