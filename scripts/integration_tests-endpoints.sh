#!/bin/bash
# Testes dos endpoints REST da aplicação gamification (DEV | Spring Boot + H2 em memória)

set -x

echo "== GET /api/alunos (vazio) =="
curl -s -o /dev/null -w "HTTP %{http_code}\n" http://localhost:8080/api/alunos
curl -s http://localhost:8080/api/alunos
echo

echo "== POST /api/assinaturas/{aluno} (cria aluno + assinatura) =="
curl -s -w "\nHTTP %{http_code}\n" -X POST http://localhost:8080/api/assinaturas/Luan
echo

echo "== GET /api/alunos (agora com 1) =="
curl -s http://localhost:8080/api/alunos
echo

echo "== GET /api/alunos/Luan =="
curl -s -w "\nHTTP %{http_code}\n" http://localhost:8080/api/alunos/Luan
echo

echo "== POST /api/meses/set-2026/contribuicoes =="
curl -s -w "\nHTTP %{http_code}\n" -X POST http://localhost:8080/api/meses/set-2026/contribuicoes \
  -H "Content-Type: application/json" \
  -d '{"alunoNome":"Luan","peso":1.0}'
echo

echo "== GET /api/meses/set-2026/ranking =="
curl -s -w "\nHTTP %{http_code}\n" http://localhost:8080/api/meses/set-2026/ranking
echo

echo "== POST /api/alunos/Luan/cursos =="
curl -s -w "\nHTTP %{http_code}\n" -X POST http://localhost:8080/api/alunos/Luan/cursos \
  -H "Content-Type: application/json" \
  -d '{"cursoNome":"DevOps","media":8.5}'
echo

echo "== GET /h2-console (verifica se serve HTML) =="
curl -s -o /dev/null -w "HTTP %{http_code}\n" http://localhost:8080/h2-console
