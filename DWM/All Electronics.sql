-- ============================================================
-- AllElectronics Data Warehouse - Star Schema Implementation
-- ============================================================

-- Create Database
CREATE DATABASE IF NOT EXISTS AllElectronics_DW;
USE AllElectronics_DW;

-- ============================================================
-- Part (a): Creating Dimension Tables and Fact Table
-- ============================================================

-- 1. TIME Dimension Table
CREATE TABLE dim_time (
    time_key INT PRIMARY KEY AUTO_INCREMENT,
    date DATE NOT NULL,
    day INT NOT NULL,
    month INT NOT NULL,
    quarter INT NOT NULL,
    year INT NOT NULL,
    day_of_week VARCHAR(20),
    month_name VARCHAR(20)
);

-- 2. ITEM Dimension Table
CREATE TABLE dim_item (
    item_key INT PRIMARY KEY AUTO_INCREMENT,
    item_name VARCHAR(100) NOT NULL,
    brand VARCHAR(50),
    category VARCHAR(50),
    subcategory VARCHAR(50),
    supplier VARCHAR(100),
    unit_price DECIMAL(10,2)
);

-- 3. BRANCH Dimension Table
CREATE TABLE dim_branch (
    branch_key INT PRIMARY KEY AUTO_INCREMENT,
    branch_name VARCHAR(100) NOT NULL,
    branch_type VARCHAR(50),
    manager VARCHAR(100),
    city VARCHAR(100),
    state VARCHAR(100)
);

-- 4. LOCATION Dimension Table
CREATE TABLE dim_location (
    location_key INT PRIMARY KEY AUTO_INCREMENT,
    street VARCHAR(200),
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    country VARCHAR(100) NOT NULL,
    zip_code VARCHAR(20),
    region VARCHAR(50)
);

-- 5. FACT Table - Sales
CREATE TABLE fact_sales (
    sales_id INT PRIMARY KEY AUTO_INCREMENT,
    time_key INT NOT NULL,
    item_key INT NOT NULL,
    branch_key INT NOT NULL,
    location_key INT NOT NULL,
    dollars_sold DECIMAL(12,2) NOT NULL,
    units_sold INT NOT NULL,
    FOREIGN KEY (time_key) REFERENCES dim_time(time_key),
    FOREIGN KEY (item_key) REFERENCES dim_item(item_key),
    FOREIGN KEY (branch_key) REFERENCES dim_branch(branch_key),
    FOREIGN KEY (location_key) REFERENCES dim_location(location_key)
);

SHOW TABLES;

-- ============================================================
-- Part (b): Inserting Values into Dimension and Fact Tables
-- ============================================================

-- Insert data into TIME dimension
INSERT INTO dim_time (date, day, month, quarter, year, day_of_week, month_name) VALUES
('2024-01-15', 15, 1, 1, 2024, 'Monday', 'January'),
('2024-02-20', 20, 2, 1, 2024, 'Tuesday', 'February'),
('2024-03-10', 10, 3, 1, 2024, 'Sunday', 'March'),
('2024-04-05', 5, 4, 2, 2024, 'Friday', 'April'),
('2024-05-25', 25, 5, 2, 2024, 'Saturday', 'May'),
('2024-06-18', 18, 6, 2, 2024, 'Tuesday', 'June'),
('2024-07-12', 12, 7, 3, 2024, 'Friday', 'July'),
('2024-08-30', 30, 8, 3, 2024, 'Friday', 'August'),
('2024-09-22', 22, 9, 3, 2024, 'Sunday', 'September'),
('2024-10-14', 14, 10, 4, 2024, 'Monday', 'October');

-- Insert data into ITEM dimension
INSERT INTO dim_item (item_name, brand, category, subcategory, supplier, unit_price) VALUES
('LED TV 55"', 'Samsung', 'Electronics', 'Television', 'Samsung Electronics', 45000.00),
('Laptop Pro', 'Dell', 'Electronics', 'Computers', 'Dell India', 65000.00),
('Smartphone X', 'Apple', 'Electronics', 'Mobile', 'Apple Inc', 85000.00),
('Refrigerator', 'LG', 'Appliances', 'Kitchen', 'LG Electronics', 35000.00),
('Washing Machine', 'Whirlpool', 'Appliances', 'Laundry', 'Whirlpool India', 28000.00),
('Microwave Oven', 'Samsung', 'Appliances', 'Kitchen', 'Samsung Electronics', 12000.00),
('Gaming Console', 'Sony', 'Electronics', 'Gaming', 'Sony India', 42000.00),
('Tablet Pro', 'Apple', 'Electronics', 'Tablets', 'Apple Inc', 55000.00),
('Smart Watch', 'Samsung', 'Electronics', 'Wearables', 'Samsung Electronics', 18000.00),
('Air Conditioner', 'Daikin', 'Appliances', 'Cooling', 'Daikin India', 38000.00);

