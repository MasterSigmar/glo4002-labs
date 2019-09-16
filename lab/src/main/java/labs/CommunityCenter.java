package labs;

public class CommunityCenter extends BaseClinic {
  public CommunityCenter() {
  }

  public CommunityCenter(TriageType triageType) {
    set_triageType(triageType);
  }

  public void triagePatient(String name, int gravity) {
    super.triagePatient(name, gravity, null);
  }
}
