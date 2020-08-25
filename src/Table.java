public class Table {

    public String[][] table;
    private int tempY = 0;
    boolean checkIsContainX = false;
    boolean checkIsContainO = false;

    int blankSpace = 0;

    public Table() {
        table = new String[][]{{"|", "_", "_", "_", "|"}, {"|", "_", "_", "_", "|"}, {"|", "_", "_", "_", "|"}};
    }

    public String getValueOnThePosition(int x, int y){
        tempY = 3 - y;
        return table[tempY][x];
    }

    public String getValueFromTable(int x, int y){
        return table[x][y];
    }

    public boolean setValueInTable(int x, int y, String xOrO) {
        tempY = 3 - y;
        if(!checkIsValueInTableXOrO(tempY,x)){
            this.table[tempY][x] = xOrO;
            return true;
        } else {
            return false;
        }
    }

    public boolean checkIsValueInTableXOrO(int x, int y) {
        checkIsContainX = this.table[x][y].contains("X");
        checkIsContainO = this.table[x][y].contains("O");

        if (checkIsContainX || checkIsContainO) {
            System.out.println("This cell is occupied! Choose another one!");
            checkIsContainX = false;
            checkIsContainO = false;
            return true;
        } else {
            return false;
        }
    }


    public boolean isBlankSpaces(String[][] table) {
        for (String[] tab : table) {
            for (String tab1 : tab) {
                if (tab1.equals("_")) blankSpace++;
            }
        }
        if (blankSpace == 0) {
            return false;
        }
        return true;
    }

    public void printTable() {
        System.out.println("---------");
        for (String[] rows : this.table) {
            for (String values : rows) {
                System.out.print(values + " ");
            }
            System.out.println();
        }
        System.out.println("---------");
    }


}
