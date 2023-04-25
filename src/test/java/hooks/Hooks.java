package hooks;



import io.cucumber.java.Before;

import static base_urls.MedunnaBaseUrl.medunnaSetUp;

public class Hooks {

    @Before()
    public void beforeApi(){
        medunnaSetUp();
    }

}