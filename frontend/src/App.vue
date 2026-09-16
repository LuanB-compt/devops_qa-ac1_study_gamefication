<script setup>
import { ref } from 'vue'
import AlunosTab from './components/AlunosTab.vue'
import AssinaturasTab from './components/AssinaturasTab.vue'
import CursosTab from './components/CursosTab.vue'
import MesesTab from './components/MesesTab.vue'

const abas = [
  { id: 'alunos', rotulo: 'Alunos' },
  { id: 'assinaturas', rotulo: 'Assinaturas' },
  { id: 'cursos', rotulo: 'Cursos' },
  { id: 'meses', rotulo: 'Mes de Contribuicoes' }
]

const abaAtiva = ref('alunos')
</script>

<template>
  <div>
    <header class="topo">
      <h1>Gamification &middot; Educacao Continuada</h1>
    </header>

    <nav class="abas">
      <button
        v-for="aba in abas"
        :key="aba.id"
        :class="{ ativa: abaAtiva === aba.id }"
        @click="abaAtiva = aba.id"
      >
        {{ aba.rotulo }}
      </button>
    </nav>

    <AlunosTab v-if="abaAtiva === 'alunos'" />
    <AssinaturasTab v-else-if="abaAtiva === 'assinaturas'" />
    <CursosTab v-else-if="abaAtiva === 'cursos'" />
    <MesesTab v-else-if="abaAtiva === 'meses'" />
  </div>
</template>
