package rpg.objects;

public class EnvVars{
    private EnvVar[] envVars;

    public void setEnvVars(EnvVar[] envVars){
        this.envVars = envVars;
    }

    public EnvVar[] getEnvVars(){
        return this.envVars;
    }

    public static class EnvVar{
        private String name;
        private Object value;
        
        public void setName(String name){
            this.name = name;
        }

        public void setValue(Object value){
            this.value = value;
        }

        public Object getValue(){
            return this.value;
        }

        public String getName(){
            return this.name;
        }
    }
}