-- Insert data into BRANCH dimension
INSERT INTO dim_branch (branch_name, branch_type, manager, city, state) VALUES
('Mumbai Central', 'Flagship', 'Rajesh Kumar', 'Mumbai', 'Maharashtra'),
('Delhi South', 'Regional', 'Priya Sharma', 'Delhi', 'Delhi'),
('Bangalore Tech', 'Specialty', 'Arjun Reddy', 'Bangalore', 'Karnataka'),
('Chennai Express', 'Regional', 'Lakshmi Iyer', 'Chennai', 'Tamil Nadu'),
('Pune West', 'Standard', 'Amit Patil', 'Pune', 'Maharashtra'),
('Hyderabad Hub', 'Regional', 'Venkat Rao', 'Hyderabad', 'Telangana'),
('Kolkata East', 'Standard', 'Sourav Das', 'Kolkata', 'West Bengal'),
('Ahmedabad Mall', 'Flagship', 'Ravi Patel', 'Ahmedabad', 'Gujarat');

-- Insert data into LOCATION dimension
INSERT INTO dim_location (street, city, state, country, zip_code, region) VALUES
('MG Road', 'Mumbai', 'Maharashtra', 'India', '400001', 'West'),
('Connaught Place', 'Delhi', 'Delhi', 'India', '110001', 'North'),
('Brigade Road', 'Bangalore', 'Karnataka', 'India', '560001', 'South'),
('Anna Salai', 'Chennai', 'Tamil Nadu', 'India', '600002', 'South'),
('FC Road', 'Pune', 'Maharashtra', 'India', '411004', 'West'),
('Jubilee Hills', 'Hyderabad', 'Telangana', 'India', '500033', 'South'),
('Park Street', 'Kolkata', 'West Bengal', 'India', '700016', 'East'),
('CG Road', 'Ahmedabad', 'Gujarat', 'India', '380009', 'West');

-- Insert data into FACT table (Sales)
INSERT INTO fact_sales (time_key, item_key, branch_key, location_key, dollars_sold, units_sold) VALUES
(1, 1, 1, 1, 90000.00, 2),
(1, 2, 1, 1, 65000.00, 1),
(2, 3, 2, 2, 170000.00, 2),
(2, 4, 3, 3, 35000.00, 1),
(3, 5, 4, 4, 56000.00, 2),
(3, 6, 5, 5, 24000.00, 2),
(4, 7, 6, 6, 42000.00, 1),
(4, 8, 7, 7, 110000.00, 2),
(5, 9, 8, 8, 36000.00, 2),
(5, 10, 1, 1, 76000.00, 2),
(6, 1, 2, 2, 135000.00, 3),
(6, 2, 3, 3, 130000.00, 2),
(7, 3, 4, 4, 85000.00, 1),
(7, 4, 5, 5, 70000.00, 2),
(8, 5, 6, 6, 28000.00, 1),
(8, 6, 7, 7, 36000.00, 3),
(9, 7, 8, 8, 84000.00, 2),
(9, 8, 1, 1, 55000.00, 1),
(10, 9, 2, 2, 54000.00, 3),
(10, 10, 3, 3, 114000.00, 3);

-- ============================================================
-- Part (c): Displaying the Tables
-- ============================================================

-- Display TIME dimension
SELECT 'TIME DIMENSION TABLE' AS '';
SELECT * FROM dim_time;

-- Display ITEM dimension
SELECT 'ITEM DIMENSION TABLE' AS '';
SELECT * FROM dim_item;

-- Display BRANCH dimension
SELECT 'BRANCH DIMENSION TABLE' AS '';
SELECT * FROM dim_branch;

-- Display LOCATION dimension
SELECT 'LOCATION DIMENSION TABLE' AS '';
SELECT * FROM dim_location;

-- Display FACT table
SELECT 'FACT TABLE - SALES' AS '';
SELECT * FROM fact_sales;

-- Display joined view with all dimension details
SELECT 'COMPLETE SALES VIEW WITH ALL DIMENSIONS' AS '';
SELECT 
    f.sales_id,
    t.date,
    t.month_name,
    t.quarter,
    t.year,
    i.item_name,
    i.category,
    i.brand,
    b.branch_name,
    b.city AS branch_city,
    b.state AS branch_state,
    l.city AS location_city,
    l.state AS location_state,
    l.region,
    f.dollars_sold,
    f.units_sold
