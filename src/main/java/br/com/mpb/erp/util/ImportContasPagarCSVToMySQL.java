package br.com.mpb.erp.util;

import com.opencsv.CSVReader;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Arrays;

public class ImportContasPagarCSVToMySQL {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/mpb";
        String username = "root";
        String password = System.getenv("DB_MYSQL_PASSWORD");

        String csvFilePath = "contas_pagar.csv";

        int batchSize = 20;

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            connection.setAutoCommit(false);

            String sql = "INSERT INTO contas_pagar (id, id_fornecedor, data_lancamento, numero_documento, " +
                    "data_documento, total_parcelas, valor_total, numero_parcela, valor_parcela, data_vencimento, " +
                    "liquidado, data_pagamento, valor_pago, data_inc, data_alt) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement statement = connection.prepareStatement(sql);
                 CSVReader reader = new CSVReader(
                         new InputStreamReader(new FileInputStream(csvFilePath), "ISO-8859-1"))) {

                String[] row;
                reader.readNext(); // pula cabeçalho

                int count = 0;
                while ((row = reader.readNext()) != null) {
                    System.out.println(Arrays.toString(row));

                    statement.setInt(1, Integer.parseInt(row[0])); // ID
                    statement.setInt(2, Integer.parseInt(row[1])); // ID_FORNECEDOR

                    statement.setDate(3, row[2].isBlank() ? null : java.sql.Date.valueOf(row[2])); // DATALANCAMENTO
                    statement.setString(4, row[3]); // NUMERODOCUMENTO
                    statement.setDate(5, row[4].isBlank() ? null : java.sql.Date.valueOf(row[4])); // DATADOCUMENTO

                    statement.setString(6, row[5]); // TOTALPARCELAS
                    statement.setBigDecimal(7, row[6].isBlank() ? null : new BigDecimal(row[6])); // VALORTOTAL
                    statement.setString(8, row[7]); // NUMEROPARCELA
                    statement.setBigDecimal(9, row[8].isBlank() ? null : new BigDecimal(row[8])); // VALORPARCELA
                    statement.setDate(10, row[9].isBlank() ? null : java.sql.Date.valueOf(row[9])); // DATAVENCIMENTO

                    statement.setString(11, row[10]); // LIQUIDADO
                    statement.setDate(12, row[11].isBlank() ? null : java.sql.Date.valueOf(row[11])); // DATAPAGAMENTO

                    statement.setBigDecimal(13, row[12].isBlank() ? null : new BigDecimal(row[12])); // VALORPAGO
                    statement.setDate(14, row[13].isBlank() ? null : java.sql.Date.valueOf(row[13])); // DATA_INC
                    statement.setDate(15, row[14].isBlank() ? null : java.sql.Date.valueOf(row[14])); // DATA_ALT

                    statement.addBatch();

                    if (++count % batchSize == 0) {
                        statement.executeBatch();
                    }
                }

                statement.executeBatch();
                connection.commit();

                System.out.println("Importação de Contas a Pagar Concluída!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
