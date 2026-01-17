package singleton;

import java.util.ArrayList;
import java.util.List;

/*
this approach provides the serialization machinery for free, and provides an ironclad guarantee against
multiple instantiation, even in the face of sophisticated serialization or reflection
attacks. 
 */
public enum ModernSingleton {

    INSTANCE;
    private String elvis;
    private List<String> songs = new ArrayList();


}