FROM fact_sales f
JOIN dim_time t ON f.time_key = t.time_key
JOIN dim_item i ON f.item_key = i.item_key
JOIN dim_branch b ON f.branch_key = b.branch_key
JOIN dim_location l ON f.location_key = l.location_key
ORDER BY f.sales_id;

-- ============================================================
-- Part (d): OLAP Operations - Roll-up and Drill-down
-- ============================================================

-- ========================================
-- 1. ROLL-UP Operations (Aggregation to Higher Level)
-- ========================================

-- Roll-up 1: From DAY level to MONTH level (Time Hierarchy)
SELECT 'ROLL-UP: Daily Sales to Monthly Sales' AS '';
SELECT 
    t.year,
    t.month,
    t.month_name,
    SUM(f.dollars_sold) AS total_sales,
    SUM(f.units_sold) AS total_units,
    COUNT(*) AS transaction_count
FROM fact_sales f
JOIN dim_time t ON f.time_key = t.time_key
GROUP BY t.year, t.month, t.month_name
ORDER BY t.year, t.month;

-- Roll-up 2: From MONTH level to QUARTER level
SELECT 'ROLL-UP: Monthly Sales to Quarterly Sales' AS '';
SELECT 
    t.year,
    t.quarter,
    CONCAT('Q', t.quarter) AS quarter_name,
    SUM(f.dollars_sold) AS total_sales,
    SUM(f.units_sold) AS total_units,
    COUNT(*) AS transaction_count
FROM fact_sales f
JOIN dim_time t ON f.time_key = t.time_key
GROUP BY t.year, t.quarter
ORDER BY t.year, t.quarter;

-- Roll-up 3: From QUARTER level to YEAR level
SELECT 'ROLL-UP: Quarterly Sales to Yearly Sales' AS '';
SELECT 
    t.year,
    SUM(f.dollars_sold) AS total_sales,
    SUM(f.units_sold) AS total_units,
    COUNT(*) AS transaction_count,
    AVG(f.dollars_sold) AS avg_transaction_value
FROM fact_sales f
JOIN dim_time t ON f.time_key = t.time_key
GROUP BY t.year
ORDER BY t.year;

-- Roll-up 4: From ITEM level to CATEGORY level (Product Hierarchy)
SELECT 'ROLL-UP: Item Sales to Category Sales' AS '';
SELECT 
    i.category,
    SUM(f.dollars_sold) AS total_sales,
    SUM(f.units_sold) AS total_units,
    COUNT(DISTINCT i.item_key) AS distinct_items,
    AVG(f.dollars_sold) AS avg_sales_per_transaction
FROM fact_sales f
JOIN dim_item i ON f.item_key = i.item_key
GROUP BY i.category
ORDER BY total_sales DESC;

-- Roll-up 5: From CITY level to STATE level (Location Hierarchy)
SELECT 'ROLL-UP: City Sales to State Sales' AS '';
SELECT 
    l.state,
    SUM(f.dollars_sold) AS total_sales,
    SUM(f.units_sold) AS total_units,
    COUNT(*) AS transaction_count,
    COUNT(DISTINCT l.city) AS cities_count
FROM fact_sales f
JOIN dim_location l ON f.location_key = l.location_key
GROUP BY l.state
ORDER BY total_sales DESC;

-- Roll-up 6: From STATE level to REGION level
SELECT 'ROLL-UP: State Sales to Region Sales' AS '';
SELECT 
    l.region,
    SUM(f.dollars_sold) AS total_sales,
    SUM(f.units_sold) AS total_units,
    COUNT(*) AS transaction_count,
    COUNT(DISTINCT l.state) AS states_count
FROM fact_sales f
JOIN dim_location l ON f.location_key = l.location_key
GROUP BY l.region
ORDER BY total_sales DESC;

-- ========================================
-- 2. DRILL-DOWN Operations (Going to Lower Level Detail)
-- ========================================

-- Drill-down 1: From YEARLY to QUARTERLY sales
SELECT 'DRILL-DOWN: Yearly Sales to Quarterly Breakdown' AS '';
SELECT 
    t.year,
    t.quarter,
    CONCAT('Q', t.quarter, ' ', t.year) AS period,
    SUM(f.dollars_sold) AS total_sales,
    SUM(f.units_sold) AS total_units,
    COUNT(*) AS transaction_count
FROM fact_sales f
JOIN dim_time t ON f.time_key = t.time_key
WHERE t.year = 2024  -- Focus on specific year
GROUP BY t.year, t.quarter
ORDER BY t.year, t.quarter;

