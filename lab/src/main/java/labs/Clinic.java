package labs;


public class Clinic extends BaseClinic{

    public Clinic(){
        super();
    }

    public Clinic(TriageType triageType) {
        super(triageType);
    }

  public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
      super.triagePatient(name, gravity, visibleSymptom);
  }
}
