package by.tut.shershnev_s;

import by.tut.shershnev_s.service.FirstHomeWorkService;
import by.tut.shershnev_s.service.impl.FirstHomeWorkServiceImpl;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        FirstHomeWorkService exitTaskService = new FirstHomeWorkServiceImpl();
        exitTaskService.runFirstTask();
        exitTaskService.runSecondTask();
        exitTaskService.runThirdTask();
    }
}
