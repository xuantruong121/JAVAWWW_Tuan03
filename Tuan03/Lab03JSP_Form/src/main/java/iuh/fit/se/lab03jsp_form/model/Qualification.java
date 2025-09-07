package iuh.fit.se.lab03jsp_form.model;

public class Qualification {
    private String examination;   // Class X, Class XII, Graduation, Masters
    private String board;
    private double percentage;
    private int yearOfPassing;

    public Qualification() {}

    public Qualification(String examination, String board, double percentage, int yearOfPassing) {
        this.examination = examination;
        this.board = board;
        this.percentage = percentage;
        this.yearOfPassing = yearOfPassing;
    }

    public String getExamination() { return examination; }
    public void setExamination(String examination) { this.examination = examination; }

    public String getBoard() { return board; }
    public void setBoard(String board) { this.board = board; }

    public double getPercentage() { return percentage; }
    public void setPercentage(double percentage) { this.percentage = percentage; }

    public int getYearOfPassing() { return yearOfPassing; }
    public void setYearOfPassing(int yearOfPassing) { this.yearOfPassing = yearOfPassing; }
}
