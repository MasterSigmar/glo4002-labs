package labs;

public class CommunityCenter extends BaseClinic {
  public CommunityCenter() {
    super();
  }

  public CommunityCenter(TriageType triageType) {
    super(triageType);
  }

  public void triagePatient(String name, int gravity) {
    super.triagePatient(name, gravity, null);
  }
}
