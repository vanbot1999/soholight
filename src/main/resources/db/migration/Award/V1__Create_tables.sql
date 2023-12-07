USE soholight;
CREATE TABLE award (
   id INT AUTO_INCREMENT PRIMARY KEY,
   winnerName VARCHAR(255) NOT NULL,
   winnerBackground VARCHAR(255),
   winnerSpeech TEXT,
   winnerImage VARCHAR(255),
   category_id INT,
   FOREIGN KEY (category_id) REFERENCES award_category(category_id)
);
