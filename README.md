# CutUtility
Выделение из каждой строки текстового файла некоторой подстроки:
* file задаёт имя входного файла. Если параметр отсутствует, следует считыватьвходные данные с консольного ввода;
* Флаг -o ofile задаёт имя выходного файла (в данном случае ofile). Еслипараметр отсутствует, следует выводить результат на консольный вывод.
* Флаг -с означает, что все числовые параметры задают отступы в символах(буквах) входного файла.
* Флаг -w означает, что все числовые параметры задают отступы в словах (т.е.последовательностях символов без пробелов) входного файла.
* Параметр range задаёт выходной диапазон и имеет один из следующих видов(здесь N и К -- целые числа):
1. -K диапазон от начала строки до K 
2. N- диапазон от N до конца строки 
3. N-K диапазон от N до K 

 Command line: cut [-c|-w] [-o ofile] [file] range

 Программа построчно обрабатывает входные данные и для каждой строки выдаётчасть этой строки согласно заданному диапазону.
 Если какого-то из указанных файловне существует или неправильно указаны параметры -c и -w (должен быть указан ровноодин из них), следует выдать ошибку.
 Если в строке не хватает символов или слов, это ошибкой не является, в этом случае следует выдать ту часть входных данных, которая попадает в диапазон.
 Кроме самой программы, следует написать автоматические тесты к ней.
