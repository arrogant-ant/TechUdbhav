package inc.iris.techudbhav.logic;

/**
 * Created by Sud on 4/6/18.
 */

public class Participant {
    private String name,roll,college,ph,email;

    public Participant() {
    }

    public Participant(String name, String roll, String college, String ph, String email) {
        this.name = name;
        this.roll = roll;
        this.college = college;
        this.ph = ph;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getRoll() {
        return roll;
    }

    public String getCollege() {
        return college;
    }

    public String getPh() {
        return ph;
    }

    public String getEmail() {
        return email;
    }
}
