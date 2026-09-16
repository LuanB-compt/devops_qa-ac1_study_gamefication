<script setup>
import { ref } from 'vue'
import {
  criarAssinatura,
  consultarAssinatura,
  registrarPagamento,
  encerrarMesAssinatura
} from '../api'

const alunoNome = ref('')
const assinatura = ref(null)
const carregando = ref(false)
const mensagem = ref('')
const tipoMensagem = ref('sucesso')

async function executar(acao, textoSucesso) {
  if (!alunoNome.value.trim()) {
    mensagem.value = 'Informe o nome do aluno.'
    tipoMensagem.value = 'erro'
    return
  }
  carregando.value = true
  mensagem.value = ''
  try {
    assinatura.value = await acao(alunoNome.value.trim())
    mensagem.value = textoSucesso
    tipoMensagem.value = 'sucesso'
  } catch (e) {
    mensagem.value = e.message || 'Ocorreu um erro.'
    tipoMensagem.value = 'erro'
  } finally {
    carregando.value = false
  }
}

const criar = () => executar(criarAssinatura, 'Assinatura criada/ativada.')
const consultar = () => executar(consultarAssinatura, 'Assinatura consultada.')
const pagar = () => executar(registrarPagamento, 'Pagamento registrado.')
const encerrar = () => executar(encerrarMesAssinatura, 'Mes da assinatura encerrado.')
</script>

<template>
  <section class="card">
    <h2>Assinaturas</h2>
    <h3>Ativacao, pagamento e encerramento de mes da assinatura de um aluno</h3>

    <form class="linha" @submit.prevent>
      <div class="campo">
        <label for="aluno-assinatura">Nome do aluno</label>
        <input id="aluno-assinatura" v-model="alunoNome" placeholder="ex: Juan" />
      </div>
      <button class="acao" type="button" :disabled="carregando" @click="criar">Criar / ativar</button>
      <button class="acao secundaria" type="button" :disabled="carregando" @click="consultar">Consultar</button>
      <button class="acao secundaria" type="button" :disabled="carregando" @click="pagar">Registrar pagamento</button>
      <button class="acao secundaria" type="button" :disabled="carregando" @click="encerrar">Encerrar mes</button>
    </form>

    <p v-if="mensagem" class="mensagem" :class="tipoMensagem">{{ mensagem }}</p>

    <table v-if="assinatura">
      <thead>
        <tr>
          <th>Aluno</th>
          <th>Ativa</th>
          <th>Pagamento realizado</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>{{ assinatura.alunoNome }}</td>
          <td>
            <span class="badge" :class="assinatura.ativa ? 'ativa' : 'inativa'">
              {{ assinatura.ativa ? 'Ativa' : 'Cancelada' }}
            </span>
          </td>
          <td>{{ assinatura.pagamentoRealizado ? 'Sim' : 'Nao' }}</td>
        </tr>
      </tbody>
    </table>
  </section>
</template>
