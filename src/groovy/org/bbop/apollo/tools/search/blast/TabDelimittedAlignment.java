package org.bbop.apollo.tools.search.blast;

import org.bbop.apollo.tools.search.AlignmentParsingException;

public class TabDelimittedAlignment extends BlastAlignment {

    private final static int EXPECTED_NUM_FIELDS = 12;
    private final static String DELIMITER = "\t";
    
    public TabDelimittedAlignment(String tabbedAlignment) throws AlignmentParsingException {
        String []fields = tabbedAlignment.split(DELIMITER);
        if (fields.length != EXPECTED_NUM_FIELDS) {
            throw new AlignmentParsingException("Incorrect number of fields: found " + fields.length + " but expected " + EXPECTED_NUM_FIELDS);
        }
        String queryId = fields[0];
        String subjectId = fields[1];
        double percentId = Double.parseDouble(fields[2]);
        int alignmentLength = Integer.parseInt(fields[3]);
        int numMismatches = Integer.parseInt(fields[4]);
        int numGaps = Integer.parseInt(fields[5]);
        int queryStart = Integer.parseInt(fields[6]);
        int queryEnd = Integer.parseInt(fields[7]);
        int subjectStart = Integer.parseInt(fields[8]);
        int subjectEnd = Integer.parseInt(fields[9]);
        double eValue = Double.parseDouble(fields[10]);
        double bitscore = Double.parseDouble(fields[11]);
        init(queryId, subjectId, percentId, alignmentLength, numMismatches, numGaps,
                queryStart, queryEnd, subjectStart, subjectEnd, eValue, bitscore);
    }
    
}
