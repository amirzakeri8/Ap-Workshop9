# Multithreaded File Analysis

This Java project demonstrates how to use multithreading to analyze text files in a directory. Each file is processed in a separate thread to calculate various statistics, such as the count of unique words, the longest and shortest words, and the average word length.

## Features

- **Multithreading**: Uses `ExecutorService` to handle multiple files concurrently.
- **File Analysis**: Computes unique word count, longest word, shortest word, and average word length for each file.
- **ConsoleUI**: Simple console-based user interface to interact with the program.

## Project Structure

- **FileAnalysis**: Implements `Runnable` to read and process each file.
- **Results**: Collects and aggregates results from all threads.
- **ConsoleUI**: Provides a console-based user interface for the application.

## Requirements

- Java 8 or higher
