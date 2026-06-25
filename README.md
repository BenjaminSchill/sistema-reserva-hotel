# Sistema de Reserva de Hotel

Este projeto consiste em um sistema de reservas de hotel desenvolvido em Java para praticar e fixar conceitos avançados de orientação a objetos e tratamento de exceções customizadas.

## 🛠️ Tecnologias e Conceitos Utilizados
- **Java SE** (Lógica de programação e POO)
- **Java Time API** (`LocalDate`, `ChronoUnit` para cálculo de diárias)
- **Tratamento de Exceções** (`try-catch`, criação de exceções personalizadas estendendo `RuntimeException`)

## 📋 Regras de Negócio Implementadas
- A data de check-out deve ser posterior à data de check-in.
- Novas reservas ou atualizações de datas devem conter apenas datas futuras.
- Validação de entrada de dados para evitar formatos inválidos de texto e números.
