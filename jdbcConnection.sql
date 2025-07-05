-- Create the Employee table

USE college;
CREATE TABLE Employee (
    EmployeeID INT PRIMARY KEY AUTO_INCREMENT,  -- For MySQL; use SERIAL in PostgreSQL
    Name VARCHAR(100),
    Mobile VARCHAR(15),
    Salary DECIMAL(10, 2)
);

-- Insert sample data
INSERT INTO Employee (Name, Mobile, Salary) VALUES
('Nidhi', '9876543210', 50000.00),
('ABC' , '9123456789', 60000.00),
('XYZ', '9012345678', 55000.00),
('PQR', '9988776655', 62000.50),
('RST', '9876501234', 58000.75);

select * from employee;