/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ppcc.treino.dao;

import com.ppcc.treino.entity.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pedro
 */
public class ClienteDao {

    public Boolean Insert(Cliente cliente) throws SQLException {
        PreparedStatement preparedStatement = null;
        Boolean sql = false;

        String insertSQL = "INSERT INTO cliente (name) VALUES (?)";

        try {
            preparedStatement = Conector.createConnection().prepareStatement(insertSQL);
            preparedStatement.setString(1, cliente.getName());
            preparedStatement.executeUpdate();
            sql = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (Conector.createConnection() != null) {
                Conector.createConnection().close();
            }
            return sql;
        }
    }

    public Boolean Update(Cliente cliente) throws SQLException {
        PreparedStatement preparedStatement = null;
        Boolean sql = false;

        String updateSql = "UPDATE cliente SET name=? WHERE id=?";

        try {
            preparedStatement = Conector.createConnection().prepareStatement(updateSql);
            preparedStatement.setString(1, cliente.getName());
            preparedStatement.setInt(2, cliente.getId());
            preparedStatement.executeUpdate();
            sql = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (Conector.createConnection() != null) {
                Conector.createConnection().close();
            }
            return sql;
        }
    }

    public Boolean Delete(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        Boolean sql = false;

        String deleteSQL = "DELETE from cliente where id = ?";

        try {
            preparedStatement = Conector.createConnection().prepareStatement(deleteSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            sql = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (Conector.createConnection() != null) {
                Conector.createConnection().close();
            }
            return sql;
        }
    }
    
    public List<Cliente> findAll() throws SQLException {

        PreparedStatement preparedStatement = null;

        String selectSQL = "SELECT id, name FROM cliente";

        List<Cliente> clientes = new ArrayList<>();
        
        try {
            preparedStatement = Conector.createConnection().prepareStatement(selectSQL);
            // execute select SQL stetement
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("ID"));
                cliente.setName(rs.getString("NAME"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (Conector.createConnection() != null) {
                Conector.createConnection().close();
            }
            return clientes;
        }
    }

    public List<Cliente> findById(Integer Id) throws SQLException {

        PreparedStatement preparedStatement = null;

        String selectSQL = "SELECT id, name FROM cliente WHERE id = ?";

        List<Cliente> clientes = new ArrayList<>();
        
        try {
            preparedStatement = Conector.createConnection().prepareStatement(selectSQL);
            preparedStatement.setInt(1, Id);

            // execute select SQL stetement
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("ID"));
                cliente.setName(rs.getString("NAME"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (Conector.createConnection() != null) {
                Conector.createConnection().close();
            }
            return clientes;
        }
    }

}
