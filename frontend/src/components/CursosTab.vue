<script setup>
import { ref } from 'vue'
import { concluirCurso } from '../api'

const alunoNome = ref('')
const cursoNome = ref('')
const media = ref('')
const carregando = ref(false)
const mensagem = ref('')
const tipoMensagem = ref('sucesso')
const resultado = ref(null)

async function enviar() {
  if (!alunoNome.value.trim() || !cursoNome.value.trim() || media.value === '') {
    mensagem.value = 'Preencha aluno, curso e media.'
    tipoMensagem.value = 'erro'
    return
  }
  carregando.value = true
  mensagem.value = ''
  try {
    resultado.value = await concluirCurso(alunoNome.value.trim(), cursoNome.value.trim(), Number(media.value))
    const bonus = Number(media.value) > 7 ? ' (media acima de 7: ganhou +3 cursos de bonus!)' : ''
    mensagem.value = `Curso concluido.${bonus}`
    tipoMensagem.value = 'sucesso'
  } catch (e) {
    mensagem.value = e.message || 'Ocorreu um erro.'
    tipoMensagem.value = 'erro'
  } finally {
    carregando.value = false
  }
}
</script>

<template>
  <section class="card">
    <h2>Cursos</h2>
    <h3>Registrar a conclusao de um curso por um aluno</h3>

    <form class="linha" @submit.prevent="enviar">
      <div class="campo">
        <label for="aluno-curso">Nome do aluno</label>
        <input id="aluno-curso" v-model="alunoNome" placeholder="ex: Juan" />
      </div>
      <div class="campo">
        <label for="nome-curso">Nome do curso</label>
        <input id="nome-curso" v-model="cursoNome" placeholder="ex: DevOps" />
      </div>
      <div class="campo">
        <label for="media-curso">Media (0 a 10)</label>
        <input id="media-curso" v-model="media" type="number" step="1" min="0" max="10" style="min-width: 90px;" />
      </div>
      <button class="acao" type="submit" :disabled="carregando">
        {{ carregando ? 'Enviando...' : 'Concluir curso' }}
      </button>
    </form>

    <p v-if="mensagem" class="mensagem" :class="tipoMensagem">{{ mensagem }}</p>

    <table v-if="resultado">
      <thead>
        <tr>
          <th>Aluno</th>
          <th>Cursos concluidos</th>
          <th>Moedas</th>
          <th>Plano</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>{{ resultado.nome }}</td>
          <td>{{ resultado.cursosConcluidos }}</td>
          <td>{{ resultado.moedas }}</td>
          <td>
            <span class="badge" :class="resultado.plano === 'PREMIUM' ? 'premium' : 'basico'">
              {{ resultado.plano }}
            </span>
          </td>
        </tr>
      </tbody>
    </table>
  </section>
</template>
