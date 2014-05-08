import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import play.Application;
import play.GlobalSettings;
import play.db.jpa.JPA;
import play.libs.F.Callback0;
import play.libs.Yaml;
import cn.edu.sdu.b2cshop.system.commons.BaseModel;


public class Global extends GlobalSettings {

    @Override
    public void onStart(Application app) {
        InitialData.insert(app);
    }

    static class InitialData {
        public static void insert(Application app) {

            JPA.withTransaction(new Callback0() {
                @SuppressWarnings("unchecked")
                public void invoke() {

                    long categoryCount = (Long) JPA.em().createQuery("select count(*) from WareCategory").getSingleResult();

                    if(categoryCount == 0){
                        Map<String, List<Object>> all = (Map<String, List<Object>>) Yaml.load("initial-data.yml");
                        for (Map.Entry<String, List<Object>> entry : all.entrySet()) {
                            List<Object> list = entry.getValue();
                            if (list != null) {
                                for (BaseModel model : getModelFromList(list)) {
                                    JPA.em().persist(model);
                                }
                            }
                        }
                    }

                }
            });

        }
    }

    @SuppressWarnings("unchecked")
    private static <T extends BaseModel> List<T> getModelFromList(List<Object> objects) {
        if (objects == null) {
            return null;
        }
        List<T> models = new ArrayList<T>();
        for (Object object : objects) {
            T model = (T) object;
            models.add(model);
        }
        return models;
    }
}
