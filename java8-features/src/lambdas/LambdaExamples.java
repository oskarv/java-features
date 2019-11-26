package lambdas;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

/**
 *   author: oskarv
 */
public class LambdaExamples {

    static class OldSchoolFileFilter implements FileFilter {
        @Override
        public boolean accept(File pathname) {
            return pathname.getName().endsWith(".java");
        }
    }

    public static void main(String [] argv) {
        // Old school way, create separate class and use it across the project
        FileFilter oldSchoolFileFilter = new OldSchoolFileFilter();
        File directory = new File("src\\test_files");
        File[] files = directory.listFiles(oldSchoolFileFilter);
        System.out.println(Arrays.toString(files));

        // anonymous class approach is valid if you need this type of filer only once
        FileFilter anonymousClassFileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".c");
            }
        };
        files = directory.listFiles(anonymousClassFileFilter);
        System.out.println(Arrays.toString(files));

        // lambda way, better ( more readable ) way of using anonymous classes
        FileFilter lambdaFileFilter = (File pathname) -> pathname.getName().endsWith(".js");
        files = directory.listFiles(lambdaFileFilter);
        System.out.println(Arrays.toString(files));
    }
}
