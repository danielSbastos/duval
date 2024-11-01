## Instruções para execução do projeto

### Arquivo `AppCalcCentroid.java`

Este arquivo calcula as coordenadas da centroide de um polígono irregular de acordo com a quantidade absoluta dos gases H2, C2H6, CH4, C2H4, C2H2.

O valor referente à quantidade de cada gas é dada de entrada para o programa:

```java
javac AppCalcCentroid.java
java AppCalcCentroid
```

Por exemplo:
```
Digite o valor em ppm de H2: 1270 
Digite o valor em ppm de C2H6: 520
Digite o valor em ppm de CH4: 3450
Digite o valor em ppm de C2H4: 1390
Digite o valor em ppm de C2H2: 8

Coordenadas do centroide (Cx = -7.42, Cy = -15.60)
```

As coordenadas resultantes devem ser dadas de entrada para o arquivo `AppPentDuval.java`


### Arquivo `AppPentDuval.java`

Neste arquivo, se nenhum coordenada for dada de entrada, o código irá testar várias coordenadas com correspondente à falhas diversas, e e dar como output.

```java
javac AppPentDuval.java
java AppPentDuval
```

Se um set de coordenadas for dada:
```
Deseja inserir coordenadas [S/n]: S
Digite o valor de Cx: -7.42
Digite o valor de Cy: -15.00

Tipo de falha detectada: T2
```

Caso contrário:
```
Deseja inserir coordenadas [S/n]: n


Para os valores de centroide de (-7.35, -5.79), obtidos de CHEIM (2020), o tipo de falha esperado é T1. 
Com os cálculos do código: 
Tipo de falha detectada: T1


Para os valores de centroide de (-7.35, -5.79), obtidos com nosso primeiro algoritmo, o tipo de falha esperado é T1. 
Com os cálculos do código: 
Tipo de falha detectada: T1




INÍCIO DOS TESTES PARA CENTROIDES DE PONTOS DE INTERSEÇÕES OU PONTOS PASSÍVEIS DE ERROS


**** TESTES PARA PD ****

(-0.50, 25.00)PD
Tipo de falha detectada: PD

(-1.00, 33.00)PD
Tipo de falha detectada: PD

(0.00, 24.50)PD
Tipo de falha detectada: PD



**** TESTES PARA S **** 

(-10.00, 10.00)S
Tipo de falha detectada: S

(-2.00, 33.00)S
Tipo de falha detectada: S

(-2.00, 24.50)S
Tipo de falha detectada: S

(-35.00, 3.20)S
Tipo de falha detectada: S

(-37.90, 12.40)S
Tipo de falha detectada: S

(-38.00, 12.40)S
Tipo de falha detectada: S



**** TESTES PARA T1 **** 

(-1.00, -1.00)T1 mini
Tipo de falha detectada: T1 mini

(-25.00, -20.00)T1
Tipo de falha detectada: T1

(-35.00, 3.10)T1
Tipo de falha detectada: T1

(-23.50, -32.40)T1
Tipo de falha detectada: T1



**** TESTES PARA T2 ****

(-10.00, -25.00)T2
Tipo de falha detectada: T2

(-22.50, -32.40)T2
Tipo de falha detectada: T2



**** TESTES PARA T3 ****

(10.00, -25.00)T3
Tipo de falha detectada: T3

(-6.00, -4.00)T3
Tipo de falha detectada: T3

(1.00, -32.40)T3
Tipo de falha detectada: T3

(23.50, -32.40)T3
Tipo de falha detectada: T3



**** TESTES PARA D2 ****

(20.00, -10.00)D2
Tipo de falha detectada: D2

(5.00, 10.00)D2
Tipo de falha detectada: D2

(0.00, 1.50)D2
Tipo de falha detectada: D2

(0.00, -3.00)D2
Tipo de falha detectada: D2

(24.30, -30.00)D2
Tipo de falha detectada: D2

(32.00, -6.10)D2
Tipo de falha detectada: D2

(4.00, 16.00)D2
Tipo de falha detectada: D2



**** TESTES PARA D1 ****

(20.00, 20.00)D1
Tipo de falha detectada: D1

(38.00, 12.00)D1
Tipo de falha detectada: D1

(0.50, 10.00)D1mini
Tipo de falha detectada: D1 mini

(0.00, 40.00)D1mini
Tipo de falha detectada: D1 mini
```


