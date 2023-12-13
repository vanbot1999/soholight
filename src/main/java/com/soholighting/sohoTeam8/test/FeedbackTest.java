package com.soholighting.sohoTeam8.test;

import com.soholighting.sohoTeam8.model.Feedback;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FeedbackTest {
    // Test the setters and getters of the Feedback class
    @Test
    void testFeedbackSettersAndGetters() {
        Feedback feedback = new Feedback();
        feedback.setUsername("Yifan");
        feedback.setEmail("getEmail@gmail.com");
        feedback.setMessage("getMessage");
        // Assert that the getters return the expected values after setting them
        assertEquals("Yifan", feedback.getUsername());
        assertEquals("getEmail@gmail.com", feedback.getEmail());
        assertEquals("getMessage", feedback.getMessage());
    }
    // Test the constructor with parameters of the Feedback class
    @Test
    void testFeedbackConstructor() {
        Feedback feedback = new Feedback("testFeedbackConstructor", "testFeedbackConstructor@testFeedbackConstructor.com", "testFeedbackConstructor");
        // Assert that the constructor correctly initializes the fields
        assertEquals("testFeedbackConstructor", feedback.getUsername());
        assertEquals("testFeedbackConstructor@testFeedbackConstructor.com", feedback.getEmail());
        assertEquals("testFeedbackConstructor", feedback.getMessage());
    }
    // Test the toString method of the Feedback class
    @Test
    void testToString() {
        Feedback feedback = new Feedback("TestToString", "TestToString@TestToString.com", "TestToString.");
        String expectedString = "Feedback{username='TestToString', email='TestToString@TestToString.com', message='TestToString.'}";
        // Assert that the toString method returns the correct string representation of the Feedback object
        assertEquals(expectedString, feedback.toString());
    }
}

