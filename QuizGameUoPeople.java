import java.util.Scanner;

/**
 * QuizGameUoPeople
 *
 * A simple multiple-choice quiz (5 questions, A–D).
 * - Validates user input so only A/B/C/D are accepted.
 * - Uses if-statements for validation.
 * - Uses a switch-case to check correctness.
 * - Computes and prints the final score as a percentage.
 *
 * This program was written for a UoPeople assignment on basic control flow.
 */
public class QuizGameUoPeople {

    /**
     * Asks one question, validates input, evaluates with switch-case,
     * prints feedback, and returns 1 if correct, 0 otherwise.
     */
    private static int askQuestion(Scanner sc, String question, String[] choices, char correctChoice) {
        System.out.println(question);
        // Print choices labeled A–D
        char label = 'A';
        for (String c : choices) {
            System.out.println(label + ". " + c);
            label++;
        }

        // --- Input validation with if/while ---
        String input;
        while (true) {
            System.out.print("Enter your answer (A/B/C/D): ");
            input = sc.nextLine().trim().toUpperCase();

            // accept only single-letter A–D
            if (input.length() == 1 &&
                (input.charAt(0) == 'A' || input.charAt(0) == 'B' ||
                 input.charAt(0) == 'C' || input.charAt(0) == 'D')) {
                break;
            }
            System.out.println("Invalid input. Please type A, B, C, or D.");
        }

        char answer = input.charAt(0);

        // --- Correctness check with switch-case ---
        boolean isCorrect;
        switch (answer) {
            case 'A':
            case 'B':
            case 'C':
            case 'D':
                isCorrect = (answer == Character.toUpperCase(correctChoice));
                break;
            default:
                // This default will never be hit due to validation above,
                // but we keep it for defensive programming.
                isCorrect = false;
        }

        if (isCorrect) {
            System.out.println("Correct!\n");
            return 1;
        } else {
            System.out.println("Incorrect. The correct answer is " + correctChoice + ".\n");
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = 0;
        final int totalQuestions = 5;

        // Q1 — U.S. state capital
        score += askQuestion(
            sc,
            "Q1) What is the capital of California?",
            new String[] {"Sacramento", "Los Angeles", "San Diego", "San Jose"},
            'A'
        );

        // Q2 — Most populous country (as of 2025)
        score += askQuestion(
            sc,
            "Q2) As of 2025, which country has the largest population?",
            new String[] {"China", "India", "United States", "Indonesia"},
            'B'
        );

        // Q3 — Another U.S. state capital
        score += askQuestion(
            sc,
            "Q3) What is the capital of Texas?",
            new String[] {"Dallas", "Austin", "Houston", "San Antonio"},
            'B'
        );

        // Q4 — Japan
        score += askQuestion(
            sc,
            "Q4) Which is the highest mountain in Japan?",
            new String[] {"Mount Fuji", "Mount Takao", "Mount Haku", "Mount Aso"},
            'A'
        );

        // Q5 — UoPeople
        score += askQuestion(
            sc,
            "Q5) Which statement about University of the People (UoPeople) is true?",
            new String[] {
                "It is a fully online university.",
                "It has a traditional campus in California.",
                "It offers only in-person classes.",
                "It is a sports-only institution."
            },
            'A'
        );

        // --- Final results ---
        double percentage = (score * 100.0) / totalQuestions; // arithmetic ops for rubric
        System.out.println("You answered " + score + " out of " + totalQuestions + " correctly.");
        System.out.printf("Final score: %.1f%%\n", percentage);

        sc.close();
    }
}
