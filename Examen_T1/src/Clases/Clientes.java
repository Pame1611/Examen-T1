package Clases;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import Clases.Pedidos.EstadoPedido;

public class Clientes {
    private String codigo;
    private String nombre;
    private String correo;
    private List<Pedidos> pedidos;

    public Clientes(){
        this.codigo = "";
        this.nombre = "";
        this.correo = "";
        this.pedidos = new ArrayList<>();
    }

    public Clientes(String codigo, String nombre, String correo) {
        setCodigo(codigo);
        setNombre(nombre);
        setCorreo(correo);
        this.pedidos = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            System.err.println("El código del cliente no puede estar vacío.");
            this.codigo = "";
        } else {
            this.codigo = codigo.trim();
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre == null ? "" : nombre.trim();
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo == null ? "" : correo.trim();
    }

    public List<Pedidos> getPedidos() {
        return pedidos;
    }

    public void agregarPedido(Pedidos p) {
        if (p == null) {
            System.out.println("Pedido nulo no permitido.");
            return;
        }
        if (buscarPedidoPorCodigo(p.getCodigo()) != null) {
            System.out.println("Ya existe un pedido con el mismo código para este cliente.");
            return;
        }
        pedidos.add(p);
    }

    public Pedidos buscarPedidoPorCodigo(String codigoPedido) {
        if (codigoPedido == null) return null;
        for (Pedidos p : pedidos) {
            if (codigoPedido.equals(p.getCodigo())) return p;
        }
        return null;
    }

    public double importeTotalPedidos() {
        double total = 0.0;
        for (Pedidos p : pedidos) {
            total += p.calcularImporte();
        }
        return total;
    }

    public void cambiarEstadoPedido(String codigoPedido, EstadoPedido nuevoEstado) {
        Pedidos p = buscarPedidoPorCodigo(codigoPedido);
        if (p == null) {
            System.out.println("Pedido no encontrado.");
            return;
        }
        if (nuevoEstado == null) {
            System.out.println("Estado nuevo nulo.");
            return;
        }
        p.setEstado(nuevoEstado);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente: codigo= ").append(codigo).append(", nombre= ").append(nombre)
                .append(", correo= ").append(correo).append(", totalPedidos= ")
                .append(df.format(importeTotalPedidos())).append("\n");
        if (pedidos.isEmpty()) {
            sb.append("  (sin pedidos)\n");
        } else {
            for (Pedidos p : pedidos) {
                sb.append("  ").append(p.toString()).append("\n");
            }
        }
        return sb.toString();
    }
}
