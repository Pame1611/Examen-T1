/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejec_Sistema_Cafeteria;


public class Ejec_Sistema_Cafeteria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Demostración del sistema de gestión de pedidos de la cafetería\n");

        Clases.Clientes cliente = new Clases.Clientes("C001", "Juan Perez", "juan.perez@uni.edu");

        // Agregar pedidos
        Clases.Pedidos p1 = new Clases.Pedidos("P001", "Café Latte", 2.5, 2, Clases.Pedidos.EstadoPedido.PENDIENTE);
        Clases.Pedidos p2 = new Clases.Pedidos("P002", "Empanada", 1.75, 3, Clases.Pedidos.EstadoPedido.PENDIENTE);

        // Validar antes de agregar
        if (cliente.buscarPedidoPorCodigo(p1.getCodigo()) == null) {
            cliente.agregarPedido(p1);
            System.out.println("Pedido " + p1.getCodigo() + " agregado correctamente.");
        } else {
            System.out.println("No se agregó " + p1.getCodigo() + ": código duplicado.");
        }

        if (cliente.buscarPedidoPorCodigo(p2.getCodigo()) == null) {
            cliente.agregarPedido(p2);
            System.out.println("Pedido " + p2.getCodigo() + " agregado correctamente.");
        } else {
            System.out.println("No se agregó " + p2.getCodigo() + ": código duplicado.");
        }

        // Mostrar cliente y pedidos
        System.out.println(cliente.toString());

        // Calcular importe de un pedido (si existe)
        if (cliente.buscarPedidoPorCodigo("P001") != null) {
            System.out.println("Importe de P001: " + String.format("%.2f", p1.calcularImporte()));
        } else {
            System.out.println("Pedido P001 no encontrado para calcular importe.");
        }

        // Cambiar estado de un pedido (si existe)
        if (cliente.buscarPedidoPorCodigo("P001") != null) {
            cliente.cambiarEstadoPedido("P001", Clases.Pedidos.EstadoPedido.ATENDIDO);
            System.out.println("Después de atender P001:\n" + cliente.toString());
        } else {
            System.out.println("No se puede cambiar estado: P001 no existe.");
        }

        // Buscar pedido
        Clases.Pedidos buscado = cliente.buscarPedidoPorCodigo("P002");
        if (buscado != null) {
            System.out.println("Búsqueda P002: " + buscado.toString());
        } else {
            System.out.println("Búsqueda P002: No encontrado");
        }

        // Importe total
        System.out.println("Importe total del cliente: " + String.format("%.2f", cliente.importeTotalPedidos()));
    }
    
}
