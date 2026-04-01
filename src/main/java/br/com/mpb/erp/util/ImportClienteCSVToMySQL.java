package br.com.mpb.erp.util;

import br.com.mpb.erp.entity.StatusCliente;
import com.opencsv.CSVReader;
import org.hibernate.tool.schema.spi.ScriptTargetOutput;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ImportClienteCSVToMySQL {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/mpb";
        String username = "root";
        String password = System.getenv("DB_MYSQL_PASSWORD");

        String csvFilePath = "clientes.csv";

        int batchSize = 20;

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            connection.setAutoCommit(false);

            String sql = "INSERT INTO clientes (id, data_inc, data_alt, tipo, nome, nome_rua, num_rua, bairro, cep, telefone, celular, fantasia_ou_apelido, cpf, rg, email, observacao, status) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement statement = connection.prepareStatement(sql);
                 CSVReader reader = new CSVReader(
                         new InputStreamReader(new FileInputStream("clientes.csv"), "ISO-8859-1"));
                 ) {

                String[] row;
                reader.readNext(); // pula cabeçalho

                int count = 0;
                while ((row = reader.readNext()) != null) {
                    statement.setInt(1, Integer.parseInt(row[0]));

                    // data_inc
                    String dataIncStr = row[1];
                    if (dataIncStr == null || dataIncStr.trim().isEmpty()) {
                        statement.setNull(2, java.sql.Types.DATE);
                    } else {
                        statement.setDate(2, java.sql.Date.valueOf(dataIncStr));
                    }

                    // data_alt
                    String dataAltStr = row[2];
                    if (dataAltStr == null || dataAltStr.trim().isEmpty()) {
                        statement.setNull(3, java.sql.Types.DATE);
                    } else {
                        statement.setDate(3, java.sql.Date.valueOf(dataAltStr));
                    }

                    // data_nasc (se existir na tabela)
                    String dataNascStr = row[3];
                    if (dataNascStr == null || dataNascStr.trim().isEmpty()) {
                        statement.setNull(4, java.sql.Types.DATE);
                    } else {
                        statement.setDate(4, java.sql.Date.valueOf(dataNascStr));
                    }
                    //statement.setString(2, row[1]); // data_inc
                    //statement.setString(3, row[2]); // data_alt
                    statement.setString(4, row[4]); // tipo
                    statement.setString(5, row[5]); // nome
                    statement.setString(6, row[6]); // nome_rua
                    statement.setString(7, row[7]); // num_rua
                    statement.setString(8, row[8]); // bairro
                    statement.setString(9, row[11]); // cep
                    statement.setString(10, row[12]); // telefone
                    statement.setString(11, row[15]); // celular
                    statement.setString(12, row[16]); // fantasia
                    statement.setString(13, row[17]); // cpf
                    statement.setString(14, row[18]); // rg
                    statement.setString(15, row[19]); // email
                    statement.setString(16, row[20]); // observacao
                    //statement.setString(17, row[21]); // status

                    String statusStr = row[21];
                    if (statusStr == null || statusStr.trim().isEmpty()) {
                        statement.setString(17, StatusCliente.ATIVO.name());
                    } else if (statusStr.equalsIgnoreCase("L")) {
                        statement.setString(17, StatusCliente.ATIVO.name());
                    } else if (statusStr.equalsIgnoreCase("B")) {
                        statement.setString(17, StatusCliente.BLOQUEADO.name());
                    } else {
                        statement.setString(17, StatusCliente.ATIVO.name()); // default
                    }

                    statement.addBatch();

                    if (++count % batchSize == 0) {
                        statement.executeBatch();
                    }
                }

                statement.executeBatch();
                connection.commit();

                System.out.println("Importação de Clientes Concluída!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}