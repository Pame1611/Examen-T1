package Clases;


import java.text.DecimalFormat;

public class Pedidos {

    public enum EstadoPedido {PENDIENTE, ATENDIDO, CANCELADO}

    private String codigo;
    private String descripcion;
    private double precioUnitario;
    private int cantidad;
    private EstadoPedido estado;

    public Pedidos() {
        this.codigo = "NO_COD_PEDIDO";
        this.descripcion = "";
        this.precioUnitario = 1.0;
        this.cantidad = 1;
        this.estado = EstadoPedido.PENDIENTE;
    }

    public Pedidos(String codigo, String descripcion, double precioUnitario, int cantidad, EstadoPedido estado) {
            
        setCodigo(codigo);
        setDescripcion(descripcion);
        setPrecioUnitario(precioUnitario);
        setCantidad(cantidad);
        setEstado(estado);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            System.err.println("El código del pedido no puede estar vacío.");
            this.codigo = "";
        } else {
            this.codigo = codigo.trim();
        }
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion == null ? "" : descripcion.trim();
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        if (precioUnitario <= 0) {
            System.err.println("El precio unitario debe ser mayor que cero.");
            this.precioUnitario = 1.0;
        } else {
            this.precioUnitario = precioUnitario;
        }
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad <= 0) {
            System.err.println("La cantidad debe ser mayor que cero.");
            this.cantidad = 1;
        } else {
            this.cantidad = cantidad;
        }
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        if (estado == null) {
            System.out.println("El estado del pedido no puede ser nulo.");
            this.estado = EstadoPedido.PENDIENTE;
        } else {
            this.estado = estado;
        }
    }

    public double calcularImporte() {
        return precioUnitario * cantidad;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return "Pedido: Codigo= " + codigo + 
        "Descripcion= " + descripcion + 
        "Precio unitario= " + df.format(precioUnitario)+ 
        "Cantidad= " + cantidad + 
        "Estado= " + estado + 
        "Importe= " + df.format(calcularImporte());
    }
}
