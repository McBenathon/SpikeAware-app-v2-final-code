void main() {

    Menu mainMenu = new Menu("1. Spiking", "2. Reporting", "3. Support", "4. Toolkit Contents", "5. Search", "6. Side Menu", "7. Resource Database");
    MenuWindow menu = new MenuWindow();
    Menu sideMenu = new Menu("1. Spiking", "2. Reporting", "3. Support", "4. Toolkit Contents", "5. Resource Database", "6. Add Resource", "7. Admin Login");
    MenuWindow side = new SideMenu(0);
    do {
        mainMenu.displayMenu();
        int choice = mainMenu.menuChoice();
        if (choice == 0) {
            System.out.println("invalid option chosen please try again.\n\n");
        }
        else {
            System.out.println("you have chosen option: " + choice);
            menu.getMenuButton(choice);
            while (true) {
                System.out.println("return to home (1) or use sideMenu (2): ");
                Scanner input = new Scanner(System.in);
                int inp = input.nextInt();
                switch (inp) {
                    case 1:
                        main();
                    case 2:
                        sideMenu.displayMenu();
                        int sideChoice = sideMenu.menuChoice();
                        side.getMenuButton(sideChoice);
                        continue;
                    default:
                        System.out.println("invalid option");
                }
            }

        }

    }while(true);

}

