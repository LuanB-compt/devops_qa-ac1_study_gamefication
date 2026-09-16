const BASE_URL = '/api'

async function request(path, options = {}) {
  const response = await fetch(`${BASE_URL}${path}`, {
    headers: { 'Content-Type': 'application/json' },
    ...options
  })

  if (!response.ok) {
    const texto = await response.text().catch(() => '')
    const erro = new Error(texto || `Erro HTTP ${response.status}`)
    erro.status = response.status
    throw erro
  }

  const contentType = response.headers.get('content-type') || ''
  if (!contentType.includes('application/json')) {
    return null
  }
  return response.json()
}

// Alunos
export function listarAlunos() {
  return request('/alunos')
}

export function buscarAluno(nome) {
  return request(`/alunos/${encodeURIComponent(nome)}`)
}

// Assinaturas
export function criarAssinatura(alunoNome) {
  return request(`/assinaturas/${encodeURIComponent(alunoNome)}`, { method: 'POST' })
}

export function consultarAssinatura(alunoNome) {
  return request(`/assinaturas/${encodeURIComponent(alunoNome)}`)
}

export function registrarPagamento(alunoNome) {
  return request(`/assinaturas/${encodeURIComponent(alunoNome)}/pagamento`, { method: 'POST' })
}

export function encerrarMesAssinatura(alunoNome) {
  return request(`/assinaturas/${encodeURIComponent(alunoNome)}/encerrar`, { method: 'POST' })
}

// Cursos
export function concluirCurso(alunoNome, cursoNome, media) {
  return request(`/alunos/${encodeURIComponent(alunoNome)}/cursos`, {
    method: 'POST',
    body: JSON.stringify({ cursoNome, media })
  })
}

// Mes de contribuicoes
export async function registrarContribuicao(descricao, alunoNome, peso) {
  const response = await fetch(`${BASE_URL}/meses/${encodeURIComponent(descricao)}/contribuicoes`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ alunoNome, peso })
  })

  if (response.status === 201) {
    return { registrada: true }
  }
  if (response.status === 409) {
    return { registrada: false }
  }
  const texto = await response.text().catch(() => '')
  throw new Error(texto || `Erro HTTP ${response.status}`)
}

export function consultarRanking(descricao) {
  return request(`/meses/${encodeURIComponent(descricao)}/ranking`)
}

export function encerrarMes(descricao) {
  return request(`/meses/${encodeURIComponent(descricao)}/encerrar`, { method: 'POST' })
}
