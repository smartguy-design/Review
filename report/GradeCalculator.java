package sist.com.report;

public class GradeCalculator {

	String Subject;
	String grade;
	int credit;
	int totalCredit;
	double score;
	double totalScore;
	double avg;

	public GradeCalculator() {
	}

	public GradeCalculator(String subject, String grade, int credit, int totalCredit, double score, double totalScore,
			double avg) {
		super();
		Subject = subject;
		this.grade = grade;
		this.credit = credit;
		this.totalCredit = totalCredit;
		this.score = score;
		this.totalScore = totalScore;
		this.avg = avg;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getTotalCredit() {
		return totalCredit;
	}

	public void setTotalCredit(int totalCredit) {
		this.totalCredit = totalCredit;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public double getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(double totalScore) {
		this.totalScore = totalScore;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	/*
	 * @Override public String toString() { return "GradeCalculator [Subject=" +
	 * Subject + ", grade=" + grade + ", credit=" + credit + ", score=" + score +
	 * ", avg=" + avg + "]"+"\n Average="+avg; }
	 */
	@Override
	public String toString() {
		return "GradeCalculator [Subject=" + Subject + ", grade=" + grade + ", credit=" + credit + ", score=" + score
				+ ", totalScore=" + totalScore + ", avg=" + avg + "]";
	}

}
