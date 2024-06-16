package Backend.Social.Enums;

    public enum Sexo {
    
        MASCULINO("hombre"),
        FEMENINO("mujer");        
        private String sexo;
        
        Sexo(String sexo)
        {
            this.sexo=sexo;
        }
    
        public String getSexo(){
            return sexo;
        }
    }
