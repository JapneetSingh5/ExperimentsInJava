public class RaceCondition {
    // 2 types of race conditions

    // Read-Modify-Write
    // - multiple threads read a value
    // - modify the value according to the logic, in their cpu register
    // - write it back

    // Check-then-Act
    // - multiple threads check a value, at the same time
    // - find condition satisfied, first one acts
    // - rest will have condition satisfied but will get a problematic/unexpected value instead

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}