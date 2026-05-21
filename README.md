# 🏃 SportPass

Aplicativo Android desenvolvido em Java para calcular a distância percorrida com base na quantidade de passos informada pelo usuário.

---

## 📱 Preview do App

![SportPass](attachment\:image.png)

---

## ✨ Funcionalidades

* Informar a quantidade de passos
* Selecionar o tamanho do passo:

  * Curto = 50cm
  * Médio = 80cm
  * Longo = 110cm
* Opção para indicar se está correndo
* Cálculo automático da distância percorrida em metros
* Validação de campos
* Exibição de mensagens usando `Toast`

---

## 🛠️ Tecnologias Utilizadas

* Java
* Android Studio
* XML
* Android SDK

---

## 📂 Estrutura Principal

```bash
br.ulbra.sportpass
 ├── MainActivity.java
 ├── activity_main.xml
 └── res/
```

---

## 📌 Lógica do Projeto

O aplicativo funciona da seguinte forma:

1. O usuário informa a quantidade de passos
2. Escolhe o tamanho do passo
3. Marca a opção "Correndo" caso esteja correndo
4. O sistema calcula a distância percorrida

### Fórmula utilizada

```text
distância = (passos × tamanho_do_passo) × multiplicador_corrida
```

Se o usuário estiver correndo:

```text
multiplicador_corrida = 1.1
```

---

## 💻 Código Principal

```java
public void calcularPassos() {
    if (edPassos.getText().toString().isEmpty()) {
        Toast.makeText(this, "Informe uma quantidade de passos que nao seja nula", Toast.LENGTH_SHORT).show();

    } else if(Double.parseDouble(edPassos.getText().toString()) < 0){

        Toast.makeText(this, "Informe uma quantidade de passos acima de -1", Toast.LENGTH_SHORT).show();

    } else {

        double passos = Double.parseDouble(edPassos.getText().toString());
        double multi = 0;
        double multi2 = 1;

        int op = rgOpcoe.getCheckedRadioButtonId();

        if (op == R.id.rb50) {
            multi = 0.5;
        } else if (op == R.id.rb80) {
            multi = 0.8;
        } else {
            multi = 1.1;
        }

        if (cbCorrendo.isChecked()) {
            multi2 += 0.1;
        }

        double percorrido = (passos * multi) * multi2;
        double metros = percorrido / 100;

        txRes.setText("A quantidade em metros percorrida foi de : " + metros);
    }
}
```

---

## 🚀 Como Executar

1. Clone este repositório:

```bash
git clone https://github.com/seu-usuario/sportpass.git
```

2. Abra o projeto no Android Studio

3. Execute em um emulador ou dispositivo físico

---

## 📖 Aprendizados

Este projeto foi desenvolvido para praticar:

* Manipulação de componentes Android
* Eventos de clique
* Estruturas condicionais
* Cálculos matemáticos
* Tratamento de entradas do usuário
* Interface gráfica com XML

---

## 👨‍💻 Autor

Desenvolvido por **Seu Nome**

---

## 📄 Licença

Este projeto está sob a licença MIT.
