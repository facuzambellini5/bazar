package com.example.bazar.services;
import com.example.bazar.models.Cliente;

import java.util.List;

public interface IClienteService {

    public abstract void saveCliente(Cliente cliente);

    public abstract List<Cliente> getClientes();

    public abstract Cliente getClienteById(Long id_cliente);

    public abstract void deleteCliente(Long id_cliente);

    public abstract void editCliente(Cliente cliente);
}
