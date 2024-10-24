public class RunningTime {

    int operations;

    String iterations;

    Queue codeToProcess;

    RunningTime[] children;

    public RunningTime(Queue code) {
        this.codeToProcess = code;

        this.operations = 0;

        this.iterations = "";

        this.children = null;
    }

    public void getRunningTime() {
        Boolean endBlock = false;

        while (this.codeToProcess.isEmpty() && !endBlock) {
            String line = this.codeToProcess.dequeue();
            if (line.matches("[a-zA-Z]+=.+")) {

                if(this.operations == 0){
                    this.iterations = this.iterations.concat("1");
                } else {
                    this.iterations = this.iterations.concat("1 + ");
                }

                this.operations++;
            }
        }
    }
}
