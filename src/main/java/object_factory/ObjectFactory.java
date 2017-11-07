package object_factory;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;


public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig();
    private List<ObjectConfigurator> objectConfigurators = new ArrayList<>();


    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    @SneakyThrows
    private ObjectFactory() {
//        If we have a lot of configurators, using reflection looks better
        objectConfigurators.add(new InjectRandomIntConfigurator());
//        Reflections scanner = new Reflections("object_factory");
//        Set<Class<? extends ObjectConfigurator>> classes = scanner.getSubTypesOf(ObjectConfigurator.class);
//        for (Class<? extends ObjectConfigurator> aClass : classes) {
//            if (!Modifier.isAbstract(aClass.getModifiers())) {
//                objectConfigurators.add(aClass.newInstance());
//            }
//        }
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        if (type.isInterface()) {
           type =  config.getImpl(type);
        }
        T o = type.newInstance();

        for (ObjectConfigurator objectConfigurator : objectConfigurators) {
            objectConfigurator.configure(type, o);
        }

        return o;
    }
}
