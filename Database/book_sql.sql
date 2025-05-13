CREATE TABLE IF NOT EXISTS Books (
  book_id SERIAL PRIMARY KEY,
  title VARCHAR(30),
  author VARCHAR(30),
  genre VARCHAR(30),
  price DECIMAL(10,2),
  stock_quantity INT
);

CREATE TABLE IF NOT EXISTS Customers (
  customer_id SERIAL PRIMARY KEY,
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  email VARCHAR(35),
  phone VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS Orders (
  order_id SERIAL PRIMARY KEY,
  customer_id INT,
  order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  total_amount DECIMAL(8,2),
  FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)
);

INSERT INTO Books (title, author, genre, price, stock_quantity) VALUES
('The Silent Patient', 'Alex Michaelides', 'Fiction', 20.00, 10),
('Atomic Habits', 'James Clear', 'Self-Help', 15.00, 30),
('1984', 'George Orwell', 'Fiction', 12.50, 30),
('Educated', 'Tara Westover', 'Biography', 18.00, 12),
('The Hobbit', 'J.R.R. Tolkien', 'Fantasy', 25.00, 15);

INSERT INTO Customers (first_name, last_name, email, phone) VALUES
('John', 'Doe', 'john.doe@example.com', '0790664321'),
('Emily', 'Johnson', 'emily.johnson@example.com', '078886432'),
('Michael', 'Wilson', 'michael.wilson@example.com', '098753217'),
('Sarah', 'Watson', 'sarah.watson@example.com', '079532176'),
('David', 'Anderson', 'david.anderson@example.com', '078883154');

INSERT INTO Orders (customer_id, total_amount) VALUES
(1, 20.00),
(2, 15.00),
(3, 12.50),
(4, 25.00),
(5, 18.00);

UPDATE Books
SET price = price + 5
WHERE title = 'The Silent Patient';

UPDATE Books
SET stock_quantity = 25
WHERE title = 'Atomic Habits';

DELETE FROM Customers
WHERE email = 'john.doe@example.com';

DELETE FROM Orders
WHERE order_id = 3;

SELECT * FROM Books
WHERE genre = 'Fiction';

SELECT * FROM Orders
WHERE total_amount > 50;

SELECT * FROM Customers
WHERE last_name ILIKE '%son%';
