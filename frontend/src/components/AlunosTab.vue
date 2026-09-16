<script setup>
import { ref, onMounted } from 'vue'
import { listarAlunos } from '../api'

const alunos = ref([])
const carregando = ref(false)
const erro = ref('')

async function carregar() {
  carregando.value = true
  erro.value = ''
  try {
    alunos.value = await listarAlunos()
  } catch (e) {
    erro.value = e.message || 'Nao foi possivel carregar os alunos.'
  } finally {
    carregando.value = false
  }
}

onMounted(carregar)
</script>

<template>
  <section class="card">
    <div class="card-header">
      <h2>Alunos</h2>
      <button class="acao secundaria" @click="carregar" :disabled="carregando">
        {{ carregando ? 'Atualizando...' : 'Atualizar' }}
      </button>
    </div>

    <p v-if="erro" class="mensagem erro">{{ erro }}</p>

    <p v-if="!carregando && !erro && alunos.length === 0" class="vazio">
      Nenhum aluno cadastrado ainda. Crie uma assinatura ou conclua um curso na aba
      correspondente para gerar o primeiro aluno.
    </p>

    <table v-if="alunos.length > 0">
      <thead>
        <tr>
          <th>Nome</th>
          <th>Cursos concluidos</th>
          <th>Moedas</th>
          <th>Plano</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="aluno in alunos" :key="aluno.id">
          <td>{{ aluno.nome }}</td>
          <td>{{ aluno.cursosConcluidos }}</td>
          <td>{{ aluno.moedas }}</td>
          <td>
            <span class="badge" :class="aluno.plano === 'PREMIUM' ? 'premium' : 'basico'">
              {{ aluno.plano }}
            </span>
          </td>
        </tr>
      </tbody>
    </table>
  </section>
</template>
