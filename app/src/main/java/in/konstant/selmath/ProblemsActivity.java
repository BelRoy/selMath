package in.konstant.selmath;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class ProblemsActivity extends Activity {

    private static final String TAG = "Problems";
    private static final boolean DBG = true;

    private Random rng;
    private StringBuilder solutionBuilder;
    private TextView tvSolution;
    private int solution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problems);

        findViewById(R.id.button0).setOnClickListener(onNumpadClick);
        findViewById(R.id.button1).setOnClickListener(onNumpadClick);
        findViewById(R.id.button2).setOnClickListener(onNumpadClick);
        findViewById(R.id.button3).setOnClickListener(onNumpadClick);
        findViewById(R.id.button4).setOnClickListener(onNumpadClick);
        findViewById(R.id.button5).setOnClickListener(onNumpadClick);
        findViewById(R.id.button6).setOnClickListener(onNumpadClick);
        findViewById(R.id.button7).setOnClickListener(onNumpadClick);
        findViewById(R.id.button8).setOnClickListener(onNumpadClick);
        findViewById(R.id.button9).setOnClickListener(onNumpadClick);
        findViewById(R.id.buttonB).setOnClickListener(onNumpadClick);
        findViewById(R.id.buttonS).setOnClickListener(onNumpadClick);

        solutionBuilder = new StringBuilder();

        tvSolution = (TextView) findViewById(R.id.tvSolution);

        rng = new Random();
        rng.setSeed(System.currentTimeMillis());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    private View.OnClickListener onNumpadClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button0:
                    if (solutionBuilder.length() < 11)
                        solutionBuilder.append('0');
                    break;
                case R.id.button1:
                    if (solutionBuilder.length() < 11)
                        solutionBuilder.append('1');
                    break;
                case R.id.button2:
                    if (solutionBuilder.length() < 11)
                        solutionBuilder.append('2');
                    break;
                case R.id.button3:
                    if (solutionBuilder.length() < 11)
                        solutionBuilder.append('3');
                    break;
                case R.id.button4:
                    if (solutionBuilder.length() < 11)
                        solutionBuilder.append('4');
                    break;
                case R.id.button5:
                    if (solutionBuilder.length() < 11)
                        solutionBuilder.append('5');
                    break;
                case R.id.button6:
                    if (solutionBuilder.length() < 11)
                        solutionBuilder.append('6');
                    break;
                case R.id.button7:
                    if (solutionBuilder.length() < 11)
                        solutionBuilder.append('7');
                    break;
                case R.id.button8:
                    if (solutionBuilder.length() < 11)
                        solutionBuilder.append('8');
                    break;
                case R.id.button9:
                    if (solutionBuilder.length() < 11)
                        solutionBuilder.append('9');
                    break;
                case R.id.buttonB:
                    if (solutionBuilder.length() > 0) {
                        solutionBuilder.deleteCharAt(solutionBuilder.length() - 1);
                    }
                    break;
                case R.id.buttonS:
                    if (solution > 0) {
                        solutionBuilder.insert(0, '-');
                    }
                    else if (solution < 0) {
                        solutionBuilder.deleteCharAt(0);
                    }
                    break;
            }
            String s = solutionBuilder.toString();

            tvSolution.setText(s);

            if (s.length() > 0)
                solution = Integer.parseInt(s);
        }
    };
}
