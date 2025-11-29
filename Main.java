import java.util.ArrayList;
import java.util.List;

class Candidate {
    String name;
    boolean passedHR = false;
    boolean passedTech = false;

    Candidate(String name) { this.name = name; }
}

class HiringProcess {
    List<Candidate> candidates = new ArrayList<>();

    void createVacancy() {
        System.out.println("Руководитель создал заявку на вакансию.");
    }

    boolean checkVacancy(boolean valid) {
        if(valid) {
            System.out.println("HR утвердил заявку.");
            return true;
        } else {
            System.out.println("Заявка требует доработки.");
            return false;
        }
    }

    void receiveApplications(String... names) {
        for(String name : names) {
            candidates.add(new Candidate(name));
            System.out.println("Кандидат подал заявку: " + name);
        }
    }

    void screenCandidates() {
        for(Candidate c : candidates) {
            c.passedHR = Math.random() > 0.3; // случайный фильтр
            System.out.println(c.name + " прошел HR: " + c.passedHR);
        }
    }

    void conductInterviews() {
        for(Candidate c : candidates) {
            if(c.passedHR) {
                c.passedTech = Math.random() > 0.3;
                System.out.println(c.name + " прошел техническое собеседование: " + c.passedTech);
                if(c.passedTech) {
                    System.out.println(c.name + " получил оффер.");
                } else {
                    System.out.println(c.name + " получил отказ.");
                }
            }
        }
    }

    void finalizeHiring() {
        for(Candidate c : candidates) {
            if(c.passedHR && c.passedTech) {
                System.out.println(c.name + " добавлен в базу сотрудников.");
            }
        }
        System.out.println("HR уведомил IT-отдел о настройке рабочего места.");
    }
}

public class Main {
    public static void main(String[] args) {
        HiringProcess process = new HiringProcess();
        process.createVacancy();
        if(process.checkVacancy(true)) {
            process.receiveApplications("Аня", "Борис", "Виктор");
            process.screenCandidates();
            process.conductInterviews();
            process.finalizeHiring();
        }
    }
}