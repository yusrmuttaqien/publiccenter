<br/>
<div align="center">
  <h3 align="center">Public Center - CLI</h3>

  <p align="center">
    Program Java CLI untuk Public Center
  </p>
</div>

<br/>

## Cara men-compile program

- Pastikan JDK terinstall di sistem

- Compile semua module sebelum men-compile main program (compile dari modul dari level terendah dalam tingkat depedensi, dependensi harus ter-compile terlebih dahulu sebelum men-compile modul yang me-require modul lainnya)

```zsh
javac -d modules/<nama module> src/<direktori file java milik module> && javac -d modules/<nama module> src/<direktori file module-info.java milik module>
```

- Ulangi perintah diatas untuk semua modul

- Setelah semua modul ter-compile lakukan compile main program dengan perintah berikut

```zsh
javac --module-path modules -d modules/<nama main program> src/<direktori file java milik main program> && javac --module-path modules -d modules/<nama main program> src/<direktori file module-info.java milik main program>
```

- Setelah main program tercompile dengan baik, jalankan program dengan perintah berikut

```zsh
java --module-path modules -m <direktori main program dalam folder modules, direktori setelah folder root dinotasikan dengan dot (.) (ex: main/main.app.App)>
```

## Credit

- 2702352282 - Nisa Amelia Putri

- 2702349666 - Yusril Dhiyaul Haq Muttaqien

- 2702364736 - Nabella Kurnia Wardani

- 2702352313 - Ahmad Rizal Priyono

- 2702345163 - Risdhi Laksna Lintang Trengginas
