## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

# Summary

A [Multi-threading] --> B(Concurrency - Quản lý việc)
A --> C(Parallelism - Tăng tốc độ)

    B --> B1[Synchronized - Khóa cứng]
    B --> B2[ReentrantLock - Khóa linh hoạt]
    B --> B3[Atomic/CAS - Không khóa]

    C --> C1[Fork-Join Pool - Chia để trị]
    C --> C2[Parallel Stream - Tận dụng 16 luồng]

Synchronous (gọi hàm, đợi kết quả mới chạy dòng code tiếp theo) / Asynchronous (gọi hàm, đăng ký callback và chạy ngay dòng code tiếp theo): Nói về kết quả

Blocking (Luồng wait chờ kết quả) / Non-blocking (Luồng trả về ngay Promise/Future): Nói về trạng thái của luồng. Luồng có được phép làm việc khác trong khi đợi kết quả hay không?
