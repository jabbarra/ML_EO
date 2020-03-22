package ar.com.mleo.bean;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Informe {
    private String titulo;
    private List<Periodo> listaPeriodos;

    /**
     * @return the listaPeriodos
     */
    public List<Periodo> getListaPeriodos() {
        if (this.listaPeriodos == null) {
            this.listaPeriodos = new ArrayList<Periodo>();
        }
        return listaPeriodos;
    }

}
