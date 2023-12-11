USE soholight;
CREATE TABLE award (
   id INT AUTO_INCREMENT PRIMARY KEY,
   winnerName VARCHAR(255),
   winnerBackground VARCHAR(255),
   winnerSpeech TEXT,
   winnerImage VARCHAR(255),
   category_id INT,
   FOREIGN KEY (category_id) REFERENCES award_category(category_id)
);

ALTER TABLE award
    MODIFY winnerName VARCHAR(255) DEFAULT 'Unknown',
    MODIFY winnerBackground VARCHAR(255) DEFAULT 'Unknown',
    MODIFY winnerSpeech TEXT DEFAULT 'Unknown';
