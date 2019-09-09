package labs;


import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private List<String> medicPatientNames = new ArrayList<String>();
    private List<String> radiologyPatientNames = new ArrayList<String>();

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
    public String getFirstMedicPatientName() {
        return medicPatientNames.get(0);
    }
    public String getLastMedicPatientName() {
        int indexOfLastItem = medicPatientNames.size() - 1;
        return medicPatientNames.get(indexOfLastItem);
    }

    public List<String> getRadiologyPatientNames() {
        return radiologyPatientNames;
    }
    public String getFirstRadiologyPatientName() {
        return radiologyPatientNames.get(0);
    }
    public String getLastRadiologyPatientName() {
        int indexOfLastItem = radiologyPatientNames.size() - 1;
        return radiologyPatientNames.get(indexOfLastItem);
    }
}
