package reducer;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author dht925nerd@126.com
 */
public class WordCountReducer extends Reducer<Text, LongWritable, Text, LongWritable> {
    /**
     *
     * @param key 是一个集合, 其中每一个元素都是 v2
     * @param values
     * @param context
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
        long total = 0;
        for (LongWritable longWritable : values){
            total += longWritable.get();
        }
        context.write(key, new LongWritable(total));
    }
}
