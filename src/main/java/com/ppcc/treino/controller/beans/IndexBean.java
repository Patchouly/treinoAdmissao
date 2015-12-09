/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ppcc.treino.controller.beans;

import com.ppcc.treino.dao.ClienteDao;
import com.ppcc.treino.entity.Cliente;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author pedro
 */
@Named
@ViewScoped
public class IndexBean implements Serializable{
    
    private List<Cliente> clienteList;
    
    private Cliente editCliente;
    private Cliente insertCliente;
    
    private ClienteDao clienteDao;
    
    public void init(){
        if (!FacesContext.getCurrentInstance().isPostback()) {
            initGlobalVariables();
        }
    }
    
    public void deleteClientesById(int id){
        try {
            clienteDao.Delete(id);
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }
    
    private void findAllClientes() throws SQLException{
        clienteList = clienteDao.findAll();
    }
    
    private void initGlobalVariables(){
        clienteList = new ArrayList<>();
        clienteDao = new ClienteDao();
        insertCliente = new Cliente();
        editCliente = new Cliente();
        try {
            findAllClientes();
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }
    
    public void inserirCliente(){
        try {
            System.out.println("inserindo: "+insertCliente.getName());
            clienteDao.Insert(insertCliente);
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }
    
    public void editarCliente() {
        editCliente.setCanedit(Boolean.TRUE);
    }
    
    public void saveEditedCliente() {
        try {
            editCliente.setCanedit(Boolean.FALSE);
            clienteDao.Update(editCliente);
        } catch (SQLException ex) {
            Logger.getLogger(IndexBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    public Cliente getEditCliente() {
        return editCliente;
    }

    public void setEditCliente(Cliente editCliente) {
        this.editCliente = editCliente;
    }

    public Cliente getInsertCliente() {
        return insertCliente;
    }

    public void setInsertCliente(Cliente insertCliente) {
        this.insertCliente = insertCliente;
    }
    
}