-- Drill-down 2: From QUARTERLY to MONTHLY sales
SELECT 'DRILL-DOWN: Quarterly Sales to Monthly Breakdown (Q1 2024)' AS '';
SELECT 
    t.month,
    t.month_name,
    SUM(f.dollars_sold) AS total_sales,
    SUM(f.units_sold) AS total_units,
    COUNT(*) AS transaction_count
FROM fact_sales f
JOIN dim_time t ON f.time_key = t.time_key
WHERE t.year = 2024 AND t.quarter = 1  -- Focus on Q1
GROUP BY t.month, t.month_name
ORDER BY t.month;

-- Drill-down 3: From MONTHLY to DAILY sales
SELECT 'DRILL-DOWN: Monthly Sales to Daily Breakdown (January 2024)' AS '';
SELECT 
    t.date,
    t.day,
    t.day_of_week,
    SUM(f.dollars_sold) AS total_sales,
    SUM(f.units_sold) AS total_units,
    COUNT(*) AS transaction_count
FROM fact_sales f
JOIN dim_time t ON f.time_key = t.time_key
WHERE t.year = 2024 AND t.month = 1  -- Focus on January
GROUP BY t.date, t.day, t.day_of_week
ORDER BY t.date;

-- Drill-down 4: From CATEGORY to BRAND level
SELECT 'DRILL-DOWN: Category Sales to Brand Breakdown (Electronics)' AS '';
SELECT 
    i.category,
    i.brand,
    SUM(f.dollars_sold) AS total_sales,
    SUM(f.units_sold) AS total_units,
    COUNT(*) AS transaction_count
FROM fact_sales f
JOIN dim_item i ON f.item_key = i.item_key
WHERE i.category = 'Electronics'  -- Focus on Electronics
GROUP BY i.category, i.brand
ORDER BY total_sales DESC;

-- Drill-down 5: From BRAND to ITEM level
SELECT 'DRILL-DOWN: Brand Sales to Item Breakdown (Samsung)' AS '';
SELECT 
    i.brand,
    i.item_name,
    i.category,
    SUM(f.dollars_sold) AS total_sales,
    SUM(f.units_sold) AS total_units,
    COUNT(*) AS transaction_count,
    AVG(f.dollars_sold) AS avg_transaction_value
FROM fact_sales f
JOIN dim_item i ON f.item_key = i.item_key
WHERE i.brand = 'Samsung'  -- Focus on Samsung brand
GROUP BY i.brand, i.item_name, i.category
ORDER BY total_sales DESC;

-- Drill-down 6: From REGION to STATE level
SELECT 'DRILL-DOWN: Region Sales to State Breakdown (South Region)' AS '';
SELECT 
    l.region,
    l.state,
    SUM(f.dollars_sold) AS total_sales,
    SUM(f.units_sold) AS total_units,
    COUNT(*) AS transaction_count
FROM fact_sales f
JOIN dim_location l ON f.location_key = l.location_key
WHERE l.region = 'South'  -- Focus on South region
GROUP BY l.region, l.state
ORDER BY total_sales DESC;

-- Drill-down 7: From STATE to CITY level
SELECT 'DRILL-DOWN: State Sales to City Breakdown (Maharashtra)' AS '';
SELECT 
    l.state,
    l.city,
    SUM(f.dollars_sold) AS total_sales,
    SUM(f.units_sold) AS total_units,
    COUNT(*) AS transaction_count
FROM fact_sales f
JOIN dim_location l ON f.location_key = l.location_key
WHERE l.state = 'Maharashtra'  -- Focus on Maharashtra
GROUP BY l.state, l.city
ORDER BY total_sales DESC;

-- ========================================
-- 3. Additional OLAP Operations
-- ========================================

-- Combined Roll-up: Multi-dimensional aggregation
SELECT 'MULTI-DIMENSIONAL ROLL-UP: Sales by Quarter and Category' AS '';
SELECT 
    t.year,
    t.quarter,
    i.category,
    SUM(f.dollars_sold) AS total_sales,
    SUM(f.units_sold) AS total_units
FROM fact_sales f
JOIN dim_time t ON f.time_key = t.time_key
JOIN dim_item i ON f.item_key = i.item_key
GROUP BY t.year, t.quarter, i.category
ORDER BY t.year, t.quarter, total_sales DESC;

-- Summary Statistics
SELECT 'OVERALL SUMMARY STATISTICS' AS '';
SELECT 
    COUNT(*) AS total_transactions,
    SUM(dollars_sold) AS total_revenue,
    SUM(units_sold) AS total_units_sold,
    AVG(dollars_sold) AS avg_transaction_value,
    MAX(dollars_sold) AS max_transaction,
    MIN(dollars_sold) AS min_transaction
FROM fact_sales;

-- ============================================================
-- End of SQL Script
-- ============================================================