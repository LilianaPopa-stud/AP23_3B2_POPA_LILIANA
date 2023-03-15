package homework;

import java.util.Arrays;

/**
 * A class that represents a programmer
 * It extends the Person class
 * @author Popa Liliana
 */
public class Programmer extends Person{

    private String[] programmingLanguages;
    private SoftwareDevelopmentMethodology softwareDevelopmentMethodology;
    private boolean isAvailable;


    public Programmer(String name,int age) {
        super(name,age);
    }

    public Programmer(String name,int age, boolean isAvailable) {
        super(name,age);
        this.isAvailable = isAvailable;
    }

    public Programmer(String name,int age, String[] programmingLanguages) {
        super(name,age);
        this.programmingLanguages = programmingLanguages;
    }

    /**
     * a constructor that initializes the name, programming languages, software development methodology and the availability of the programmer with the values passed as parameters
     * @param name the name of the programmer
     * @param programmingLanguages the programming languages of the programmer
     * @param softwareDevelopmentMethodology the software development methodology of the programmer
     * @param isAvailable the availability of the programmer
     */
    public Programmer(String name,int age, String[] programmingLanguages, SoftwareDevelopmentMethodology softwareDevelopmentMethodology, boolean isAvailable) {
        super(name,age);
        this.programmingLanguages = programmingLanguages;
        this.softwareDevelopmentMethodology = softwareDevelopmentMethodology;
        this.isAvailable = isAvailable;
    }

    public String[] getProgrammingLanguages() {
        return programmingLanguages;
    }

    public void setProgrammingLanguages(String[] programmingLanguages) {
        this.programmingLanguages = programmingLanguages;
    }

    public SoftwareDevelopmentMethodology getSoftwareDevelopmentMethodology() {
        return softwareDevelopmentMethodology;
    }

    public void setSoftwareDevelopmentMethodology(SoftwareDevelopmentMethodology softwareDevelopmentMethodology) {
        this.softwareDevelopmentMethodology = softwareDevelopmentMethodology;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override    public String toString() {
        return "Programmer{" +
                "Name=" + getName() +
                ", Age=" + getAge() +
                ", programmingLanguages=" + Arrays.toString(programmingLanguages) +
                ", softwareDevelopmentMethodology=" + softwareDevelopmentMethodology +
                ", isAvailable=" + isAvailable +
                '}'+'\n';
    }

}
