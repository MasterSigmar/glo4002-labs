package labs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommunityCenterTest {

  @Test
  void triagePatient_GivenPatient_WhenCalled_ShouldAddPatient() {
      // Initialize
      CommunityCenter communityCenter = new CommunityCenter();
      String name = "name";

      // Act
      communityCenter.triagePatient(name, 3);
      boolean actual = communityCenter.isInMedicList(name);

      // Assert
      assertTrue(actual);
  }
}