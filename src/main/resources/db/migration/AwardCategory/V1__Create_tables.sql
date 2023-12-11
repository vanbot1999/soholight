USE soholight;
CREATE TABLE award_category (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    category_title VARCHAR(255) NOT NULL,
    year_id INT,
    FOREIGN KEY (year_id) REFERENCES yearly_awards(year_id)
);
