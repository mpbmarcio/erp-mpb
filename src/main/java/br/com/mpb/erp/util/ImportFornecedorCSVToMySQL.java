package br.com.mpb.erp.util;

import com.opencsv.CSVReader;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ImportFornecedorCSVToMySQL {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/mpb";
        String username = "root";
        String password = System.getenv("DB_MYSQL_PASSWORD");

        String csvFilePath = "fornecedor.csv";

        int batchSize = 20;

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            connection.setAutoCommit(false);

            String sql = "INSERT INTO fornecedores (id, data_inc, data_alt, nome, cnpj, ie, cep, nome_rua, num_rua, " +
                    "bairro, cidade_uf, telefone, cel, contato, email, www) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement statement = connection.prepareStatement(sql);
                 CSVReader reader = new CSVReader(
                         new InputStreamReader(new FileInputStream(csvFilePath), "ISO-8859-1"))) {

                String[] row;
                reader.readNext(); // pula cabeçalho

                int count = 0;
                while ((row = reader.readNext()) != null) {
                    statement.setInt(1, Integer.parseInt(row[0])); // ID

                    statement.setDate(2, row[1].isBlank() ? null : java.sql.Date.valueOf(row[1])); // DATA_INC
                    statement.setDate(3, row[2].isBlank() ? null : java.sql.Date.valueOf(row[2])); // DATA_ALT

                    statement.setString(4, row[3]); // NOME
                    statement.setString(5, row[4]); // CNPJ
                    statement.setString(6, row[5]); // IE
                    statement.setString(7, row[6]); // CEP
                    statement.setString(8, row[7]); // NOMERUA
                    statement.setString(9, row[8]); // NUMRUA
                    statement.setString(10, row[9]); // BAIRRO
                    statement.setString(11, row[10]); // CIDADE
                    statement.setString(12, row[11]); // TELEFONE
                    statement.setString(13, row[12]); // CEL
                    statement.setString(14, row[13]); // CONTATO
                    statement.setString(15, row[14]); // EMAIL
                    statement.setString(16, row[15]); // WWW

                    statement.addBatch();

                    if (++count % batchSize == 0) {
                        statement.executeBatch();
                    }
                }

                statement.executeBatch();
                connection.commit();

                System.out.println("Importação de Fornecedores Concluída!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}