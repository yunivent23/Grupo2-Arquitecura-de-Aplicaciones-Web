package upc.edu.pe.apileadyourway.dtos;

public class BicicletaCardDTO {
    private int idBicicleta;
    private String tipoBicicleta;
    private String marcaBicicleta;
    private String colorBicicleta;
    private double precioBicicleta;
    private boolean disponible;
    private String fotoBicicleta;


    public String getFotoBicicleta() {
        return fotoBicicleta;
    }

    public void setFotoBicicleta(String fotoBicicleta) {
        this.fotoBicicleta = fotoBicicleta;
    }

    public int getIdBicicleta() {
        return idBicicleta;
    }

    public void setIdBicicleta(int idBicicleta) {
        this.idBicicleta = idBicicleta;
    }

    public String getTipoBicicleta() {
        return tipoBicicleta;
    }

    public void setTipoBicicleta(String tipoBicicleta) {
        this.tipoBicicleta = tipoBicicleta;
    }

    public String getMarcaBicicleta() {
        return marcaBicicleta;
    }

    public void setMarcaBicicleta(String marcaBicicleta) {
        this.marcaBicicleta = marcaBicicleta;
    }

    public String getColorBicicleta() {
        return colorBicicleta;
    }

    public void setColorBicicleta(String colorBicicleta) {
        this.colorBicicleta = colorBicicleta;
    }

    public double getPrecioBicicleta() {
        return precioBicicleta;
    }

    public void setPrecioBicicleta(double precioBicicleta) {
        this.precioBicicleta = precioBicicleta;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
