package todo_app;

import java.util.List;
import java.util.Scanner;

import todo_app.controller.TaskController;
import todo_app.controller.UserController;
import todo_app.dto.request.TaskReqDto;
import todo_app.dto.request.UserSigninReqDto;
import todo_app.dto.request.UserSignupReqDto;
import todo_app.dto.response.TaskRespDto;
import todo_app.dto.response.UserRespDto;

public class App {
    private static final Scanner sc = new Scanner(System.in);
    private static final UserController userController = new UserController();
    private static final TaskController taskController = new TaskController();

    private static void displayMenu() {
        System.out.println("\n[메뉴 선택]");
        System.out.println("1. 유저 등록");
        System.out.println("2. 로그인");
        System.out.println("3. 로그아웃");
        System.out.println("4. 유저 전체 조회");
        System.out.println("5. 유저 단건 조회");
        System.out.println("6. 유저 삭제");
        System.out.println("7. 할일 추가");
        System.out.println("8. 할일 전체 조회");
        System.out.println("9. 할일 단건 조회");
        System.out.println("10. 할일 삭제");
        System.out.println("11. 프로그램 종료");
        System.out.print("메뉴를 선택하세요: ");
    }

    private static int getChoice() {
        while (!sc.hasNextInt()) {
            System.out.println("숫자를 입력해주세요.");
            sc.nextLine();
        }
        int choice = sc.nextInt();
        sc.nextLine(); // 버퍼 처리
        return choice;
    }

    private static String getInput(String prompt) {
        System.out.print(prompt + ": ");
        return sc.nextLine().trim();
    }

    private static long getIdInput() {
        String input = getInput("ID를 입력하세요");
        return Long.parseLong(input);
    }

    private static UserSignupReqDto createUserSignupRequest() {
        System.out.println("[유저 등록]");
        String userId = getInput("아이디");
        String password = getInput("비밀번호");
        String passwordCheck = getInput("비밀번호 확인");
        String username = getInput("이름");
        String email = getInput("이메일");
        String phone = getInput("전화번호");
        int age = Integer.parseInt(getInput("나이"));
        String nickname = getInput("닉네임");
        return new UserSignupReqDto(null, userId, password, passwordCheck, username, email, phone, age, nickname);
    }

    private static UserSigninReqDto createUserSigninRequest() {
        System.out.println("[로그인]");
        String userId = getInput("아이디");
        String password = getInput("비밀번호");
        return new UserSigninReqDto(userId, password);
    }

    private static TaskReqDto createTaskRequest() {
        System.out.println("[할일 추가]");
        long userId = getIdInput();
        String text = getInput("할일 내용");
        String nickname = getInput("닉네임");
        return new TaskReqDto(null, userId, text, nickname, new java.util.Date());
    }

    private static boolean processChoice(int choice) {
        switch (choice) {
            case 1:
                UserSignupReqDto signupRequest = createUserSignupRequest();
                userController.signUpUser(signupRequest);
                break;
            case 2:
                UserSigninReqDto signinRequest = createUserSigninRequest();
                userController.signInUser(signinRequest);
                break;
            case 3:
            	userController.service.logout();
                break;
            case 4:
                List<UserRespDto> users = userController.getAllUser();
                users.forEach(System.out::println);
                break;
            case 5:
                long id = getIdInput();
                UserRespDto user = userController.getUserById(id);
                System.out.println(user);
                break;
            case 6:
                id = getIdInput();
                userController.deleteUser(id);
                break;
            case 7:
                if (!isLoggedIn) {
                    System.out.println("로그인 후 이용해주세요.");
                    break;
                }
                TaskReqDto taskRequest = createTaskRequest();
                taskController.createTask(taskRequest);
                break;
            case 8:
                List<TaskRespDto> tasks = taskController.getAllTask();
                tasks.forEach(System.out::println);
                break;
            case 9:
                String text = getInput("검색할 할일 내용");
                tasks = taskController.filterTasksByText(text);
                tasks.forEach(System.out::println);
                break;
            case 10:
                if (!isLoggedIn) {
                    System.out.println("로그인 후 이용해주세요.");
                    break;
                }
                id = getIdInput();
                taskController.deleteTask(id);
                break;
            case 11:
                System.out.println("프로그램을 종료합니다. 감사합니다!");
                return false;
            default:
                System.out.println("잘못된 선택입니다. 다시 입력해주세요.");
                break;
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            while (true) {
                displayMenu();
                int choice = getChoice();
                if (!processChoice(choice)) break;
            }
        } catch (Exception e) {
            System.out.println("오류 발생: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}