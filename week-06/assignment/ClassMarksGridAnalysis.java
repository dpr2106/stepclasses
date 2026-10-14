import java.util.*;

public class ClassMarksGridAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> names = new ArrayList<>();
        List<int[]> allMarks = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            
            int bracketStart = line.indexOf('[');
            int bracketEnd = line.indexOf(']');
            if (bracketStart == -1 || bracketEnd == -1) continue;

            String name = line.substring(0, bracketStart).trim();
            String numbers = line.substring(bracketStart + 1, bracketEnd);
            String[] parts = numbers.split(",");
            int[] marks = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                marks[i] = Integer.parseInt(parts[i].trim());
            }

            names.add(name);
            allMarks.add(marks);
        }
        sc.close();

        if (names.isEmpty()) return;

        int numStudents = names.size();
        int numSubjects = allMarks.get(0).length;

        // Calculate student totals and topper
        StringBuilder totalsBuilder = new StringBuilder("Totals ");
        int maxTotal = -1;
        String topperName = "";

        for (int i = 0; i < numStudents; i++) {
            int sum = 0;
            for (int mark : allMarks.get(i)) {
                sum += mark;
            }
            if (i > 0) totalsBuilder.append(", ");
            totalsBuilder.append(names.get(i)).append(" ").append(sum);

            if (sum > maxTotal) {
                maxTotal = sum;
                topperName = names.get(i);
            }
        }
        System.out.println(totalsBuilder.toString());

        // Calculate subject averages
        StringBuilder avgBuilder = new StringBuilder("averages ");
        for (int j = 0; j < numSubjects; j++) {
            double subjectSum = 0;
            for (int i = 0; i < numStudents; i++) {
                subjectSum += allMarks.get(i)[j];
            }
            double avg = subjectSum / numStudents;
            if (j > 0) avgBuilder.append(", ");
            avgBuilder.append(String.format(Locale.US, "%.2f", avg));
        }
        System.out.println(avgBuilder.toString());

        // Print topper
        System.out.println("topper " + topperName + " (" + maxTotal + ")");
    }
}
