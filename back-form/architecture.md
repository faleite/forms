# Análise e Ajuste do Modelo

---

## Problemas na ideia original

- `User` acumula responsabilidades demais — mistura autenticação com dados de colaborador
- `Car` vinculado diretamente ao `User` não reflete a realidade — um carro pode ser usado por vários entregadores em dias diferentes
- `Services` e `Incidences` soltos sem vínculo com data/dia de trabalho — impossibilita análise diária, mensal e anual

---

## Modelo corrigido

### `User` — autenticação apenas
| Campo | Tipo | Observação |
|---|---|---|
| id | Long | PK |
| login | String | único |
| password | String | hash |
| role | Enum | ADMIN, ENTREGADOR |
| colaborador_id | FK | → Colaborador |

---

### `Colaborador` — dados do funcionário
| Campo | Tipo | Observação |
|---|---|---|
| id | Long | PK |
| nome | String | |
| telefone | String | |
| email | String | |
| ativo | Boolean | para desativar sem deletar |

---

### `Veiculo` — frota
| Campo | Tipo | Observação |
|---|---|---|
| id | Long | PK |
| matricula | String | único |
| marca | String | |
| modelo | String | |
| ativo | Boolean | |

---

### `RegistoDiario` — **entidade central**
Representa o dia de trabalho de um colaborador. Tudo se liga aqui.

| Campo | Tipo | Observação |
|---|---|---|
| id | Long | PK |
| colaborador_id | FK | → Colaborador |
| veiculo_id | FK | → Veiculo |
| data | Date | dia do registo |
| km_inicial | Integer | |
| km_final | Integer | |
| km_total | Integer | calculado: km_final - km_inicial |

---

### `Entrega` — serviços realizados
| Campo | Tipo | Observação |
|---|---|---|
| id | Long | PK |
| registo_diario_id | FK | → RegistoDiario |
| entregas | Integer | pacotes entregues |
| recolhas | Integer | pacotes recolhidos |
| total_servicos | Integer | entregas + recolhas |

---

### `Incidencia` — serviços não realizados
| Campo | Tipo | Observação |
|---|---|---|
| id | Long | PK |
| registo_diario_id | FK | → RegistoDiario |
| tipo | Enum | RETORNO, AVISADO, DESCONHECIDO |
| quantidade | Integer | |
| observacao | String | opcional |

---

## Relações

```
Colaborador ──< RegistoDiario >── Veiculo
                    │
                    ├──< Entrega
                    └──< Incidencia

User ──── Colaborador
```

- `Colaborador` tem muitos `RegistoDiario` — um por dia de trabalho
- `Veiculo` pode aparecer em muitos `RegistoDiario` — vários colaboradores podem usar o mesmo carro em dias diferentes
- `RegistoDiario` tem uma `Entrega` e muitas `Incidencia`
- `User` tem um `Colaborador` — separa autenticação de dados pessoais

---

## O que esta arquitetura permite

| Análise | Como |
|---|---|
| Diária | filtrar `RegistoDiario` por `data` |
| Mensal | filtrar por `colaborador_id` + mês/ano |
| Anual | agrupar `total_servicos` por ano |
| Por veículo | filtrar `RegistoDiario` por `veiculo_id` |
| Incidências por tipo | agrupar `Incidencia` por `tipo` |
| Km rodado por colaborador | somar `km_total` dos registos |

# Como ficaria uma consulta completa de um dia

Dado um `colaborador_id` e uma `data`, você obtém:

```
RegistoDiario
├── data
├── km_inicial
├── km_final
├── km_total
├── Colaborador
│   └── nome, telefone...
├── Veiculo
│   └── matricula, modelo...
├── Entrega
│   ├── entregas
│   ├── recolhas
│   └── total_servicos
└── Incidencias[]
    ├── { tipo: RETORNO, quantidade: 2, observacao: ... }
    ├── { tipo: AVISADO, quantidade: 1, observacao: ... }
    └── { tipo: DESCONHECIDO, quantidade: 0, observacao: ... }
```

---

## Filtros possíveis com este modelo

| Consulta | Filtro |
|---|---|
| Dia específico | `colaborador_id` + `data = 2025-01-15` |
| Mês inteiro | `colaborador_id` + `MONTH(data) = 1 AND YEAR(data) = 2025` |
| Ano inteiro | `colaborador_id` + `YEAR(data) = 2025` |
| Todos colaboradores num dia | apenas `data = 2025-01-15` |
| Ranking de entregas no mês | agrupar por `colaborador_id`, somar `total_servicos` |

---

## Resposta em JSON — exemplo de um dia completo

```json
{
  "data": "2025-01-15",
  "colaborador": { "nome": "Carlos Silva" },
  "veiculo": { "matricula": "AA-00-BB" },
  "km_inicial": 12000,
  "km_final": 12180,
  "km_total": 180,
  "entrega": {
    "entregas": 42,
    "recolhas": 8,
    "total_servicos": 50
  },
  "incidencias": [
    { "tipo": "RETORNO", "quantidade": 3 },
    { "tipo": "AVISADO", "quantidade": 2 }
  ]
}
```

Um único endpoint pode retornar tudo isso montado via DTO no Spring Boot.