mkdir temporary
del pack.jar

"C:\Program Files\7-Zip\7z.exe" x .\target\*.jar -o.\temporary\

"C:\Program Files\7-Zip\7z.exe" x .\branch_1_18\target\*.jar -o.\temporary\ -y

"C:\Program Files\7-Zip\7z.exe" a -aou pack.jar .\temporary\*

rmdir /s /q temporary