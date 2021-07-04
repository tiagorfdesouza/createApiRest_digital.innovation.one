package creating.apirest.digital.innovation.CreateApiRest.listaunica;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {

    HOME("Home"),
    MOBILE("Mobile");

    private final String description;
}
