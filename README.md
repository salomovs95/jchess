<!-- <div align="center"></div> -->

# JChess

## 🚀 Description

The greatest CLI Chess game that's ever lived!

<div align="center">
  <a>
    <img src="https://github.com/user-attachments/assets/ca031014-aefb-41e4-a858-c3302efcb272" alt="PREVIEW" />
  </a>
</div>

## 📋 Sumary

1. ⚙️ Tooling
2. 💾 Setup Environment
3. 💻 How to run
4. 🤝 Contributing
5. 👥 Contributors

## ⚙️ Tooling

1. Java
2. Gradle (Before was using Ant to build application)

## 💾 Setup Environment

> [!NOTE]
> No _environment variables setup needed_.

1. Java 21
2. Gradle 9.0.0 (already bundled in the project :D)

## 💻 How to run

After environment is properly set up, in the project folder assemble the jar executable using:
```bash
./gradlew build
```

Once build is finished, execute the generated jar file with:
```bash
java -jar app/build/libs/JAR_FILENAME.jar
java -jar app/build/libs/*.jar # to simplify
```

Simple enough, there's two(2) inputs, the source (where the piece you want to move is on) and the destination (where you want the piece to land on).

Not inventing rules, just the basic Chess rules everyone knows(or at least can learn on the internet :D).

Fair enough, give it a try! Hope one can enjoy it!

> [!WARNING]
> Do not start the application using gradle directly, due to inconsistent input behavior.
> 
> Build the jar prior to running the application!
> 
> I warned you! :D

## 🤝 Contributing

- [ ] Make a fork of the project at ([https://github.com/salomovs95/jchess](https://github.com/salomovs95/jchess))
- [ ] Push your changes to a new branch, example: `feat/foo/bar`.
- [ ] Open a PR (Pull Request) to the main repository, describing what's changed.

> [!WARNING]
> Aproval not guaranteed. ;-)

## 👥 Contributors

<table>
  <tbody>
    <tr>
      <td style="padding: 10px; border: 1px solid #ddd;">
        <img src="https://avatars.githubusercontent.com/u/170432574?v=4" width="60" style="border-radius: 50%; display: block; margin: 0 auto;">
      </td>
      <td style="padding: 10px; border: 1px solid #ddd;">Salomao Souza</td>
      <td style="padding: 10px; border: 1px solid #ddd;">
        <a href="https://linkedin.com/in/salomovs95" target="_blank">LinkedIn</a> |
        <a href="https://github.com/salomovs95" target="_blank">GitHub</a>
      </td>
    </tr>
  </tbody>
</table>

> [!NOTE]
> 2025 • Made with 💜
