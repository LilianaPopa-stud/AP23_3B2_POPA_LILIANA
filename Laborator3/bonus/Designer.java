package bonus;

import java.util.Arrays;

/**
 * A class that represents a designer
 * @author Popa Liliana
 */
public class Designer extends Person {

    private int yearsOfExperience;
    private Specialty[] specialties;

    public Designer(String name, int age) {
        super(name,age);
        this.yearsOfExperience = 0;
    }

    /**
     * a constructor that initializes the name, years of experience and the specialties of the designer with the values passed as parameters
     * @param name the name of the designer
     * @param yearsOfExperience the years of experience of the designer
     * @param specialties the specialties of the designer
     */

    public Designer(String name,int age, int yearsOfExperience, Specialty[] specialties) {
        super(name,age);
        this.yearsOfExperience = yearsOfExperience;
        this.specialties = specialties;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public Specialty[] getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Specialty[] specialties) {
        this.specialties = specialties;
    }

    @Override
    public String toString() {
        return "Designer{" +
                "name='" + getName() +
                ", age=" + getAge() +
                ", yearsOfExperience=" + yearsOfExperience +
                ", specialties=" + Arrays.toString(specialties) +
                '}'+'\n';
    }
}
