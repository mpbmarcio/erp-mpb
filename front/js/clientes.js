const apiUrl = "http://localhost:8080/clientes";

async function carregarClientes() {
  const response = await fetch(apiUrl);
  const clientes = await response.json();
  const tbody = document.getElementById("tabelaClientes");
  tbody.innerHTML = "";
  clientes.forEach(c => {
    const tr = document.createElement("tr");
    tr.innerHTML = `
      <td>${c.id}</td>
      <td>${c.nome}</td>
      <td>${c.cpf}</td>
      <td>${c.email}</td>
      <td style="text-align:center;">
        <button onclick="editarCliente(${c.id}, '${c.nome}', '${c.cpf}', '${c.email}')">✏️</button>
        <button onclick="removerCliente(${c.id})">🗑️</button>
      </td>
    `;
    tbody.appendChild(tr);
  });
}

async function salvarCliente(event) {
  event.preventDefault();
  const id = document.getElementById("clienteId")?.value;
  const cliente = {
    nome: document.getElementById("nomeCliente").value,
    cpf: document.getElementById("cpfCliente").value,
    email: document.getElementById("emailCliente").value
  };

  const method = id ? "PUT" : "POST";
  const url = id ? `${apiUrl}/${id}` : apiUrl;

  await fetch(url, {
    method,
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(cliente)
  });

  document.getElementById("formCliente").reset();
  carregarClientes();
}

async function removerCliente(id) {
  await fetch(`${apiUrl}/${id}`, { method: "DELETE" });
  carregarClientes();
}

function editarCliente(id, nome, cpf, email) {
  document.getElementById("nomeCliente").value = nome;
  document.getElementById("cpfCliente").value = cpf;
  document.getElementById("emailCliente").value = email;

  // cria campo hidden para armazenar id
  let hiddenId = document.getElementById("clienteId");
  if (!hiddenId) {
    hiddenId = document.createElement("input");
    hiddenId.type = "hidden";
    hiddenId.id = "clienteId";
    document.getElementById("formCliente").appendChild(hiddenId);
  }
  hiddenId.value = id;
}

document.getElementById("formCliente").addEventListener("submit", salvarCliente);

carregarClientes();