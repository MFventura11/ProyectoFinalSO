package entidades;

public class Pagina {
    
    private Proceso proceso;
    private int num_pagina;
    private int tamanio;

    public Pagina(Proceso proceso, int num_pagina, int tamanio) {
        this.proceso = proceso;
        this.num_pagina = num_pagina;
        this.tamanio = tamanio;
    }

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    public int getNum_pagina() {
        return num_pagina;
    }

    public void setNum_pagina(int num_pagina) {
        this.num_pagina = num_pagina;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

}
