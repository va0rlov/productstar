# Получаем аргументы скрипта
param (
    [string]$substring = "a"  # Значение по умолчанию, если аргумент не передан
)

# Компиляция Java-файла
javac .\src\main\java\HighlightSubstring.java

# Запуск программы с передачей данных через пайп и использованием аргумента
cat .\LOREM.md | java -cp .\src\main\java HighlightSubstring $substring