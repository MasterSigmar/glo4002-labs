package labs;


import java.util.ArrayList;
import java.util.List;

public class Clinic {
    public List<String> medicPatientNames = new ArrayList<String>();
    public List<String> radiologyPatientNames = new ArrayList<String>();

    public Clinic() {
    }

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        medicPatientNames.add(name);

        if (visibleSymptom == VisibleSymptom.BROKEN_BONE || visibleSymptom == VisibleSymptom.SPRAIN)
            radiologyPatientNames.add(name);

    }

    public List<String> getMedicPatientNames() {
        return medicPatientNames;
    }

    public List<String> getRadiologyPatientNames() {
        return radiologyPatientNames;
    }
}
