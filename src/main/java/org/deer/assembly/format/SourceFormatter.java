package org.deer.assembly.format;

import static org.deer.assembly.Constants.LCB;
import static org.deer.assembly.Constants.NL;
import static org.deer.assembly.Constants.RCB;
import static org.deer.assembly.Constants.TAB;

import com.google.common.base.Strings;

public interface SourceFormatter {

    default String formatSource(final String source) {
        final String[] lines = source.split(NL);
        final StringBuilder output = new StringBuilder();
        int bracketCounter = 0;

        for (String line : lines) {
            if (line.isEmpty()) {
                // to not add tabulators to empty lines
                output.append(line).append(NL);
                continue;
            }

            // if left curly bracket is in line ,add tabulator
            if (line.contains(LCB)) {
                // adds first tabulator to tabulate definition of method,constructor,attribute,...
                outputFormattedLine(output, bracketCounter, line);
                // then adds second tabulator to tabulate content in block
                bracketCounter++;
                continue;// continues after output
            } else if (line.contains(RCB)) {
                /// if line contains right curly bracket,take away one tabulator
                bracketCounter--;
            }
            outputFormattedLine(output, bracketCounter, line);
        }

        return output.toString();
    }

    static void outputFormattedLine(final StringBuilder builder, final int bracketCounter, final String line) {
        // splits removes next line ,so adds it back
        builder.append(Strings.repeat(TAB, bracketCounter)).append(line).append(NL);
    }
}
