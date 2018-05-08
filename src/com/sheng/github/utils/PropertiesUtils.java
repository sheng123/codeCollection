import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 *用这个类来读取配置文件的信息，properties中的信息
 * 配置信息写在***.properties文件中，以key value的形式存在，然后创建PropertiesConfiguration实例
 *  private static final String CLUSTER = pc.getString("cluster");
 *  这种方式来读取配置文件中的信息
 */
public class PropertiesUtils {

    private PropertiesUtils(){

    }

    private static class InnerClassHolder {
        private static PropertiesConfiguration pc = init();

        private static PropertiesConfiguration init() {
            PropertiesConfiguration pc = new PropertiesConfiguration();
            pc.setEncoding("utf8");
            try {
                pc.load("***.properties");
            } catch (ConfigurationException e) {
                e.printStackTrace();
            }
            return pc;
        }
    }

    public static PropertiesConfiguration getInstance(){
        return InnerClassHolder.pc;
    }

}